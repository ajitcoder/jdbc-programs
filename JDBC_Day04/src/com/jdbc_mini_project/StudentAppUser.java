package com.jdbc_mini_project;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class StudentAppUser {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			Connection con = ConnectionProvider.getConnection();
			System.out.println("\u001B[31m"+"Press 1: Add Student");
			System.out.println("\u001B[32m"+"Press 2: Delete Student");
			System.out.println("\u001B[33m"+"Press 3: Update Student by Name");
			System.out.println("\u001B[34m"+"Press 4: Display All Students");
			System.out.println("\u001B[35m"+"Press 5: Exit");
			
			System.out.print("Enter your choice: ");
			int choice= Integer.parseInt(scn.next());
			
			switch(choice) {
			
			   case 1:				   
				    System.out.print("Enter the Student id: ");
				    int id = Integer.parseInt(scn.next());//
				    scn.nextLine();
				    System.out.print("Enter the Student Name: ");
				    String name = scn.nextLine(); 
				    
				    System.out.print("Enter the student address:");
				    String address = scn.nextLine();  
				    
				    System.out.print("Enter the student adharNo(xxxx-xxxx-xxxx): ");
				    String adharNo = scn.nextLine();  
				    
				    Student stu = new Student(id,name,address,adharNo);
				    
				    boolean isInsert = StudentFunctionality.addStudentToDataBase(stu);
				    
				    if(isInsert) {
				    	System.out.println("Student data is inserted successfully.");
				    }else {
				    	System.out.println("Student data is not successfully.");
				    }
     			    break;
			   
			   case 2:
				   System.out.print("Enter the Student id: ");
				    id = Integer.parseInt(scn.next());
				    
				    int deleteStudentData = StudentFunctionality.deleteStudentData(id);
				    if(deleteStudentData==1) {
				    	System.out.println(id + " Student data deleted.");
				    }else {
				    	System.out.println(id+ " Student data not deleted.");
				    }
					break;
			   case 3:
				    System.out.print("Enter the Student Name: ");
				    name = scn.next(); 
				    
				    int updateStudentData = StudentFunctionality.updateStudentData(name);
				    if(updateStudentData==1) {
				    	System.out.println("Student data is Updated.");
				    }else {
				    	System.out.println("Student data is not Updated.");
				    }
					break; 	    
			   case 4:
				    List<Student> displayStudentData = StudentFunctionality.displayStudentData();
				    displayStudentData.forEach(y -> System.out.println(y));
				    
				    break;
			   case 5:
					System.exit(0);
			}
		}
	}
}
