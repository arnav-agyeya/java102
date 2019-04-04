package com.myapp.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Orders2  implements Externalizable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private int orderid;
	
	private String ordername;
	
	private double orderprice;
	
	public Orders2() {
		// TODO Auto-generated constructor stub
	}

	public Orders2(int orderid, String ordername, double orderprice) {
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
	
	@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(ordername);
        out.writeDouble(orderprice);
    }
   
    @Override
    public void readExternal(ObjectInput in) 
      throws IOException, ClassNotFoundException {
        this.ordername = in.readUTF();
        this.orderprice = in.readDouble();
    }
	
	
	

}
