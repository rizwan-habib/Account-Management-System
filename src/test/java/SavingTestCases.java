import static org.junit.Assert.*;

import org.junit.Test;

import AccountManagmentSystem.Account;
import AccountManagmentSystem.Customer;
import AccountManagmentSystem.Saving;

public class SavingTestCases {

		@Test
		public void withdrawlforSaving() {
			Account c1=new Saving();
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
			
			val=200000-20000-20000;
			x=c1.checkBalance();
			assertEquals(x, val,0);
			assertNotEquals(x, val+10,0);//to check if deduction does not happened		
		}
		@Test
		public void interestTest() {
			Saving c1=new Saving();
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
			
			double x=c1.CalculateInterest();
			double val=0;
			assertEquals(x, val,0);
			val=c1.getInterest()*c1.checkBalance();
			
//			c1.displayAllDeductions();

			assertNotEquals(x, val+10,0);
					
		}
		

}
