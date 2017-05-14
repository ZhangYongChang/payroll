package payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.payroll.PayrollDatabase;
import com.payroll.affiliation.UnionAffiliation;
import com.payroll.core.Employee;
import com.payroll.transaction.AddHourlyEmployee;
import com.payroll.transaction.ChangeMemberTransaction;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestChangeMemberTransaction {

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
		int empId = 10;
		int memberId = 7734;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 10.00f);
		t.Execute();
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
		cmt.Execute();
		//
		Employee e = payrollDatabase.getEmployeeById(empId);
		Assert.assertTrue(e != null);

		UnionAffiliation affiliation = (UnionAffiliation) e.getAffiliation();
		Assert.assertTrue(affiliation != null);

		Assert.assertEquals(99.42, affiliation.getCost(), 0.01);
		e = payrollDatabase.getUnionMember(memberId);
		Assert.assertTrue(e != null);
	}

}
