package com.jdbc_mini_project;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFunctionality {

	public static boolean addStudentToDataBase(Student s) {
		
		int id = s.getId();
		String name = s.getName();
		String address = s.getAddress();
		String adharNo = s.getAdharNo();
		
		Statement stmt = null;
		String insertQuery = "INSERT INTO STUDENT101(ID,NAME,ADDRESS,ADHARNO)\n"+
				"VALUES ("+id+",'"+name+"','"+address+"','"+adharNo+"')";
		boolean isInsert = false;
		try {
			 stmt = ConnectionProvider.getConnection().createStatement();
			 int executeUpdate = stmt.executeUpdate(insertQuery);
			 
			 if(executeUpdate==1)
				 isInsert = true;
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return isInsert;
	}
	
	public static List<Student> displayStudentData(){
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			 stmt = ConnectionProvider.getConnection().createStatement();
			 rs = stmt.executeQuery("SELECT * FROM STUDENT101");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		List<Student> students = new ArrayList<>();
		
		try {
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String adharNo = rs.getString(4);
				
				Student s = new Student(id,name,address,adharNo);
				students.add(s);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return students;
	}
	
	public static int updateStudentData(String name) {
		Scanner sc = new Scanner(System.in);
		Statement stmt = null;
		int update = 0;
		try {
			 Connection con = ConnectionProvider.getConnection();
			 stmt = con.createStatement();
			 System.out.print("Enter new Address: ");
			 String newAdd = sc.nextLine();
			 
			 String updateQuery = "UPDATE STUDENT101 SET ADDRESS='"+newAdd+"' WHERE NAME = '"+name+"'";
			 update = stmt.executeUpdate(updateQuery);
			 
			 System.out.println(update);
			 	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return update;
	}
	
	public static int deleteStudentData(int id) {
		
		Statement stmt = null;
		try {
			 stmt = ConnectionProvider.getConnection().createStatement();
			 String deleteQuery = "DELETE FROM STUDENT101 WHERE ID="+id+"";
			 int delete = stmt.executeUpdate(deleteQuery);
			 
			 System.out.println(delete);
			 	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}
}
