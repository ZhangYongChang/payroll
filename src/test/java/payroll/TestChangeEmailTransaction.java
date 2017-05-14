package payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.transaction.AddHourlyEmployee;
import com.payroll.transaction.ChangeEmailTransaction;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestChangeEmailTransaction {

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
		int empId = 8;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 10.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);

		ChangeEmailTransaction cnt = new ChangeEmailTransaction(empId, "BeiJing");
		cnt.Execute();

		Assert.assertEquals(e.getEmail(), "BeiJing");
	}

}
