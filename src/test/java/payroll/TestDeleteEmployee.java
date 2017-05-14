package payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.transaction.AddSalariedEmployee;
import com.payroll.transaction.DeleteEmployeeTransaction;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestDeleteEmployee {

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
		int empId = 4;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);

		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.Execute();
		e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e == null);
	}

}
