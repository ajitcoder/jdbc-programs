package com.online_shopping_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OnlineShoppingSystem {
	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","Ajit");
			Statement st = con.createStatement();
			
//			st.execute("create table Products (product_id number(5) primary key,product_name varchar2(20),price number(8,2),stock number(5))");
//			st.execute("create table Customers (customer_id number(5) primary key,name varchar2(20),email varchar2(30),phone number(10))");
//			st.execute("create table Orders(order_id number(5) primary key,customer_id number(5),order_date date,total_amount number(10,2))");
//			
//			st.execute("create sequence product_seq "
//					+ "start with 1"
//					+ "increment by 1");
//			st.execute("create sequence customer_seq "
//					+ "start with 1"
//					+ "increment by 1");
//			st.execute("create sequence order_seq "
//					+ "start with 1"
//					+ "increment by 1");
//			System.out.println("Table and sequence created successfully");
			st.execute("insert into products values(product_seq.nextval,'laptop',30000,'10')");
			st.execute("insert into customers values(customer_seq.nextval,'Ajit','ajitkr80923097@gamil.com','8210633309')");
			st.execute("insert into orders values(order_seq.nextval,'1',sysdate,'1000')");
			System.out.println("Data Inserted...");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
