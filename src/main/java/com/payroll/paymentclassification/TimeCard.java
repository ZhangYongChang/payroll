package com.payroll.paymentclassification;

import java.util.Date;

public class TimeCard {

	public TimeCard(Date date, int hours) {
		this.date = date;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	private Date date;
	private int hours;

}
