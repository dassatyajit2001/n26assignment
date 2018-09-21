package com.n26.bean;

public class StatisticsResponseBean {

private String sum;
private String avg;
private String max;
private String min;
private long count;
/**
 * @return the sum
 */
public String getSum() {
	return sum;
}
/**
 * @param sum the sum to set
 */
public StatisticsResponseBean setSum(String sum) {
	this.sum = sum;
	return this;
}
/**
 * @return the avg
 */
public String getAvg() {
	return avg;
}
/**
 * @param avg the avg to set
 */
public StatisticsResponseBean setAvg(String avg) {
	this.avg = avg;
	return this;
}
/**
 * @return the max
 */
public String getMax() {
	return max;
}
/**
 * @param max the max to set
 */
public StatisticsResponseBean setMax(String max) {
	this.max = max;
	return this;
}
/**
 * @return the min
 */
public String getMin() {
	return min;
}
/**
 * @param min the min to set
 */
public StatisticsResponseBean setMin(String min) {
	this.min = min;
	return this;
}
/**
 * @return the count
 */
public long getCount() {
	return count;
}
/**
 * @param count the count to set
 */
public StatisticsResponseBean setCount(long count) {
	this.count = count;
	return this;
}


}
