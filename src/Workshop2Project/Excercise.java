package Workshop2Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Excercise {

	private int id = 0;
	private String title;
	private String description;

	public Excercise(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public void saveToDB(Connection conn) throws SQLException {
		if (this.id != 0) {
			String updateQuery = "INSERT INTO excercises(title, description) VALUES(?,?);";
			String[] autogenerated = new String[] { "id" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(updateQuery, autogenerated);
			preparedStatement.setString(1, this.title);
			preparedStatement.setString(2, this.description);
			preparedStatement.executeUpdate();
			ResultSet resSet = preparedStatement.getGeneratedKeys();
			while (resSet.next()) {
				this.id = resSet.getInt(1);
				System.out.println(resSet.getMetaData());
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

}
