package Workshop2Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Solution {

	private int id = 0;
	private Date created;
	private Date updated;
	private String description;
	private int excerciseId;
	private int usersId;

	public Solution(Date created, Date updated, String description, int excerciseId, int usersId) {
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excerciseId = excerciseId;
		this.usersId = usersId;
	}
	
	public void saveToDB(Connection conn) throws SQLException {
		if (this.id != 0) {
			String updateQuery = "INSERT INTO solutions(created, updated, description, excercise_id, users_id) VALUES(?,?,?,?,?);";
			String[] autogenerated = new String[] { "id" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(updateQuery, autogenerated);
			preparedStatement.setDate(1, (java.sql.Date) this.created);
			preparedStatement.setDate(2, (java.sql.Date) this.updated);
			preparedStatement.setString(3, this.description);
			preparedStatement.setInt(4, this.excerciseId);
			preparedStatement.setInt(5, this.usersId);
			preparedStatement.executeUpdate();
			ResultSet resSet = preparedStatement.getGeneratedKeys();
			while (resSet.next()) {
				this.id = resSet.getInt(1);
				System.out.println(resSet.getMetaData());
			}
		}
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExcerciseId() {
		return excerciseId;
	}

	public void setExcerciseId(int excerciseId) {
		this.excerciseId = excerciseId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getId() {
		return id;
	}

}