package com.payroll.paymentclassification;

import com.payroll.core.PayCheck;
import com.payroll.core.PaymentClassification;

public class CommissionedClassification implements PaymentClassification {

	public CommissionedClassification(double commissionRate, double salary) {
		this.commissionRate = commissionRate;
		this.salary = salary;
	}

	@Override
	public double CalculatePay(PayCheck pc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private double commissionRate;
	private double salary;

}
