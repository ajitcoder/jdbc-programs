package com.bankking_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bankking_system.ConnectionProvider;

public class AccountOperation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Connection con = ConnectionProvider.getConnection();
			System.out.println("\u001B[31m"+"Press 1: for deposit and withdraw the money");
			System.out.println("\u001B[32m"+"Press 2: for insert the detail");
			System.out.println("\u001B[33m"+"Press 3: for view the account info");
			System.out.println("\u001B[34m"+"Press 4: for exit");
			
			System.out.print("\u001B[35m"+"Enter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			
			AccountOperations accOprations = new AccountOperations();
			switch(choice) {
			
			case 1:
			    System.out.print("Enter Your Account number: ");
			    long accNum = Long.parseLong(sc.nextLine());
				try {
					ResultSet rs = con.createStatement().executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_NO="+accNum+"");
					Account acc1 = null;
					while(rs.next()) {
						
						 acc1 = new Account(rs.getLong(1),rs.getString(2),rs.getDouble(3));
					}
					
					accOprations.transactionOperation(acc1);
					
					break;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			case 2:
				
				System.out.print("Enter Account number: ");
				long accNumber = Long.parseLong(sc.nextLine());
				
				System.out.print("Enter Account Holder Name: ");
				String accHName = sc.nextLine();
				
				System.out.print("Enter Balance: ");
				double bal = Double.parseDouble(sc.nextLine());
				
				Account account = new Account(accNumber,accHName,bal);
				accOprations.addAccountDetails(account);
								
				break;
				
			case 3:
				accOprations.viewAccountDetails();
				break;
			
			case 4:
				System.exit(0);
			}
			
			System.out.println("\n");
		}
	}
}