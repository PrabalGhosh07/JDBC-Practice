package Day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletion_in_Database {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password="Prabal@07";
		String delete = "delete from practice where speed=25";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = con.prepareStatement(delete);
			int rs= ps.executeUpdate();
			System.out.println(rs);
			
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
			e.printStackTrace();

		}

	}

}
