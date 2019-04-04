package com.myapp.generics;

import com.myapp.prototype.Item;
import com.myapp.prototype.Movie;

public class TestGenerics {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 double x=3;
		
		MinMaxArray<Long> intArray=new MinMaxArrayImpl<>
		(3L,4L,567L,99L,22L,56L,67L,6L);
		System.out.println("Min Value "+intArray.min());
		System.out.println("Max Value "+intArray.max());
		
		Class<?> clazz=intArray.getClass();
		
		MinMaxArray<Double> doubleArray=new MinMaxArrayImpl<>
		(3.0,4.0,567.0,9.9,2.2,5.6,6.7,6.0);
		System.out.println("Min Value "+doubleArray.min());
		System.out.println("Max Value "+doubleArray.max());
		
		
		
		MinMaxArray<Item> itemArray=new MinMaxArrayImpl<>
		(new Movie(56.77),new Movie(72.5),new Movie(12333.4));
		System.out.println("Min Value "+itemArray.min());
		System.out.println("Max Value "+itemArray.max());
		
		

	}

}
