package payroll;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.affiliation.ServiceCharge;
import com.payroll.affiliation.UnionAffiliation;
import com.payroll.core.Employee;
import com.payroll.transaction.AddHourlyEmployee;
import com.payroll.transaction.ServiceChargeTransaction;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestAddServiceCharge {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

		int empId = 6;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 10.00f);
		t.Execute();

		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);

		int memberId = 86;
		UnionAffiliation unionAffiliation = new UnionAffiliation(memberId, 12.5);
		e.addAffiliation(unionAffiliation);

		payrollDatabase.addUnionMember(memberId, e);

		Date date = new Date();
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, date, 12.95);
		sct.Execute();
		ServiceCharge sc = unionAffiliation.getServiceCharge(date);
		Assert.assertTrue(sc != null);
		Assert.assertEquals(12.95, sc.getAmount(), 0.01);
	}

}
