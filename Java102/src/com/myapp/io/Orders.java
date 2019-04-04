package com.myapp.io;

import java.io.Serializable;

public class Orders  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private transient int orderid;
	
	private String ordername;
	
	private double orderprice;

	public Orders(int orderid, String ordername, double orderprice) {
		this.orderid = orderid;
		this.ordername = ordername;
		this.orderprice = orderprice;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [orderid=");
		builder.append(orderid);
		builder.append(", ordername=");
		builder.append(ordername);
		builder.append(", orderprice=");
		builder.append(orderprice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
