package com.jdbc_program2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RetrieveData {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","batch46","root");
			CallableStatement cs = con.prepareCall("{call retrieveStuDetails(?,?,?,?,?,?,?,?,?)}");
		    Scanner sc=new Scanner(System.in);
		    System.out.println("Enter StuId");
		    int sId=Integer.parseInt(sc.nextLine());
		    cs.setInt(1, sId);
		    cs.registerOutParameter(2, Types.NUMERIC);
		    cs.registerOutParameter(3, Types.VARCHAR);
		    cs.registerOutParameter(4, Types.VARCHAR);
		    cs.registerOutParameter(5, Types.NUMERIC);
		    cs.registerOutParameter(6, Types.VARCHAR);
		    cs.registerOutParameter(7, Types.NUMERIC);
		    cs.registerOutParameter(8, Types.VARCHAR);
		    cs.registerOutParameter(9, Types.NUMERIC);
		    cs.execute();
		    System.out.println("SId:"+sId);
		    System.out.println("RollNo:"+cs.getInt(2));
		    System.out.println("Name:"+cs.getString(3));
		    System.out.println("Branch:"+cs.getString(4));
		    //System.out.println("Success");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
