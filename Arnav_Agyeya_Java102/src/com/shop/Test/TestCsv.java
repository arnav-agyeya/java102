package com.shop.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.shop.dao.OrderDao;
import com.shop.dao.OrderDaoImpl;
import com.shop.entity.OrderDetails;
import com.shop.entity.Products;
import com.shop.service.OrderServiceImpl;

public class TestCsv {
	
	public static void test(int orderNum,OrderServiceImpl impl,String product,String brand, int quan) {
		Scanner scan= new Scanner(System.in);
		//Searching 
		System.out.println("Order No."+orderNum+" Enter Product to search its brand.");
		System.out.println("Order No."+orderNum+" 1.Laptop\n2.Headphones\n3.Pendrive");
		String str = product;
		System.out.println("Order No."+orderNum+" Product Name: "+str);
		
		ArrayList<Products>  res = impl.searchByName(str);
		
		if(res.equals(null)) {
			System.out.println("Order No."+orderNum+" Nothing Found. Entrt right text to search.");
		}
		else {
			System.out.println("Order No."+orderNum+" Brand Name \t Price");
			for(Products products : res) {
				System.out.println("Order No."+orderNum+" "+ products.getBrandName() + "\t" + products.getPrice());
			}
			System.out.println("Order No."+orderNum+" Enter Brand Name to order");
			String brandName = brand;
			System.out.println("Order No."+orderNum+" Brand Name: "+brandName);
			System.out.println("Order No."+orderNum+" Enter Quantity to order" );
			int quantity = quan;
			System.out.println("Order No."+orderNum+" Quantity: "+quantity);
			OrderDetails details = impl.orderProduct(brandName, quantity);
			if(details.getQuantity()==0) {
				System.out.println("Order No."+orderNum+" !!!Brand name or quantity mismatch for "+str+" "+ brandName+" "+ quantity+" !!!\n\n ");
				
			}
			else {
				System.out.println("Order No."+orderNum+" Order Successful!!!\n\n");
				System.out.println("Order No."+orderNum+" Product Details:  " + details.getProducts());
				System.out.println("Order No."+orderNum+" Product quantity: "+ details.getQuantity());
				System.out.println("Order No."+orderNum+" Order Total Amount: "+details.getPrice());
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		 OrderServiceImpl impl = new OrderServiceImpl();
		
		Runnable r1=()->{
			test(1,impl, "Laptop", "Dell 3541", 500);
				
		};
		
		Runnable r2=()->{
			
			test(2,impl, "Headphones", "Panasonic", 5);			
			
			
		};
		
		Runnable r3=()->{
			
			test(3,impl, "Pendrive", "Transcend", 5);			
			
			
		};
		
		
//		r1.run();
//		r2.run();
//		r3.run();
		
		List<Runnable> list=new ArrayList<>();
		list.add(r1);
		list.add(r2);
		list.add(r3);

		ExecutorService pool=Executors.newFixedThreadPool(3);
		for(Runnable task:list)
			pool.execute(task);

		pool.shutdown();
	}
}
