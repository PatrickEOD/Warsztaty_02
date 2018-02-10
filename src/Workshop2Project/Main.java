package Workshop2Project;

import java.sql.Connection;
import java.sql.SQLException;

import Workshop2Project.DataBase.ConnectToDB;

public class Main {

	public static void main(String[] args) {

		java.util.Date actualDate = new java.util.Date();
		java.sq 	
		try (Connection conn = ConnectToDB.connectToDatabase()) {

			if (conn == null) {
				System.exit(1);
			}
			
			UserGroup group1 = new UserGroup("Work like charm guys");
			UserGroup group2 = new UserGroup("Lazy guys");
			group1.saveToDB(conn);
			group2.saveToDB(conn);

			User user1 = new User("Adam", "adam@wp", "pass1", 1);
			User user2 = new User("Kamil", "kamolo@onet", "pass2", 2);
			User user3 = new User("Dada", "dadko@magic", "YouCannotPass", 1);
			user1.saveToDB(conn);
			user2.saveToDB(conn);
			user3.saveToDB(conn);

			Excercise excer1 = new Excercise("push-up", "Chineese old excercise for muscle build used by shaolin monks");
			Excercise excer2 = new Excercise("squat", "Simple squat");
			Excercise excer3 = new Excercise("jogging", "Run with moderate speed");
			Excercise excer4 = new Excercise("swiming", "Any style but not on the back");
			excer1.saveToDB(conn);
			excer2.saveToDB(conn);
			excer3.saveToDB(conn);
			excer4.saveToDB(conn);
			
			Solution sol1 = new Solution(actualDate, null, "just do it", 1, 1);
//			Solution sol2 = new Solution(actualDate, )

		} catch (SQLException e) {
			System.out.println("Connection rejected!");
			e.printStackTrace();
		}
	}
}
