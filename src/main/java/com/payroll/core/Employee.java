package com.payroll.core;

public class Employee {

	public Employee(int empId, String name, String email) {
		this.empId = empId;
		this.name = name;
		this.email = email;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Affiliation getAffiliation() {
		return affiliation;
	}

	public void addAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentClassification getPaymentClassification() {
		return paymentClassification;
	}

	public void setPaymentClassification(PaymentClassification paymentClassification) {
		this.paymentClassification = paymentClassification;
	}

	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	private int empId;
	private String name;
	private String email;

	private Affiliation affiliation;
	private PaymentMethod paymentMethod;
	private PaymentClassification paymentClassification;
	private PaymentSchedule paymentSchedule;

}
