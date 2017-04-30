package com.payroll.transaction;

import com.payroll.core.Transaction;
import com.payroll.paymentmethod.HoldMethod;
import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentMethod;
import com.payroll.core.PaymentSchedule;
import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;

abstract class AddEmployeeTransaction implements Transaction {

	public AddEmployeeTransaction(int empId, String name, String email) {
		this.empId = empId;
		this.name = name;
		this.email = email;
	}

	abstract PaymentClassification getPaymentClassification();

	abstract PaymentSchedule getPaymentSchedule();

	@Override
	public void Execute() {
		// create Employee
		Employee employee = new Employee(this.empId, this.name, this.email);

		// create PaymentClassification
		PaymentClassification paymentClassification = getPaymentClassification();
		employee.setPaymentClassification(paymentClassification);

		// create PaymentSchedule
		PaymentSchedule paymentSchedule = getPaymentSchedule();
		employee.setPaymentSchedule(paymentSchedule);

		// create PaymentMethod
		PaymentMethod paymentMethod = new HoldMethod();
		employee.setPaymentMethod(paymentMethod);

		PayrollDatabase.getPayrollDatabase().addEmployee(empId, employee);
	}

	private int empId;
	private String name;
	private String email;

}
