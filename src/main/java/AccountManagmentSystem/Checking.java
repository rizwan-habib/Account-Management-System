package AccountManagmentSystem;

import java.time.LocalDate;

public class Checking extends Account {
	public int freeCount;
	public LocalDate Created;
	public  Checking() {
		super();
		Created=java.time.LocalDate.now();
		freeCount=2;
		// TODO Auto-generated constructor stub
	}
	public void withdrawl(double amount) {
		if(balance-amount>=-5000) {
			balance-=amount;
		}
		else {
			System.out.print("Please clear your outstanding charges first\n");
		}
	}
	@Override
	public boolean deduction() { 
		// TODO Auto-generated method stub
		if (java.time.LocalDate.now().getMonthValue() - Created.getMonthValue()>0) {
			freeCount=2;
		}
		if (freeCount<=0) {
			balance-=10;
//			System.out.print("bye!!!!!!!!!!\n");
			return true;
		}
		else {
			freeCount--;
//			System.out.print("hello!!!!!!!!!!!!!!\n");
			return false;
		}
	}
	@Override
	public void setInterest(double val) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double CalculateInterest() {
		// TODO Auto-generated method stub
		return 0;
		
	}
	@Override
	public void displayAllDeductions() {
		// TODO Auto-generated method stub
		System.out.println("Tax: "+String.valueOf(balance*0.15));
		for (int i = 0; i < deductions.size(); i++) {
			System.out.println(deductions.get(i)+"  Charge: 10");
		}
	}
	
}
