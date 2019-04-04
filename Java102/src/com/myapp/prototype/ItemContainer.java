package com.myapp.prototype;

import java.util.HashMap;
import java.util.Map;

public class ItemContainer {
	
	private Map<String,Item> items= new HashMap<>();
	
	public Item createItem(String type) {
		Item item=null;
	try {
		item=(Item)items.get(type).clone();
	} catch (CloneNotSupportedException e) {
		
		e.printStackTrace();
	}
	return item;
		
		
	}

	private void addItems() {
		Movie movie=new Movie();
		movie.setTitle("Kesari");
		movie.setPrice(585.00);
		movie.setRuntime("2.5Hours");
		items.put("movie", movie);
		
		Book book=new Book();
		book.setTitle("Java11");
		book.setNumberOfPages("1345Pages");
		book.setPrice(965.00);
		items.put("book",book);
		
	}
	
	public ItemContainer() {
		addItems();
	}
	
}
