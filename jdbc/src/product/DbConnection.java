package product;

import java.sql.*;

public class DbConnection 
{
	//this method will create the connection object and return connection 
	public static Connection createConnection()
	{
		Connection c=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@loaclhost:1521:xe", "system", "manager");
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return c;
	}
}









