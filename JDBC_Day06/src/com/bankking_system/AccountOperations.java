package com.bankking_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountOperations {

	public boolean addAccountDetails(Account account) {
		
		long accNumber = account.getAccountNumber();
		String accHolderName = account.getAccountHolderName();
		double accBalance = account.getAccountBalance();
		
		Connection con = ConnectionProvider.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO ACCOUNTS (ACC_NO,ACC_HOLDER,BALANCE) VALUES (?,?,?)");
			PreparedStatement p=con.prepareStatement("commit");
			pstmt.setLong(1, accNumber);
			pstmt.setString(2, accHolderName);
			pstmt.setDouble(3, accBalance);
			
			pstmt.addBatch();
			
			int[] executeBatch = pstmt.executeBatch();
			p.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public void viewAccountDetails() {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			
			Connection con = ConnectionProvider.getConnection();
		    stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM ACCOUNTS");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			if(rs.next()) {
				
				for(int i=1; i<=rsmd.getColumnCount(); i++) {
					
					System.err.print(rsmd.getColumnName(i)+"\t");
				}
				
				System.out.println("\n---------------------------------");
				
				do {
					
					for(int i=1; i<=rsmd.getColumnCount(); i++) {
						
						System.out.print("\u001B[38m\t"+rs.getString(i)+"\t");
					}
					System.out.println();
					
				}while(rs.next());
			}else {
				System.err.println("no rows selected.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void transactionOperation(Account account) {
		
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			
			Connection con = ConnectionProvider.getConnection();
		    stmt = con.createStatement();
		    
		    con.setAutoCommit(false);
		   		    
		    long accNum = account.getAccountNumber();
		    System.out.print("Enter deposite amount: ");
		    double depositeAmt = Double.parseDouble(sc.nextLine());
		    
		    int deposite = stmt.executeUpdate("UPDATE ACCOUNTS SET BALANCE="+(account.getAccountBalance()+depositeAmt)+" WHERE ACC_NO = "+accNum+" ");
		    
		    System.out.print("Enter withdraw amount: ");
		    double withdrawAmt = Double.parseDouble(sc.nextLine());
		    
		    int withdraw = 0;
		    if(withdrawAmt<=account.getAccountBalance()+depositeAmt) {
		    	
		    	withdraw = stmt.executeUpdate("UPDATE ACCOUNTS SET BALANCE="+(account.getAccountBalance()+depositeAmt-withdrawAmt)+" WHERE ACC_NO = "+accNum+" ");
		    	
		    	if(deposite == 1 && withdraw == 1) {
			    	con.setAutoCommit(true);
			    	System.out.println("Transaction is successfull.");
			    }else {
			    	con.rollback();
			    	System.err.println("Transaction is not successfull.");
			    }
		    	
		    }else {
		    	System.err.println("invalid account / insufficient balance");
		    }
		    
		}catch(SQLException e) {
			
		}
	}
	
	
}
