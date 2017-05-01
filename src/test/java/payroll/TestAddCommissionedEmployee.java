package payroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.payroll.PayrollDatabase;
import com.payroll.core.Employee;
import com.payroll.paymentclassification.CommissionedClassification;
import com.payroll.paymentclassification.SalariedClassification;
import com.payroll.paymentmethod.HoldMethod;
import com.payroll.paymentschedule.MonthlySchedule;
import com.payroll.transaction.AddCommissionedEmployee;
import com.payroll.transaction.AddSalariedEmployee;

import junit.framework.Assert;

public class TestAddCommissionedEmployee {

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
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob", "Home", 1000.00f, 1000.00f);
		t.Execute();

		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);
		Assert.assertEquals(e.getName(), "Bob");
		Assert.assertEquals(e.getEmail(), "Home");

		CommissionedClassification sc = (CommissionedClassification) (e.getPaymentClassification());
		Assert.assertTrue(sc != null);
		Assert.assertEquals(sc.getSalary(), 1000.00, 0.001);
		Assert.assertEquals(sc.getCommissionRate(), 1000.00, 0.001);

		MonthlySchedule ms = (MonthlySchedule) e.getPaymentSchedule();
		Assert.assertTrue(ms != null);

		HoldMethod hm = (HoldMethod) e.getPaymentMethod();
		Assert.assertTrue(hm != null);
	}

}
