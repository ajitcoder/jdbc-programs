package com.java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRetrive {

	public static void main(String[] args) {
		try
		{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "Ajit");

            Statement st=con.createStatement();
            String retrive="select * from employee";
            ResultSet rs=st.executeQuery(retrive);
            //EmployeeData e=new EmployeeData();
//            e.setId(rs.getInt(1));
//            e.setName(rs.getString(2));
//            e.setAge(rs.getInt(3));
//            e.setSalary(rs.getDouble(4));
            List<EmployeeData> li=new ArrayList<EmployeeData>();
            while(rs.next()) {
            	li.add(new EmployeeData(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
      for(EmployeeData l:li) {
    	  if(l.getAge()>25) {
    		  System.out.println(l);
    	  }
      }
      
            con.close();	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}

	}

}
