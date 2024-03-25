package jdbc;

import java.sql.*;
import java.util.*;

public class EmployeeDao 
{
		//declare the resources
		public int save(Employee emp) {
			
			
			Connection connection = null;
			
			PreparedStatement ps = null;
			
			int count=0;
			
			try {
			
				connection = DbConnection.createConnection();
			
			ps = connection.prepareStatement("insert into emp values( ? , ? , ? )");
			
			
			ps.setInt(1 , emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setDouble(3, emp.getSalary());
			
			
			count =  ps.executeUpdate();
			System.out.println("rowCount "+count);
			
			
			}catch(SQLException s) {
				
				s.printStackTrace();
				
			}finally {
				
				try {
				if(connection!=null && ps!=null) {
					connection.close();
					ps.close();
					}
				}catch(SQLException s) {
					s.printStackTrace();
				}
				}
			return count;
			}
		
		public Employee findById(int empId) {
			
			Employee emp = null;
			
			//get the connection.
			try(Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empid=?")){
				
				preparedStatement.setInt(1, empId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
					
				 emp =  new Employee();
				
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setSalary(resultSet.getDouble(3));
				}
				
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
			return emp;
		}
		
		public int deleteById(int empid) {
			
			int count=0;
			
			//get the connection.
			try(Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empid=?")){
				
				preparedStatement.setInt(1,empid);
				
				count = preparedStatement.executeUpdate();
				
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
			return count;
		}
		
	public int deleteBySalary(int empsalary) {
			
			int count=0;
			
			//get the connection.
			try(Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empSalary<?")){
				
				preparedStatement.setInt(1,empsalary);
				
				count = preparedStatement.executeUpdate();
				
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
			return count;
		}
	public List<Employee> findAll()
	{
		List<Employee> emps=new ArrayList<Employee>();
		try(Connection c=DbConnection.createConnection();
				Statement s=c.createStatement())
		{
			ResultSet rs=s.executeQuery("select * from emp");
		while(rs.next())
		{
			Employee emp=new Employee();
			emp.setEmpId(rs.getInt(1));
			emp.setEmpName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emps.add(emp);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emps;
	}
	public int updateSalary(double currentSal,double incSal)
	{
		int count=0;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps = c.prepareStatement("update emp set empsalary=empSalary+? where empsalary>?"))
		{
			ps.setDouble(1, incSal);
			ps.setDouble(2, currentSal);
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
}