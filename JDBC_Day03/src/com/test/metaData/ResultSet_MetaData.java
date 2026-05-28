package com.test.metaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSet_MetaData {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","Ajit");
			
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp");
			ResultSetMetaData rsdata =rs.getMetaData();
			
		
			System.out.println(rsdata.getColumnCount());
			System.out.println(rsdata.getColumnName(1));
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
