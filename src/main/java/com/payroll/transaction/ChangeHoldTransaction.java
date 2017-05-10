package com.payroll.transaction;

import com.payroll.core.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

	public ChangeHoldTransaction(int empId) {
		super(empId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
