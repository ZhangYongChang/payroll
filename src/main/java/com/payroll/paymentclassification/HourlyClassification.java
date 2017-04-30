package com.payroll.paymentclassification;

import com.payroll.core.PayCheck;
import com.payroll.core.PaymentClassification;

public class HourlyClassification implements PaymentClassification {

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double CalculatePay(PayCheck pc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	private double hourlyRate;

}
