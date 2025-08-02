package Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

public class JDBC_Demo2 {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password="Prabal@07";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*jvm is trying to load the jdbc class during the run time
			if jar file is not found it will be getting error*/

		} catch (ClassNotFoundException e) {
			System.out.println("Class is not found ....");
			e.printStackTrace();
		}
		try(Connection con= DriverManager.getConnection(url,username,password);
				Statement st = con.createStatement();
			){
			//For Creating table in database ----->
			String user ="CREATE TABLE IF NOT EXISTS sample2(id int Auto_increment primary key,name varchar(100),number int)";
			st.executeUpdate(user);
			System.out.println("The new table sample2 is created....");
			
			//For Enter the elements in the table --->
			String value= "insert into sample2(name,number)values(?,?)";//for adding multiple elements
			try(PreparedStatement ps=con.prepareStatement(value)){
				//prepared statement is a inbuilt statement in a interface class
				ps.setString(1, "Sam");
				ps.setInt(2, 100);
				ps.addBatch();//Adds a set of parameters to this PreparedStatementobject's batch of commands.
				
				int arr[]=ps.executeBatch();
				//All the rows inserted into the database at a single batch
				
				System.out.printf("inserted rows %d",
						(int)IntStream.of(arr).filter(c-> c>0).count());
			}
			
			String query="Select * from sample2";
			try(ResultSet rs=st.executeQuery(query)) {
				while (rs.next()) {
//					int id=rs.getInt(1);
					String name=rs.getString(2);
					int number=rs.getInt(3);
					System.out.println(" Name is "+name+"\nnumber is :"+number);
				}

			} catch (SQLException e) {
				System.out.println("Data operation failed");
				e.printStackTrace();
			}
			
			}
	}

}
