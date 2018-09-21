package com.n26.bean;

import java.math.BigDecimal;

public class TransactionBean {

	private BigDecimal amount;
	private String timestamp;
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public TransactionBean setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public TransactionBean setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	
}
