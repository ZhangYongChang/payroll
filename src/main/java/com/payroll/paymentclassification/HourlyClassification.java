package com.payroll.paymentclassification;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.payroll.core.PayCheck;
import com.payroll.core.PaymentClassification;

public class HourlyClassification implements PaymentClassification {

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
		timeCards = new LinkedList<TimeCard>();
	}

	@Override
	public double CalculatePay(PayCheck pc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void AddTimeCard(TimeCard timeCard) {
		timeCards.add(timeCard);
	}

	public TimeCard getTimeCard(Date date) {
		Iterator<TimeCard> iter = timeCards.iterator();
		while (iter.hasNext()) {
			TimeCard tc = iter.next();
			if (tc.getDate().equals(date)) {
				return tc;
			}
		}

		return null;
	}

	private List<TimeCard> timeCards;

	private double hourlyRate;

}
