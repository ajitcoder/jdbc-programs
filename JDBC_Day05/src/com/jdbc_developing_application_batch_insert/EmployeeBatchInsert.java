package com.jdbc_developing_application_batch_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBatchInsert 
{
    
	public static void main(String [] args) throws SQLException
	{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into student values(?,?)");
		pst.setInt(1, 111);
		pst.setString(2, "Raj");
		pst.addBatch();
		
		pst.setInt(1, 222);
		pst.setString(2, "Ajit");
		pst.addBatch();
		
		pst.setInt(1, 333);
		pst.setString(2, "Vivek");
		pst.addBatch();
		
	}
}
