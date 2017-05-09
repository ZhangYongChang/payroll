package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction(int empId) {
		super(empId);
	}

	abstract PaymentClassification getClassification();

	abstract PaymentSchedule getSchedule();

	@Override
	void Change() {
		getEmployee().setPaymentClassification(getClassification());
		getEmployee().setPaymentSchedule(getSchedule());
	}

}
