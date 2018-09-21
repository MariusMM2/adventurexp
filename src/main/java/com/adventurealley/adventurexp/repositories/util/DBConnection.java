package com.adventurealley.adventurexp.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//#Razvan
public class DBConnection {

	//Credentials and strings
	private static final String USERNAME = "[REDACTED]";
	private static final String PASSWORD = "[REDACTED]";
	private static final String CONNSTRING = "[REDACTED]";

	//Creates a connection and returns it
	public static Connection getConnection() {
		try{
	         return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
		}
	         catch (SQLException e){
	         e.printStackTrace();
	         return null;
	 	}
	}

}