package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;
import com.payroll.paymentclassification.SalariedClassification;
import com.payroll.paymentschedule.MonthlySchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

	public AddSalariedEmployee(int empId, String name, String email, double salary) {
		super(empId, name, email);
		this.salary = salary;
	}

	@Override
	PaymentClassification getPaymentClassification() {
		PaymentClassification paymentClassification = new SalariedClassification(this.salary);
		return paymentClassification;
	}

	@Override
	PaymentSchedule getPaymentSchedule() {
		return new MonthlySchedule();
	}

	private double salary;

}
