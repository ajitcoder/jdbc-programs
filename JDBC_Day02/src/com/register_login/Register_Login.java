package com.register_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Register_Login
{
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Ajit");
			Statement stmt = con.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Create Table\n2.Insert Record\n3.Login");
			System.out.println("Select Your Option:");
			int option=Integer.parseInt(sc.nextLine());
			switch(option)
			{
			case 1:System.out.println("You are Going 2 create table");
			stmt.executeUpdate
			("create table UserDetails(uName varchar2(20),pWord varchar2(10),fName varchar2(10),lName varchar2(10),mid varchar2(20),phno number(10))");
			System.out.println("Table Created Successfully.....");
			break;
			case 2:System.out.println("We are going 2 insert record");
			System.out.println("Enter userName");
			String uName=sc.nextLine();
			System.out.println("Enter Password");
			String pWord=sc.nextLine();
			System.out.println("Enter First Name");
			String fName=sc.nextLine();
			System.out.println("Enter lName");
			String lName=sc.nextLine();
			System.out.println("Enter MailId");
			String mId=sc.nextLine();
			System.out.println("Enter Phno");
			long phno=sc.nextLong();
			int k = stmt.executeUpdate
			("insert into userdetails values"
		+ "('"+uName+"','"+pWord+"','"+fName+"','"+lName+"','"+mId+"',"+phno+")");
			if(k>0)
				System.out.println("Data Inserted SuccessFully.....");
			break;
			case 3:System.out.println("We are going for Login");
			System.out.println("Enter userName");
			String userName=sc.nextLine();
			System.out.println("Enter Password");
			String passWord=sc.nextLine();
			ResultSet rs = stmt.executeQuery
			("select * from userdetails where uname='"+userName+"' and pword='"+passWord+"'");
			if(rs.next())
			{
			System.out.println("login Successfull\nWelcome user:"+rs.getString("uName"));	
			}
			else {
				System.out.println("Login Failed.....");
			}
			}
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
