package com.n26.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.n26.bean.StatisticsResponseBean;
import com.n26.util.IConstants;

import exception.CustomException;
import exception.ExceptionBean;

@Service
public class TransactionProcessor {
	public static final Map<Long, String> cache = new ConcurrentHashMap<>();

	/**
	 * This method adds the transaction to the cache
	 * 
	 * @param transactionInputBean
	 * @return
	 */
	public HttpStatus addTransaction(Map<String, String> transactionInputBean) {

		HttpStatus httpStatus;

		if (compareTime(transactionInputBean.get("timestamp")) > 60) {
			httpStatus = HttpStatus.NO_CONTENT;
			cache.put(System.currentTimeMillis(), transactionInputBean.get("amount"));
		} else if (compareTime(transactionInputBean.get("timestamp")) < 0) {
			httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
		} else {
			httpStatus = HttpStatus.CREATED;
			cache.put(parseTime(transactionInputBean.get("timestamp")), transactionInputBean.get("amount"));
		}

		return httpStatus;
	}

	/**
	 * This method compares the input string to current time
	 */
	public static long compareTime(String input) {

		TimeZone utc = TimeZone.getTimeZone("UTC");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		f.setTimeZone(utc);
		GregorianCalendar cal = new GregorianCalendar(utc);
		try {
			cal.setTime(f.parse(input));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.PARSINGERROR)
					.setExceptionMessage(IConstants.PARSINGERROR));
		}
		GregorianCalendar cal2 = new GregorianCalendar(utc);
		cal2.setTime(new Date());

		return (cal2.getTimeInMillis() - cal.getTimeInMillis()) / 1000;
	}

	/**
	 * This method parses the time to long format
	 * 
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static long parseTime(String input) {
		TimeZone utc = TimeZone.getTimeZone("UTC");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		f.setTimeZone(utc);
		GregorianCalendar cal = new GregorianCalendar(utc);
		try {

			cal.setTime(f.parse(input));
		} catch (ParseException e) {

			throw new CustomException((new ExceptionBean()).setExceptionCode(IConstants.PARSINGERROR)
					.setExceptionMessage(IConstants.PARSINGERROR));
		}

		return cal.getTimeInMillis();
	}

	/**
	 * This method deletes the transactions from the cache
	 * 
	 * @return
	 */
	public HttpStatus deleteTransaction() {
		cache.clear();
		return HttpStatus.NO_CONTENT;
	}


/**
 * 	
 * @return
 */
	public StatisticsResponseBean getStats() {

		DoubleSummaryStatistics summaryStatistics = cache.entrySet().stream()
				.filter(n -> TransactionProcessor.compareTime(n.getKey().toString()) < 60).map(v -> v.getValue())
				.collect(Collectors.summarizingDouble(m -> new Double(m)));
		return new StatisticsResponseBean().setAvg(summaryStatistics.getAverage() + "")
				.setMax(summaryStatistics.getMax() + "").setMin(summaryStatistics.getMin() + "")
				.setSum(summaryStatistics.getSum() + "").setCount(summaryStatistics.getCount());

	}
}
