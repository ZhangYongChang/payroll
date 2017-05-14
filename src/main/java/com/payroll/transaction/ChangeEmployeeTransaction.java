package com.payroll.transaction;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.core.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {

	public ChangeEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void Execute() {
		this.setEmployee(PayrollDatabase.getPayrollDatabase().getEmployeeById(empId));
		Change();
	}

	abstract void Change();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private int empId;
	private Employee employee;

}
