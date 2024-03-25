package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DbConnection;
import jdbc.Employee;

public class ProductDao
{
	public int createProductTable()
	{
		int count1=0;
		try(Connection c=DbConnection.createConnection();
				Statement s=c.createStatement())
		
		{
			count1=s.executeUpdate("create table product (proId number,proName varchar2(20),proPrice number)");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count1;
	}
	public int saveProduct(Product product)
	{
		int count2=0;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps=c.prepareStatement("insert into product values(?,?,?)"))
		{
			ps.setInt(1, product.getProId());
			ps.setString(2, product.getProName());
			ps.setDouble(3, product.getProPrice());
			count2=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count2;
	}
	public Product getProductById(int id)
	{
		Product pro=null;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps=c.prepareStatement("select * from product where proId=?"))
		{
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pro=new Product();
				pro.setProId(rs.getInt(1));
				pro.setProName(rs.getString(2));
				pro.setProPrice(rs.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pro;
	}
	public List<Product> getAllProducts()
	{
		List<Product> pro=new ArrayList<Product>();
		try(Connection c=DbConnection.createConnection();
				Statement s=c.createStatement())
		{
			ResultSet rs=s.executeQuery("select * from product");
			while(rs.next())
			{
				Product p=new Product();
				p.setProId(rs.getInt(1));
				p.setProName(rs.getString(2));
				p.setProPrice(rs.getDouble(3));
				pro.add(p);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pro;
	}
	
	public int updateByPrice(double priceRange,double IncrementValue)
	{
		//update the price increment by Rs.50 where price>400
		int count3=0;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps=c.prepareStatement("update product set proPrice=proPrice+? where proPrice>?"))
		{
			ps.setDouble(1, IncrementValue);
			ps.setDouble(2, priceRange);
			count3=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count3;
	}
	
	
	
	public int deleteById(int id)
	{
		//delete the record based on id
		int count4=0;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps=c.prepareStatement("delete from product where proId=?"))
		{
			ps.setInt(1, id);
			count4=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count4;
	}
	
	
	public int deleteByPrice(double price)
	{
		//delete the record based on price of product
		int count5=0;
		try(Connection c=DbConnection.createConnection();
				PreparedStatement ps=c.prepareStatement("delete from product where proPrice>?"))
		{
			ps.setDouble(1, price);
			count5=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count5;
	}
	
	
	public int dropTable()
	{
		//delete the table created
		int count6=0;
		try(Connection c=DbConnection.createConnection();
				Statement s=c.createStatement())
		
		{
			count6=s.executeUpdate("drop table product");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count6;
	}
}
