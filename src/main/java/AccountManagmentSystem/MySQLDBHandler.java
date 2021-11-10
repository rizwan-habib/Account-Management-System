package AccountManagmentSystem;
import java.sql.*;
public class MySQLDBHandler extends PersistenceHandler {

	public MySQLDBHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Account acc) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			java.sql.Statement st=con.createStatement();
			st.execute("use accountManagementSystem");
			
			String sql="insert into account values (?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, acc.getAccNo());
			stmt.setInt(2, (int)acc.getBalance());
			stmt.setString(3, acc.getDateCreated().toString());
			stmt.setString(4, acc.getBank());
			stmt.setString(5, Character.toString(acc.getType()));
			int rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.print("Done");
			}
			
			sql="insert into customer values (?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, acc.getAccNo());
			stmt.setString(2, acc.getCustomer().getAddress());
			stmt.setString(3, String.valueOf(acc.getCustomer().getPhNo()));
			stmt.setString(4, acc.getCustomer().getName());
			rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.print("Done");
			}
			
			con.close();
//			Statement stmt=con.createStatement();
			
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
