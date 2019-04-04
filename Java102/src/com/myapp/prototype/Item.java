package com.myapp.prototype;

public abstract class Item implements Cloneable,Comparable<Item> {

	
	private String title,name;
	
	private double price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(double price) {
		this.price = price;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return ((Double)price).compareTo(o.price);
	}
	
	
}
