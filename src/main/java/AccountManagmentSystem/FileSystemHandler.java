package AccountManagmentSystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileSystemHandler extends PersistenceHandler {

	public FileSystemHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Account acc) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("accountsdata.csv",true);
			fw.write(acc.getAccNo()+","+acc.getBalance()+","+acc.getBank()+","+acc.getType()+","+acc.getDateCreated()+","+acc.getCustomer().getName()+","+acc.getCustomer().getAddress()+","+acc.getCustomer().getPhNo()+"\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
