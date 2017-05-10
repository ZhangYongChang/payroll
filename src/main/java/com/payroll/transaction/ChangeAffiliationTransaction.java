package com.payroll.transaction;

import com.payroll.core.Affiliation;
import com.payroll.core.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

	public ChangeAffiliationTransaction(int empId) {
		super(empId);
		// TODO Auto-generated constructor stub
	}

	public abstract Affiliation getAffiliation();
	
	public abstract void updateMemberShip();

	@Override
	void Change() {
		updateMemberShip();
		Employee e = getEmployee();
		if (e != null) {
			e.addAffiliation(getAffiliation());
		}
	}

}
