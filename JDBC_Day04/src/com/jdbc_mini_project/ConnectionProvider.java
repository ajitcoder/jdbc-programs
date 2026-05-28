package com.jdbc_mini_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	public static Connection con;
	
	private ConnectionProvider() {
		
	}
	public static Connection getConnection() {
		
		if(con==null) {
			
			final String driver="oracle.jdbc.driver.OracleDriver";
			final String url  ="jdbc:oracle:thin:@localhost:1521/orcl";
			final String uname="batch46";
			final String pword="root";
			
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,uname,pword);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return con;
	}

}
