package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

	public ChangeSalariedTransaction(int empId) {
		super(empId);
		// TODO Auto-generated constructor stub
	}

	@Override
	PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

}
