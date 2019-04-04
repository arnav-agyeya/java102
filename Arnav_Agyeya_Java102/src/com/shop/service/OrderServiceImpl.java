package com.shop.service;

import java.util.ArrayList;

import com.shop.dao.OrderDao;
import com.shop.dao.OrderDaoImpl;
import com.shop.entity.OrderDetails;
import com.shop.entity.Products;

public class OrderServiceImpl {

	private volatile OrderDao dao = new OrderDaoImpl();
	
	public synchronized ArrayList<Products> searchByName(String productName){
		return dao.searchByName(productName);
	}
	
	public synchronized OrderDetails orderProduct(String brandName, int quantity){
		return dao.orderProduct(brandName, quantity);
	}
	
}
