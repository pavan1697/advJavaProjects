package jdbc;

import java.sql.*;

public class DbConnection 
{
	//this method will create the connection object and return connection 
	public static Connection createConnection() {
		
		Connection connection = null;
		
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		connection = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe" , "system" , "manager");
		}
		catch(ClassNotFoundException | SQLException cs) {
			cs.printStackTrace();
		}
		return connection;
	}
}









