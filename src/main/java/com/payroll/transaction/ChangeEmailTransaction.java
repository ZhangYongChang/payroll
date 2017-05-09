package com.payroll.transaction;

public class ChangeEmailTransaction extends ChangeEmployeeTransaction {

	public ChangeEmailTransaction(int empId, String email) {
		super(empId);
		this.setEmail(email);
	}

	@Override
	void Change() {
		getEmployee().setEmail(getEmail());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;

}
