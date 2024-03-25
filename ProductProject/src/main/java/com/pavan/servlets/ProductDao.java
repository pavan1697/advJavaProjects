package com.pavan.servlets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao
{
		public int save(Product product) {
			//Declare the resources
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				int savecount=0;
				try {
					//Get the connection
					connection=Dbconnection.createconnection();
					//create the preparedStatement object
					preparedStatement=connection.prepareStatement("insert into productdata values (?,?,?,?,?,?,?,?,?,?)");
					//read the data from employee object and set to parameters
					preparedStatement.setString(1,product.getProId());
					preparedStatement.setString(2, product.getProName());
					preparedStatement.setDouble(3, product.getProPrice());
					preparedStatement.setString(4, product.getProBrand());
					preparedStatement.setString(5, product.getProMadeIn());
					preparedStatement.setDate(6, product.getProMnfgDate());
					preparedStatement.setDate(7, product.getProExpDate());
					preparedStatement.setBytes(8, product.getProImage());
					preparedStatement.setBytes(9, product.getProAudio());
					preparedStatement.setBytes(10, product.getProVideo());
					savecount=preparedStatement.executeUpdate();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					//Before release the connection check the connection is present or not
					try {
						if(connection!=null)
							connection.close();
						if(preparedStatement!=null)
							preparedStatement.close();
					}
					catch ( SQLException e ) {
						e.printStackTrace();
					}
				}
				return savecount;
			}
		
		public static List<Product> findAll() throws ClassNotFoundException 
		{
			List<Product> pro=new ArrayList<Product>();
			
			try(Connection connection=Dbconnection.createconnection();
					Statement statement= connection.createStatement();)
			{
				
				ResultSet resultSet=statement.executeQuery("select * from productdata");
				while(resultSet.next()) 
				{
					Product product=new Product();
					
					product.setProId(resultSet.getString(1));
					product.setProName(resultSet.getString(2));
					product.setProPrice(resultSet.getDouble(3));
					product.setProBrand(resultSet.getString(4));
					product.setProMadeIn(resultSet.getString(5));
					product.setProMnfgDate(resultSet.getDate(6));
					product.setProExpDate(resultSet.getDate(7));
					product.setProImage(resultSet.getBytes(8));
					product.setProAudio(resultSet.getBytes(9));
					product.setProVideo(resultSet.getBytes(10));
					
					pro.add(product);
				}			
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
			return pro;	
		}
		
		public int deleteById(String proId)
		{
			//delete the record based on id
			int delcount=0;
			try(Connection c=Dbconnection.createconnection();
					PreparedStatement ps=c.prepareStatement("delete from productdata where proId=?"))
			{
				ps.setString(1, proId);
				delcount=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return delcount;
		}
		
		public Product findById(String id)
		{
			Product product=new Product();
			try(Connection c=Dbconnection.createconnection();
					PreparedStatement ps=c.prepareStatement("select * from productdata where proId=?"))
			{
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					
					product.setProId(rs.getString(1));
					product.setProName(rs.getString(2));
					product.setProPrice(rs.getDouble(3));
					product.setProBrand(rs.getString(4));
					product.setProMadeIn(rs.getString(5));
					product.setProMnfgDate(rs.getDate(6));
					product.setProExpDate(rs.getDate(7));
					product.setProImage(rs.getBytes(8));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return product;
		}
		
		public int updateById(Product product)
		{
			String sql="update productdata set proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMnfgDate=?,proExpDate=?,proImage=? where proId=?";
			int updateresult=0;
			try(Connection c=Dbconnection.createconnection();
					PreparedStatement ps=c.prepareStatement(sql))
			{
				
				ps.setString(1, product.getProName());
				ps.setDouble(2, product.getProPrice());
				ps.setString(3, product.getProBrand());
				ps.setString(4, product.getProMadeIn());
				ps.setDate(5, product.getProMnfgDate());
				ps.setDate(6, product.getProExpDate());
				ps.setBytes(7, product.getProImage());
				ps.setString(8, product.getProId());
				updateresult=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return updateresult;
		}
}
