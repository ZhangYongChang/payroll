package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;
import com.payroll.paymentclassification.CommissionedClassification;
import com.payroll.paymentschedule.MonthlySchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

	public AddCommissionedEmployee(int empId, String name, String email, double commissionRate, double salary) {
		super(empId, name, email);
		this.commissionRate = commissionRate;
		this.salary = salary;

	}

	@Override
	PaymentClassification getPaymentClassification() {
		return new CommissionedClassification(commissionRate, salary);
	}

	@Override
	PaymentSchedule getPaymentSchedule() {
		return new MonthlySchedule();
	}

	private double commissionRate;
	private double salary;

}
