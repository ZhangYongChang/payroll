package com.payroll.paymentclassification;

import com.payroll.core.PayCheck;
import com.payroll.core.PaymentClassification;

public class SalariedClassification implements PaymentClassification {

	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	@Override
	public double CalculatePay(PayCheck pc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getSalary() {
		return this.salary;
	}

	private double salary;

}
