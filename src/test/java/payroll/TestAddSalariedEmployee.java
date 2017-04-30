package payroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.core.PaymentClassification;
import com.payroll.paymentclassification.SalariedClassification;
import com.payroll.paymentmethod.HoldMethod;
import com.payroll.paymentschedule.MonthlySchedule;
import com.payroll.transaction.AddSalariedEmployee;

import junit.framework.Assert;

public class TestAddSalariedEmployee {

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
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);
		Assert.assertEquals(e.getName(), "Bob");
		Assert.assertEquals(e.getEmail(), "Home");

		PaymentClassification pc = e.getPaymentClassification();
		Assert.assertTrue(pc != null);
		SalariedClassification sc = (SalariedClassification) (pc);
		Assert.assertTrue(sc != null);
		Assert.assertEquals(sc.getSalary(), 1000.00f);

		MonthlySchedule ms = (MonthlySchedule) e.getPaymentSchedule();
		Assert.assertTrue(ms != null);

		HoldMethod hm = (HoldMethod) e.getPaymentMethod();
		Assert.assertTrue(hm != null);
	}

}
