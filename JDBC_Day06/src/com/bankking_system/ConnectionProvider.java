package com.bankking_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection con;
	
	private ConnectionProvider(){
		
		
	}
	
    public static Connection getConnection() {
    	
    	final String DB_URL = "jdbc:oracle:thin:@localhost:1522:orcl";
   	    final String DB_USN = "batch46";
   	    final String DB_PWD = "root";
   	
		try {
			con = DriverManager.getConnection(DB_URL,DB_USN,DB_PWD);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return con;
    }
}