package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentschedule.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

	public ChangeHourlyTransaction(int empId, double hourlyRate) {
		super(empId);
		this.setHourlyRate(hourlyRate);
	}

	@Override
	PaymentClassification getClassification() {
		return new HourlyClassification(getHourlyRate());
	}

	@Override
	PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	private double hourlyRate;

}
