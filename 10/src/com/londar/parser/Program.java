package com.londar.parser;

import com.londar.database.Database;

import java.sql.SQLException;

import com.londar.database.DBUser;

public class Program {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Database d = new Database();
		
		DBUser user = (DBUser) DBUser.getFromDatabaseWithId(d, 4);
		user.deleteInDatabase(d);
		System.out.println(user.first_name);
	}

}
