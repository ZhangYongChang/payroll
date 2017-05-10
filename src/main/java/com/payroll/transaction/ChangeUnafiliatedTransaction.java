package com.payroll.transaction;

import com.payroll.core.Affiliation;

public class ChangeUnafiliatedTransaction extends ChangeAffiliationTransaction {

	public ChangeUnafiliatedTransaction(int empId) {
		super(empId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Affiliation getAffiliation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMemberShip() {
		// TODO Auto-generated method stub
		
	}

}
