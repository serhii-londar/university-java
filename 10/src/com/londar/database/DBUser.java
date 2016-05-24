package com.londar.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUser extends DBModel {
	public String first_name;
	public String last_name;
	public int age;
	public int id;

	DBUser() {
		properties = new ArrayList<String>();
		properties.add("first_name");
		properties.add("last_name");
		properties.add("age");
		properties.add("id");
	}

	public static DBModel createInDatabase(Database database) throws SQLException {
		PreparedStatement statement = database.connection.prepareStatement(
				"INSERT INTO `4`.`Users` (`first_name`, `last_name`, `age`) VALUES ('\"\"', '\"\"', '0')",
				Statement.RETURN_GENERATED_KEYS);

		statement.executeUpdate();

		DBUser user = new DBUser();
		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			user.id = (int) generatedKeys.getLong(1);
		} else {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		return user;
	}

	public static DBModel getFromDatabaseWithId(Database database, int id) throws SQLException {
		Statement statement = database.connection.createStatement();
		String sql = "SELECT id, first_name, last_name, age FROM Users WHERE id = " + id;
		ResultSet rs = statement.executeQuery(sql);

		DBUser user = new DBUser();
		while (rs.next()) {
			user.id = rs.getInt("id");
			user.age = rs.getInt("age");
			user.first_name = rs.getString("first_name");
			user.last_name = rs.getString("last_name");
		}
		rs.close();
		return user;
	}

	public void updateInDatabase(Database database) throws SQLException {
		Statement stmt = database.connection.createStatement();
		String sql = "UPDATE `4`.`Users` SET `first_name`='" + first_name + "', `last_name`='" + last_name
				+ "', `age`='" + age + "' WHERE `id`='"+id+"'";
		stmt.executeUpdate(sql);
	}
	
	public void deleteInDatabase(Database database) throws SQLException  {
		Statement stmt = database.connection.createStatement();
		String sql = "DELETE FROM Users WHERE id = "+ id;

		stmt.executeUpdate(sql);
	}
}
