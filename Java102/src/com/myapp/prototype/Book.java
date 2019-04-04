package com.myapp.prototype;

public class Book extends Item {
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	private String numberOfPages;

	public String getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	
	

}
