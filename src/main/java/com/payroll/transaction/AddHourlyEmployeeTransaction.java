package com.payroll.transaction;

import com.payroll.core.PaymentClassification;
import com.payroll.core.PaymentSchedule;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

	public AddHourlyEmployeeTransaction(int empId, String name, String email) {
		super(empId, name, email);
	}

	PaymentClassification getPaymentClassification() {
		return null;
	}

	PaymentSchedule getPaymentSchedule() {
		return null;
	}

}
