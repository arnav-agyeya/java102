package com.shop.dao;

import java.util.ArrayList;

import com.shop.entity.OrderDetails;
import com.shop.entity.Products;

public interface OrderDao {
	
	public ArrayList<Products> showAllProducts();
	public ArrayList<Products> searchByName(String productName);
	
	public OrderDetails orderProduct(String brandName, int quantity);
	
}
