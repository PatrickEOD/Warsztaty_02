package Workshop2Project.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

	public static Connection connectToDatabase() {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/programmingSchool?" + "useSSL=false", "root", "coderslab");
			return conn;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
