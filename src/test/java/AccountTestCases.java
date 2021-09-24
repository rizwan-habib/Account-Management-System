import static org.junit.Assert.*;


import org.junit.Test;

import AccountManagmentSystem.Account;
import AccountManagmentSystem.Checking;
import AccountManagmentSystem.Customer;
//import AccountManagmentSystem.Saving;
import AccountManagmentSystem.Statement;

public class AccountTestCases {

	@Test
	public void depositTest() {
		Customer c=new Customer();
		Account c1=new Checking();
		c.setPhNo(10);
		c1.setBalance(0);
		c1.setBank("HBL");
		c1.setDateCreated(java.time.LocalDate.now());
		c.setAddress("F-11");
		c.setName("Rizwan");
		c1.setType('C');
		c1.setCustomer(c);
		c1.setAccNo(1);
		c1.makeDeposit(100);
		double x=c1.checkBalance();
		assertEquals(x, 100.0,0);
		assertNotEquals(x, 0,0);
	}
	
	@Test
	public void zakatTest() {
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
		c1.makeDeposit(100);
		double x=c1.calculateZakat();
		assertEquals(x, 0.0,0);
		c1.makeDeposit(20000);
		double val=(20100*2.5d)/100;
		x=c1.calculateZakat();
		assertEquals(x, val,0);
		assertNotEquals(x, 0,0);
	}
	@Test
	public void printStatementTest() {
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
		
//		c1.displayAllDeductions();
		
		Statement s1=new Statement();
		s1.setAccNo(1);
		s1.setAmount(200000);
		s1.setCustomer(c);
		s1.setRemBalance(200000);
		s1.setDate(java.time.LocalDate.now().toString());
		c1.statements.add(s1);
		String x=c1.printStatement();
		String val="Rizwan"+"F-11"+"10"+1+"200000.0"+java.time.LocalDate.now().toString()+200000.0;
		
		assertEquals(x, val);
	}
	
}
