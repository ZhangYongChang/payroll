package com.payroll.transaction;

import com.payroll.core.Employee;
import com.payroll.core.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

	public ChangeMethodTransaction(int empId) {
		super(empId);
	}

	public abstract PaymentMethod getMethod();

	@Override
	void Change() {
		Employee e = getEmployee();
		if (e != null) {
			e.setPaymentMethod(getMethod());
		}
	}

}
