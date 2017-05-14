package payroll;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.paymentclassification.HourlyClassification;
import com.payroll.paymentclassification.TimeCard;
import com.payroll.transaction.AddHourlyEmployee;
import com.payroll.transaction.TimeCardTransaction;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestTimeCardTransaction {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

		// Add Hourly Employee
		int empId = 5;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 10.00f);
		t.Execute();

		Date date = new Date();
		TimeCardTransaction tcc = new TimeCardTransaction(empId, date, 8.0f);
		tcc.Execute();

		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);
		HourlyClassification hc = (HourlyClassification) e.getPaymentClassification();

		TimeCard tc = hc.getTimeCard(date);
		Assert.assertTrue(tc != null);
		Assert.assertEquals(tc.getHours(), 8.0f, 0.001f);
	}

}
