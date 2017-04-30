package com.payroll.transaction;

import com.payroll.PayrollDatabase;
import com.payroll.core.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void Execute() {
		PayrollDatabase.getPayrollDatabase().deleteEmployee(empId);
	}

	private int empId;
}
