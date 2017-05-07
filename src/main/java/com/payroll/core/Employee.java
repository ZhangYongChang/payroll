package com.payroll.core;

import java.util.LinkedList;
import java.util.List;

public class Employee {

	public Employee(int empId, String name, String email) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.affiliations = new LinkedList<Affiliation>();
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

	public List<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void addAffiliation(Affiliation affiliation) {
		this.affiliations.add(affiliation);
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

	private List<Affiliation> affiliations;
	private PaymentMethod paymentMethod;
	private PaymentClassification paymentClassification;
	private PaymentSchedule paymentSchedule;

}
