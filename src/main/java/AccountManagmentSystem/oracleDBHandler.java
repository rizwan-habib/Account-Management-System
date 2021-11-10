package AccountManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class oracleDBHandler extends PersistenceHandler {

	public oracleDBHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Account acc) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","janjua123");
			System.out.print("2\n");
//			java.sql.Statement st=con.createStatement();
//			st.executeQuery("use accountManagementSystem");
			
			String sql="insert into account values (?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, acc.getAccNo());
			stmt.setInt(2, (int)acc.getBalance());
			stmt.setString(3, acc.getDateCreated().toString());
			stmt.setString(4, acc.getBank());
			stmt.setString(5, Character.toString(acc.getType()));
			
			
			int rowsUpdated=stmt.executeUpdate();
			
			
			
			if (rowsUpdated>0) {
				System.out.print("Done1");
			}
			else {
				System.out.println("Not Done1");
			}
			sql="insert into customer values (?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, acc.getAccNo());
			stmt.setString(2, acc.getCustomer().getAddress());
			stmt.setString(3, String.valueOf(acc.getCustomer().getPhNo()));
			stmt.setString(4, acc.getCustomer().getName());
			rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.println("Done");
			}
			else {
				System.out.println("Not Done");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}

}
