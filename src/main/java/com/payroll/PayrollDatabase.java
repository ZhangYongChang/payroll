package com.payroll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.payroll.core.Employee;

public class PayrollDatabase {

	public static PayrollDatabase getPayrollDatabase() {
		if (payrollDatabase == null) {
			payrollDatabase = new PayrollDatabase();
		}

		return payrollDatabase;
	}

	private PayrollDatabase() {
		employees = new HashMap<Integer, Employee>();
	}

	public Employee getEmployeeById(int empId) {
		int mapSize = employees.size();
		Iterator<Entry<Integer, Employee>> iter = employees.entrySet().iterator();
		for (int i = 0; i < mapSize; ++i) {
			Map.Entry<Integer, Employee> entry = iter.next();
			if (entry.getKey().equals(empId)) {
				return entry.getValue();
			}
		}

		return null;
	}

	public void addEmployee(int empId, Employee employee) {
		employees.put(empId, employee);
	}

	public void clear() {
		employees.clear();
	}

	public void deleteEmployee(int empId) {
		employees.remove(empId);
	}

	private Map<Integer, Employee> employees;
	private static PayrollDatabase payrollDatabase;

}
