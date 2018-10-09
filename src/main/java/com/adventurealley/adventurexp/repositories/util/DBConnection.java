package com.adventurealley.adventurexp.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	//Credentials and strings
	private static final String USERNAME = "adventurexpdb";
	private static final String PASSWORD = "Cr5z_vd0?WYb";
	private static final String CONNSTRING = "jdbc:mysql://den1.mysql4.gear.host/adventurexpdb?useSSL=false";

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