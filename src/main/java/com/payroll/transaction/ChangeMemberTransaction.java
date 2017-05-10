package com.payroll.transaction;

import com.payroll.PayrollDatabase;
import com.payroll.affiliation.UnionAffiliation;
import com.payroll.core.Affiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

	public ChangeMemberTransaction(int empId, int memberId, double amount) {
		super(empId);
		this.memberId = memberId;
		this.amount = amount;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Affiliation getAffiliation() {
		return new UnionAffiliation(this.memberId, this.amount);
	}

	@Override
	public void updateMemberShip() {
		PayrollDatabase.getPayrollDatabase().addUnionMember(memberId, getEmployee());
	}

	private int memberId;
	private double amount;

}
