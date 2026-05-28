package com.test.metaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Database_metadata {
public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","Ajit");
		DatabaseMetaData dbdata = con.getMetaData();
		System.out.println(dbdata.getDatabaseProductName());
		System.out.println(dbdata.getDatabaseProductVersion());
		System.out.println(dbdata.getDriverName());
		System.out.println(dbdata.getMaxColumnsInTable());
	} catch (Exception e) {
		
	}
}
}
