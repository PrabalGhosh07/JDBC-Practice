package Day12;

//We need to import the package
//Load and Register the driver
//Establish the connection
//Create the Statements 
//Execute the Query
//process the Results
//Close the connections

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_demo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password="Prabal@07";
		String query = "select * from sample";
		Connection con = DriverManager.getConnection(url,username,password);
		/*The DriverManager class in JDBC (Java Database Connectivity)--> serves as a central 
		 component for managing and interacting with JDBC drivers to establish connections 
		 to databases. It acts as a factory for Connection objects and handles the process of 
		 finding and loading the appropriate JDBC driver for a given database URL.
		 
		
		getConnection(), which attempts 
		to establish a connection to a specified database URL
		
		Connection -> Establishing a connection in Java JDBC involves a series of steps to enable communication
		between a Java application and a database. The Connection object represents an active session 
		with the database.*/
		Statement st=con.createStatement();
		/*a Statement object is a fundamental interface used to execute SQL statements against a relational
		 *  database. It serves as a channel between your Java application and the database, allowing you to
		 *   send SQL commands and receive results
		 */
		ResultSet rs=st.executeQuery(query);
		/*ResultSet is an object that encapsulates the results of a database query,
		 *  typically a SELECT statement. It provides a structured way to access and
		 *   manipulate the data returned from the database. 
		 */
		while (rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			System.out.println("ID is : "+id+"\nName : "+name+"\nEmail : "+email);
		}
		st.close();
		con.close();


	}

}
