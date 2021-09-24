package AccountManagmentSystem;

//import java.time.LocalDate;

public class Saving extends Account {
	private double interest;

	public Saving() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void withdrawl(double amount) {
		if(balance-amount>=0) {
			balance-=amount;
		}
		else {
			System.out.print("Entered amount is not valid\n");
		}
	}

	@Override
	public boolean deduction() {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public double CalculateInterest() {
		// TODO Auto-generated method stub
		
		int years=java.time.LocalDate.now().getYear() - dateCreated.getYear();
		System.out.print("\nInterest Rate is: "+balance*interest*years+"\n");
		System.out.print("\nInterest Rate is 0 if year is less than 1 \n");
		return balance*interest*years;
	}

	@Override
	public void displayAllDeductions() {
		// TODO Auto-generated method stub
		System.out.print("Zakat: ");
		calculateZakat();
		for (int i = 0; i < deductions.size(); i++) {
			System.out.println(deductions.get(i)+"  Charge: 10");
		}
	}
}
