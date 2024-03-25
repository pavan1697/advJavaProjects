package product;

import java.util.List;

public class ProductClient {

	public static void main(String[] args) 
	{
		ProductDao p=new ProductDao();
		//create table
//		int create=p.createProductTable();
//		System.out.println("table created successfully"+create);
		
		
		
		//insert data into tables
//		int insertcount1=p.saveProduct(new Product(101, "phone", 15000));
//		System.out.println("data inserted successfully"+insertcount1);
//		int insertcount2=p.saveProduct(new Product(102, "laptop", 30000));
//		System.out.println("data inserted successfully"+insertcount2);
//		int insertcount3=p.saveProduct(new Product(103, "tablet", 7000));
//		System.out.println("data inserted successfully"+insertcount3);
//		int insertcount4=p.saveProduct(new Product(104, "ipad", 90000));
//		System.out.println("data inserted successfully"+insertcount4);
		
		
//		//retrieve data from data base for specific product by id
//		Product pro=p.getProductById(101);
//		System.out.println(pro);
//		
//		
//		//get all products data from database 
//		List<Product>l=p.getAllProducts();
//		for(Product x:l)
//			System.out.println(x);
//		
//		
//		
//		//update product price by product value
//		int updatecount=p.updateByPrice(4000, 500);
//		System.out.println("product price is updated successfully"+updatecount);
//		
//		
//		//delete product by id
//		int deleteproductcount=p.deleteById(103);
//		System.out.println("product deleted successfully"+deleteproductcount);
//		
//		
//		//delete product by price range
//		int deleteproductcount2=p.deleteByPrice(75000);
//		System.out.println("product deleted successfully"+deleteproductcount2);
//		
//		
//		//drop table
		int droptablecount=p.dropTable();
		System.out.println("table dropped successfully"+droptablecount);
	}

}
