package com.myapp.java8;

import java.util.Comparator;

import com.myapp.io.Orders;

public class OrdersComparator implements Comparator<Orders> {

	@Override
	public int compare(Orders o1, Orders o2) {
		// TODO Auto-generated method stub
		return ((Double)o1.getOrderprice()).compareTo(o2.getOrderprice());
	}

}
