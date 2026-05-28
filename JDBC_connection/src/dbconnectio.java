
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class dbconnectio {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Ajit");
	         Statement stmt=con.createStatement();
	         String query=" insert into jdbc values(102)";
	         PreparedStatement p1=con.prepareStatement(query);
	        
	         p1.execute();
	         System.out.println("table values inserted  successfully................");
	         
	         	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
