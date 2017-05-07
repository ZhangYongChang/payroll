package com.payroll.affiliation;

import java.util.Date;

public class ServiceCharge {
	public ServiceCharge(double amount, Date date) {
		this.amount = amount;
		this.setDate(date); 
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private double amount;
	private Date date;

}
