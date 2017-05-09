package com.payroll.transaction;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

	public ChangeNameTransaction(int empId, String name) {
		super(empId);
		this.setName(name);
	}

	@Override
	void Change() {
		getEmployee().setName(getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

}
