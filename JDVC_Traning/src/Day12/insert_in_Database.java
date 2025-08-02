package Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert_in_Database {

	public static void main(String[] args) throws SQLException {
		String insert="insert into jdbc.practice"
				+"(name,number,speed)"+"values('Prabal',9912345678,25);";
		String insert1="insert into jdbc.practice"
				+"(name,number,speed)"+"values('Harry',9812345678,30);";
		String insert2="insert into jdbc.practice"
				+"(name,number,speed)"+"values('Potter',9712345678,35);";
		String insert3="insert into jdbc.practice"
				+"(name,number,speed)"+"values('Dobby',9612345678,40);";
		String insert4="insert into jdbc.practice"
				+"(name,number,speed)"+"values('Ram',9512345678,45);";
		try {
			Connection connection=
					DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Prabal@07");
			System.out.println("connection established");
			Statement statement=connection.createStatement();
			int result=statement.executeUpdate(insert);
			int result1=statement.executeUpdate(insert1);
			int result2=statement.executeUpdate(insert2);
			int result3=statement.executeUpdate(insert3);
			int result4=statement.executeUpdate(insert4);
			System.out.println(result);
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
