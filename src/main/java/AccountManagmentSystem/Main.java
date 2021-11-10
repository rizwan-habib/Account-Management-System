package AccountManagmentSystem;

import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;  // Import the Scanner class




public class Main {
	public static void Display(int j ,ArrayList<Account> accounts) {
		System.out.println("Account No: "+accounts.get(j).getAccNo());
		System.out.println("Name: "+accounts.get(j).getCustomer().getName());
		System.out.println("Address: "+accounts.get(j).getCustomer().getAddress());
		System.out.println("Phone No: "+accounts.get(j).getCustomer().getPhNo());
		System.out.println("Balance: "+accounts.get(j).getBalance());
		System.out.println("Bank: "+accounts.get(j).getBank());
		System.out.println("Date Created: "+accounts.get(j).getDateCreated());
		if(accounts.get(j).getType()=='C') {
			System.out.println("Account Type: Checking");
		}
		else {
			System.out.println("Account Type: Saving");
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		PersistenceHandler dbHandler = null;
		int db=0;
		do {
	    	System.out.println("1. Oracle DataBase\n");
	    	System.out.println("2. MySQL DataBase\n");
	    	System.out.println("3. File System\n");
	    	System.out.println("0. Exit\n");
	    	db = input.nextInt();
	    	input.nextLine();
//	    	System.out.println(inp);
		} while (db<0||db>3);
		if (db==1) {
			dbHandler = new oracleDBHandler();
		}
		else if (db==2) {
			dbHandler = new MySQLDBHandler();
		}
		else if (db==3) {
			dbHandler = new FileSystemHandler();
		}
		else if (db==0) {
			return;
		}
		
		
		int num=0;
		float interest=10;
		ArrayList<Account> accounts = new ArrayList<Account>();
		System.out.println("Welcome to Java Account Management System\n");
		// Create an ArrayList object
		while(true) {
			int inp=0;
			do {
		    	System.out.println("1. Login to existing Account\n");
		    	System.out.println("2. Create a new Account\n");
		    	System.out.println("3. Specify the interest rate\n");
		    	System.out.println("4. Display all account details\n");
		    	System.out.println("5. Display all accounts deductions\n");
		    	System.out.println("6. Delete an Account\n");
		    	
		    	System.out.println("0. Exit\n");
		    	inp = input.nextInt();
		    	System.out.println(inp);
			} while (inp<0||inp>6);
			int user1=0;
			if (inp==0) {
				return;
			}
			else if(inp==1) {
		    	System.out.println("Enter Account No\n");
		    	int acc = input.nextInt();
		    	input.nextLine();
		    	boolean flag=true;
		    	
				for(int i=0;i<accounts.size();i++) {
					if(acc==accounts.get(i).getAccNo()) {
						flag=false;
						user1=i;
					}
				}
				if(flag==false) {
					System.out.println("1. Make deposit\n");
			    	System.out.println("2. Make Withdrawl\n");
			    	System.out.println("3. Check Balance\n");
			    	System.out.println("4. print statement\n");
			    	System.out.println("5. Transfer Amount\n");
			    	System.out.println("6. Calculate Zakat\n");
			    	System.out.println("7. Display Deductions\n");
			    	System.out.println("0. Exit\n");
			    	int check=input.nextInt();
			    	input.nextLine();
			    	
			    	if(check==1) {
			    		System.out.println("Enter Amount to deposit\n");
				    	double amount=input.nextDouble();
				    	input.nextLine();
				    	boolean flag1=false;
			    		accounts.get(user1).makeDeposit(amount);
			    		flag1=accounts.get(user1).deduction();
			    		Statement s1=new Statement();
			    		s1.setAccNo(accounts.get(user1).getAccNo());
			    		s1.setAmount(amount);
			    		Customer c=new Customer();
			    		c.setAddress(accounts.get(user1).customer.getAddress());
			    		c.setName(accounts.get(user1).customer.getName());
			    		c.setPhNo(accounts.get(user1).customer.getPhNo());
			    		s1.setCustomer(c);
			    		s1.setRemBalance(accounts.get(user1).balance);
			    		s1.setDate(java.time.LocalDate.now().toString());
			    		accounts.get(user1).statements.add(s1);
			    		if(flag1) {
			    			accounts.get(user1).deductions.add("Account No: "+String.valueOf(accounts.get(user1).getAccNo())+"  Type: Deposit");
			    		}			    	
			    	}
			    	else if(check==2) {
			    		System.out.println("Enter Amount to withdrawl\n");
				    	double amount=input.nextDouble();
				    	input.nextLine();
				    	boolean flag1=false;
			    		accounts.get(user1).withdrawl(amount);
//			    		accounts.get(user1).deduction();
//			    		accounts.get(user1).makeDeposit(amount);
			    		flag1=accounts.get(user1).deduction();
			    		Statement s1=new Statement();
			    		s1.setAccNo(accounts.get(user1).getAccNo());
			    		s1.setAmount(amount);
			    		Customer c=new Customer();
			    		c.setAddress(accounts.get(user1).customer.getAddress());
			    		c.setName(accounts.get(user1).customer.getName());
			    		c.setPhNo(accounts.get(user1).customer.getPhNo());
			    		s1.setCustomer(c);
			    		s1.setRemBalance(accounts.get(user1).balance); 
			    		s1.setDate(java.time.LocalDate.now().toString());
			    		accounts.get(user1).statements.add(s1);
			    		if(flag1) {
			    			accounts.get(user1).deductions.add("Account No: "+String.valueOf(accounts.get(user1).getAccNo())+"  Type: Withdrawl");
			    		}
			    	}
			    	else if(check==3) {
			    		accounts.get(user1).checkBalance();
			    	}

			    	else if(check==4) {
			    		
			    		//print statement
			    		accounts.get(user1).printStatement();
			    	}

			    	else if(check==5) {
			    		System.out.println("Enter Amount to transfer\n");
				    	double amount=input.nextDouble();
				    	input.nextLine();
				    	System.out.println("Enter Amount to transfer\n");
				    	int ac=input.nextInt();
				    	input.nextLine();
				    	flag=false;
				    	int index=0;
				    	for (int i = 0; i < accounts.size(); i++) {
							if(ac==accounts.get(i).getAccNo()) {
								flag=true;
								index=i;
							}
						}
				    	if(flag) {
				    		accounts.get(index).makeDeposit(amount);
				    		//deduction
				    	}
				    	else {
				    		System.out.println("Invalid Account Number");
				    	}
				    	boolean flag1=false;
				    	accounts.get(user1).deduction();
				    	accounts.get(user1).makeDeposit(amount);
			    		flag1=accounts.get(user1).deduction();
			    		Statement s1=new Statement();
			    		s1.setAccNo(accounts.get(user1).getAccNo());
			    		s1.setAmount(amount);
			    		Customer c=new Customer();
			    		c.setAddress(accounts.get(user1).customer.getAddress());
			    		c.setName(accounts.get(user1).customer.getName());
			    		c.setPhNo(accounts.get(user1).customer.getPhNo());
			    		s1.setCustomer(c);
			    		s1.setRemBalance(accounts.get(user1).balance);
			    		s1.setDate(java.time.LocalDate.now().toString());
			    		accounts.get(user1).statements.add(s1);
			    		if(flag1) {
			    			accounts.get(user1).deductions.add("Account No: "+String.valueOf(accounts.get(user1).getAccNo())+"  Type: Transfer Amount");
			    		}
			    	}

			    	else if(check==6) {
			    		accounts.get(user1).calculateZakat();
			    	}

			    	else if(check==7) {
			    		accounts.get(user1).displayAllDeductions();
			    	}

			    	else {
			    		return;
			    	}

			    	
				}
				else {
					System.out.print("Account didn't found\n");
				}
			}
			else if (inp==2) {
				int inp1=0;
				do {
			    	System.out.println("1. Checking Account\n");
			    	System.out.println("2. Saving Account\n");
			    	System.out.println("0. Exit\n");
			    	inp1 = input.nextInt();
			    	input.nextLine();
				} while (inp1<0||inp1>2);
				if(inp1==1) {
					System.out.print("Enter Phone Number: ");
					int ph=input.nextInt();
					input.nextLine();
					boolean flag=true;
					for(int i=0;i<accounts.size();i++) {
						if(ph==accounts.get(i).getCustomer().getPhNo()&&accounts.get(i).getType()=='S') {
							flag=false;
						}
					}
					if(flag==true) {
						Account c1=new Checking();
						Customer c=new Customer();
						
						c.setPhNo(ph);
						
						c1.setBalance(0);
						
						System.out.print("Enter Bank Name: ");
						String bank=input.nextLine();
						c1.setBank(bank);
						
						c1.setDateCreated(java.time.LocalDate.now());
						
						
						System.out.print("Enter Address: ");
						String str1=input.nextLine();
						c.setAddress(str1);
						
						System.out.print("Enter Name: ");
						String str2=input.nextLine();
						c.setName(str2);
						
						c1.setType('C');
						
						c1.setCustomer(c);
						c1.setAccNo(num);
						System.out.print("Your Checking Account No is: "+num+"\n");
						
						num++;
						dbHandler.save(c1);
						System.out.println("db done");
						accounts.add(c1);
					}
					else {
						System.out.print("saving account already exist on this phone number");
					}
				}
				else if(inp1==2) {
					System.out.print("Enter Phone Number: ");
					int ph=input.nextInt();
					input.nextLine();
					boolean flag=true;
					for(int i=0;i<accounts.size();i++) {
						if(ph==accounts.get(i).getCustomer().getPhNo()&&accounts.get(i).getType()=='C') {
							flag=false;
						}
					}
					if(flag==true) {
						Account c1=new Saving();
						Customer c=new Customer();
						
						c.setPhNo(ph);
						
						
						c1.setBalance(0);
						
						System.out.print("Enter Bank Name: ");
						String bank=input.nextLine();
						c1.setBank(bank);
						
						c1.setDateCreated(java.time.LocalDate.now());
						
						
						System.out.print("Enter Address: ");
						String str1=input.nextLine();
						c.setAddress(str1);
						
						System.out.print("Enter Name: ");
						String str2=input.nextLine();
						c.setName(str2);
						
						c1.setType('S');
						
						c1.setCustomer(c);
						c1.setAccNo(num);
						
						System.out.print("Your Saving Account No is: "+num+"\n");
						num++;
						c1.setInterest(interest);
						dbHandler.save(c1);
						accounts.add(c1);
					}
					else {
						System.out.print("checking account already exist on this phone number");
					}
				}
				else {
					return;
				}
			}
			else if(inp==3) {
				System.out.print("Enter interest Rate: ");
				double inter=input.nextDouble();
				input.nextLine();
				for (int j = 0; j < accounts.size(); j++) {
					accounts.get(j).setInterest(inter);
				}
			}
			else if(inp==4) {
				for (int j = 0; j < accounts.size(); j++) {
					Display(j,accounts);
				}
			}
			else if(inp==5) {
				
				for (int j = 0; j < accounts.size(); j++) {
					accounts.get(j).displayAllDeductions();
				}
			}
			else if(inp==6) {
				System.out.print("Enter Account No: ");
				int ac=input.nextInt();
				input.nextLine();
				boolean flag=false;
				int index=-1;
				for (int j = 0; j < accounts.size(); j++) {
					if (accounts.get(j).getAccNo()==ac) {
						flag=true;
						index=j;
					}
				}
				if(flag) {
					accounts.remove(index);
				}
			}
		}
//		System.out.print(java.time.LocalDate.now().toString());
	}

}
