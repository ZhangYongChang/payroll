package com.payroll;

import java.util.HashMap;
import java.util.Map;

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
		memberIdEmployeeMap = new HashMap<Integer, Employee>();
	}

	public Employee getEmployeeById(int empId) {
		return employees.get(empId);
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

	public Employee getUnionMember(int memberId) {
		return memberIdEmployeeMap.get(memberId);
	}

	public void addUnionMember(int memberId, Employee employee) {
		memberIdEmployeeMap.put(memberId, employee);
	}

	private Map<Integer, Employee> employees;
	private Map<Integer, Employee> memberIdEmployeeMap;
	private static PayrollDatabase payrollDatabase;

}
