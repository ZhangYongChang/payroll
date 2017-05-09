package com.payroll.transaction;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.payroll.PayrollDatabase;
import com.payroll.affiliation.ServiceCharge;
import com.payroll.affiliation.UnionAffiliation;
import com.payroll.core.Affiliation;
import com.payroll.core.Employee;
import com.payroll.core.Transaction;

public class ServiceChargeTransaction implements Transaction {

	public ServiceChargeTransaction(int memberId, Date date, double amount) {
		this.memberId = memberId;
		this.date = date;
		this.amount = amount;
	}

	@Override
	public void Execute() {
		Employee e = PayrollDatabase.getPayrollDatabase().getUnionMember(memberId);
		UnionAffiliation affiliation = (UnionAffiliation) e.getAffiliation();
		if (affiliation != null) {
			affiliation.addServiceCharge(new ServiceCharge(amount, date));
		}
	}

	private int memberId;
	private Date date;
	private double amount;

}
