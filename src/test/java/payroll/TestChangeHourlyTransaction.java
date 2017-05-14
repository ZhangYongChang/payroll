package payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentschedule.WeeklySchedule;
import com.payroll.transaction.AddCommissionedEmployee;
import com.payroll.transaction.ChangeHourlyTransaction;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestChangeHourlyTransaction {

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
		int empId = 9;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob", "Home", 1000.00f, 1000.00f);
		t.Execute();
		
		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
		cht.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);
		
		HourlyClassification hc = (HourlyClassification)e.getPaymentClassification();
		Assert.assertTrue(hc != null);
		Assert.assertEquals(27.52, hc.getHourlyRate(), 0.01);


		WeeklySchedule ws = (WeeklySchedule) e.getPaymentSchedule();
		Assert.assertTrue(ws != null);
	}
}
