package AccountManagmentSystem;

public class Statement {
	Customer customer;
	private int AccNo;
	private String Date;
	private double amount,remBalance;
	public Statement() {
		// TODO Auto-generated constructor stub
	}
	public Statement(Customer customer, int accNo, String date, double amount, double remBalance) {
		super();
		this.customer = customer;
		AccNo = accNo;
		Date = date;
		this.amount = amount;
		this.remBalance = remBalance;
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
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRemBalance() {
		return remBalance;
	}
	public void setRemBalance(double remBalance) {
		this.remBalance = remBalance;
	}
	
}
