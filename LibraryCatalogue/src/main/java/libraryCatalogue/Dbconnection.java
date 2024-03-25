package libraryCatalogue;
import java.sql.*;
public class Dbconnection {
		public static Connection createconnection() 
		{
			Connection connection=null;
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				System.out.println("connection created successfully");
				
			}
			catch(ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return connection;
		}

}
