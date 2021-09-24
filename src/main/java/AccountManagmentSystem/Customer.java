package AccountManagmentSystem;

public class Customer {
	private String name,address;
	private int PhNo;
	
	public Customer()
	{
		name="";
		address="";
		PhNo=0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhNo() {
		return PhNo;
	}
	public void setPhNo(int phNo) {
		PhNo = phNo;
	}
	
}
