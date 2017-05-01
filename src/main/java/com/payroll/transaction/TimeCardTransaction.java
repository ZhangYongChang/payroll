package com.payroll.transaction;

import java.util.Date;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.core.Transaction;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentclassification.TimeCard;

public class TimeCardTransaction implements Transaction {

	public TimeCardTransaction(int empId, Date date, double hourlyRate) {
		this.empId = empId;
		this.date = date;
		this.hours = hourlyRate;

	}

	@Override
	public void Execute() {
		PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();
		Employee e = payrollDatabase.getEmployeeById(this.empId);
		HourlyClassification hc = null;
		if (e != null) {
			hc = (HourlyClassification) e.getPaymentClassification();
		}

		if (hc != null) {
			TimeCard tc = new TimeCard(date, hours);
			hc.AddTimeCard(tc);
		}
	}

	private int empId;
	private Date date;
	private double hours;

}
