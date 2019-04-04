package com.myapp.prototype;

public class CloneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ItemContainer container=new ItemContainer();
	Movie movie1=(Movie)container.createItem("movie");
	movie1.setName("Bollywood");
	
	Movie movie2=(Movie)container.createItem("movie");
	
	System.out.println(movie1==movie2);
	
	System.out.println("Cloned Object1 "+movie1);
	System.out.println("Cloned Object2 "+movie2);
	

	}

}
