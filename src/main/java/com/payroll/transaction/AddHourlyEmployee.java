package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentschedule.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

	public AddHourlyEmployee(int empId, String name, String email, double hourlyRate) {
		super(empId, name, email);
		this.hourlyRate = hourlyRate;
	}

	@Override
	PaymentClassification getPaymentClassification() {
		return new HourlyClassification(this.hourlyRate);
	}

	@Override
	PaymentSchedule getPaymentSchedule() {
		return new WeeklySchedule();
	}

	private double hourlyRate;

}
