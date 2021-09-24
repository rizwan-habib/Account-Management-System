/**
 * 
 */
package AccountManagmentSystem;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Iterator;
/**
 * @author Rizwan Habib
 *
 */
public abstract class Account {
	protected Customer customer;
	protected int AccNo;
	protected double balance;
	protected LocalDate dateCreated;
	protected String bank;
	protected char type;
	public ArrayList<Statement> statements = new ArrayList<Statement>();
	protected ArrayList<String> deductions = new ArrayList<String>();
	public Account() {
	
		// TODO Auto-generated constructor stub
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	

	public void makeDeposit(double amount) {
		balance+=amount;
	}
	public double checkBalance(){
		System.out.println("\nName: "+customer.getName());
		System.out.println("Account No. "+AccNo);
		System.out.println("Balance: "+balance);
		return balance;
	}
	 
	public String printStatement() {
		String x="";
		for (int i = 0; i < statements.size(); i++) {
			x+=statements.get(i).getCustomer().getName()+statements.get(i).getCustomer().getAddress()+statements.get(i).getCustomer().getPhNo()+statements.get(i).getAccNo()+statements.get(i).getAmount()+statements.get(i).getDate()+statements.get(i).getRemBalance();
			System.out.println("\nName: "+statements.get(i).getCustomer().getName());
			System.out.println("Address: "+statements.get(i).getCustomer().getAddress());
			System.out.println("Phone No: "+statements.get(i).getCustomer().getPhNo());
			System.out.println("Account No: "+statements.get(i).getAccNo());
			System.out.println("Amount: "+statements.get(i).getAmount());
			System.out.println("Date: "+statements.get(i).getDate());
			System.out.println("Balance: "+statements.get(i).getRemBalance()+"\n\n");
		}
		return x;
	}
	public double calculateZakat() {
		if(balance >= 20000) {
            System.out.print("Zakat:"+(balance*2.5d)/100+"\n");
            return (balance*2.5d)/100;
        } else {
            System.out.println("Your Balance is less than 20000.");
            return 0;
        }
	}
	public abstract void displayAllDeductions();
	public abstract void setInterest(double inter);
	public abstract double CalculateInterest(); 
	public abstract void withdrawl(double amount);
	public abstract boolean deduction();
}
