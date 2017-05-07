package com.payroll.affiliation;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.payroll.core.Affiliation;

public class UnionAffiliation implements Affiliation {

	public UnionAffiliation(int memberId, double cost) {
		this.setMemberId(memberId);
		this.setCost(cost);
		this.serviceCharges = new LinkedList<ServiceCharge>();
	}

	@Override
	public double CalculateDeductions() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServiceCharge getServiceCharge(Date date) {
		Iterator<ServiceCharge> iter = this.serviceCharges.iterator();
		while (iter.hasNext()) {
			ServiceCharge serviceCharge = iter.next();
			if (serviceCharge.getDate().equals(date)) {
				return serviceCharge;
			}
		}

		return null;
	}

	public void addServiceCharge(ServiceCharge serviceCharge) {
		this.serviceCharges.add(serviceCharge);
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	private int memberId;
	private double cost;
	private List<ServiceCharge> serviceCharges;

}
