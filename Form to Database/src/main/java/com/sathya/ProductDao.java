package com.sathya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public int saveProduct( Product product)
	{
		int result =0;
		
		try(Connection connection = DbProductutils.createConnection();){
		PreparedStatement preparedStatement = connection.prepareStatement("insert into Product_data values(?,?,?,?,?,?,?,?)");	
	preparedStatement.setString(1, product.getProId());
	preparedStatement.setString(2, product.getProName());
	preparedStatement.setDouble(3, product.getProPrice());
	preparedStatement.setString(4, product.getProBrand());
	preparedStatement.setString(5, product.getProMadeIn());
	
	preparedStatement.setDate(6, product.getProMfgDate());
	preparedStatement.setDate(7, product.getProExpDate());
	
	preparedStatement.setBinaryStream(8, product.getProImage());

	result = preparedStatement.executeUpdate();	
		}
		catch(SQLException e ) {
		e.printStackTrace();	
		}
		return result;
		}
	
	//findall
		public  List<Product> findAll() {
		
			List<Product>products=new ArrayList<Product>();
			
			Product product1 =null;
			try(Connection connection = DbProductutils.createConnection())
			{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Product_data");
			 
			while(resultSet.next())
			{
			product1 = new Product();
			product1.setProId(resultSet.getString(1));
			product1.setProName(resultSet.getString(2));
			product1.setProPrice(resultSet.getDouble(3));
			product1.setProBrand(resultSet.getString(4));
			product1.setProMadeIn(resultSet.getString(5));
			product1.setProMfgDate(resultSet.getDate(6));
			product1.setProExpDate(resultSet.getDate(7));
			product1.setReadImage(resultSet.getBytes(8));
			
			products.add(product1);
		        }
			}
	   catch(SQLException e)
	            {e.printStackTrace();
		   }
			return products;
		}


		//delete by Id
		public int deletebyId( String  proId) {
			
			
				int result=0;
				try(Connection connection= DbProductutils.createConnection())
				{
				PreparedStatement preparedStatement = connection.prepareStatement("delete from  Product_data where proId=?");	
			     preparedStatement .setString(1,proId);
				result=  preparedStatement.executeUpdate();
				}
				
				catch(SQLException e) {
				e.printStackTrace();	
				}
			return  result;
		
		}

		
		//find by id
		public Product findById(String ProId) {
			Product product1 =null;
			try(Connection connection = DbProductutils.createConnection())
			{
			PreparedStatement preparedStatement = connection.prepareStatement("select*from Product_data where proId=?");
			preparedStatement.setString(1, ProId); 
			ResultSet resultSet = preparedStatement.executeQuery();
			  
			if(resultSet.next())
			{
			product1 = new Product();
			product1.setProId(resultSet.getString(1));
			product1.setProName(resultSet.getString(2));
			product1.setProPrice(resultSet.getDouble(3));
			product1.setProBrand(resultSet.getString(4));
			product1.setProMadeIn(resultSet.getString(5));
			product1.setProMfgDate(resultSet.getDate(6));
			product1.setProExpDate(resultSet.getDate(7));
			product1.setReadImage(resultSet.getBytes(8));
			}
			
		}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
			return product1;
		}
		
//update by Id
		public int updateProduct(Product updatedProduct) {
		    int result = 0;
	    try(Connection connection = DbProductutils.createConnection())
	    {
	    	int parameterIndex = 1;
	    	
	         // SQL query to update product details
	    	 String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
	                 "proMfgDate=?, proExpDate=?" +
	                 (updatedProduct.getProImage() != null ? ", proImage=?" : "") +
	                 " WHERE proId=?";
	        
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            // Set the parameters for the update statement
	        preparedStatement.setString(parameterIndex++, updatedProduct.getProName());
	        preparedStatement.setDouble(parameterIndex++, updatedProduct.getProPrice());
	        preparedStatement.setString(parameterIndex++, updatedProduct.getProBrand());
	        preparedStatement.setString(parameterIndex++, updatedProduct.getProMadeIn());
	        preparedStatement.setDate(parameterIndex++, updatedProduct.getProMfgDate());
	        preparedStatement.setDate(parameterIndex++, updatedProduct.getProExpDate());
	        
	        if ( updatedProduct.getProImage() != null) {
	            preparedStatement.setBinaryStream(parameterIndex++, updatedProduct.getProImage());
	        }
	        
	        preparedStatement.setString(parameterIndex++, updatedProduct.getProId());

	            // Execute the update
	            result = preparedStatement.executeUpdate();
	        }
	     catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return result;
		    }



}


