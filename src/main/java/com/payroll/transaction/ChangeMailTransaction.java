package com.payroll.transaction;

import com.payroll.core.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {

	public ChangeMailTransaction(int empId) {
		super(empId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
