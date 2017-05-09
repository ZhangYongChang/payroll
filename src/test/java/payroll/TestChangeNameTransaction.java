package payroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.transaction.AddHourlyEmployee;
import com.payroll.transaction.ChangeNameTransaction;

import junit.framework.Assert;

public class TestChangeNameTransaction {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

		// Add Salaried Employee
		int empId = 7;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 10.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);

		ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
		cnt.Execute();

		Assert.assertEquals(e.getName(), "Bob");
	}

}
