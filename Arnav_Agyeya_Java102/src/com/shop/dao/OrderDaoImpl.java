package com.shop.dao;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.shop.entity.OrderDetails;
import com.shop.entity.Products;

public class OrderDaoImpl implements OrderDao {
	
	private ArrayList<Products> allProducts = new ArrayList<>();
	private ArrayList<Products> result = new ArrayList<>();
	
	private ArrayList<Products> loadAllProducts(){
		
		//Air India
		try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader("C:\\Users\\arnagyey\\eclipse-workspace\\Arnav_Agyeya_Java102\\src\\Products_SuperStore.csv"); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            
	        	Products products = new Products(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]));
	        	//System.out.println(flights);
	        	 allProducts.add(products);
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		return allProducts;
	}

	@Override
	public ArrayList<Products> showAllProducts() {
		// TODO Auto-generated method stub
		return loadAllProducts();
	}

	@Override
	public synchronized ArrayList<Products> searchByName(String productName) {
		 loadAllProducts();
		
		
		
		for(Products products :allProducts) {
			if(products.getName().equals(productName))
				result.add(products);
		}
		
		
		return result;
	}

	@Override
	public synchronized OrderDetails orderProduct(String brandName, int quantity) {
		
		if(result.equals(null)) new OrderDetails();
		
		for(Products products : result) {
			if(products.getBrandName().equals(brandName)) {
				if(products.getStock()<quantity)
					return new OrderDetails();
				else {
					OrderDetails details = new OrderDetails(products, quantity, products.getPrice()*quantity);
					return details;
				}
			}
		}
		
		
		return new OrderDetails();
	}

}
