import static org.junit.Assert.*;

import org.junit.Test;

import AccountManagmentSystem.Account;
import AccountManagmentSystem.Checking;
import AccountManagmentSystem.Customer;

public class CheckingTestCases {

	@Test
	public void withdrawlForChecking() {
		Account c1=new Checking();
		Customer c=new Customer();	
		c.setPhNo(10);
		c1.setBalance(0);
		c1.setBank("HBL");
		c1.setDateCreated(java.time.LocalDate.now());
		c.setAddress("F-11");
		c.setName("Rizwan");		
		c1.setType('C');
		c1.setCustomer(c);
		c1.setAccNo(1);
		
		c1.makeDeposit(200000); //1st transaction
		c1.deduction();
		
		c1.withdrawl(20000); //2nd transaction
		c1.deduction();
		
		double val=200000-20000;
		double x=c1.checkBalance(); 
		
		assertEquals(x, val,0);
		assertNotEquals(x, val-10,0);
		
		c1.withdrawl(20000); //3rd transaction
		c1.deduction();
		
		val=200000-20000-20000-10;
		x=c1.checkBalance();
		assertEquals(x, val,0);
		assertNotEquals(x, val+10,0);//to check if deduction does not happened		
		
	}
	

}
