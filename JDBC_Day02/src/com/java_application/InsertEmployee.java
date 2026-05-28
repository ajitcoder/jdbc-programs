package com.java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertEmployee {
	
	public static void main(String [] args)
	{
		try
		{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "Ajit");

            Statement st = con.createStatement();
            
//               String employeeTable="""
//               		CREATE TABLE EMPLOYEE(
//               		ID NUMBER(8),
//               		NAME VARCHAR2(20),
//               		AGE NUMBER(3),
//               		SALARY NUMBER(8,2)
//               		)
//               		""";
//               st.execute(employeeTable);
            
            st.executeQuery("""
            		insert into employee(id,name,age,salary) values(1,'Naresh',22,23432.6)
            		""");
            
            st.executeQuery("""
            		insert into employee(id,name,age,salary) values(2,'Suresh',23,32222.5)
            		
            		""");
            
            st.executeQuery("""
            		insert into employee(id,name,age,salary) values(3,'Jain',32,43332.6)
            		
            		""");
            
            st.executeQuery("""
            		insert into employee(id,name,age,salary) values(4,'David',27,15009.2)
            		
            		""");
            
            st.executeQuery("""
            		insert into employee(id,name,age,salary) values(5,'Anthony',34,32322.5)
            		
            		""");
            
            System.out.println("conected database successfully...");
          

            con.close();	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
}

