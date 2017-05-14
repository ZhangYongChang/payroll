package payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentmethod.HoldMethod;
import com.payroll.paymentschedule.WeeklySchedule;
import com.payroll.transaction.AddHourlyEmployee;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestAddHourlyEmployee {

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
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 10.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);
		Assert.assertEquals(e.getName(), "Bob");
		Assert.assertEquals(e.getEmail(), "Home");

		HourlyClassification sc = (HourlyClassification)e.getPaymentClassification();
		Assert.assertTrue(sc != null);
		Assert.assertEquals(sc.getHourlyRate(), 10.00, 0.001);

		WeeklySchedule ms = (WeeklySchedule) e.getPaymentSchedule();
		Assert.assertTrue(ms != null);

		HoldMethod hm = (HoldMethod) e.getPaymentMethod();
		Assert.assertTrue(hm != null);
	}

}
