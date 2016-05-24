package com.londar.database;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/4";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	public Connection connection = null;
	private Statement statement = null;

	public Database() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			statement = connection.createStatement();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			
		} // end try
	}
	
	

	public void close() {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException se2) {

		} try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
