package com.myapp.patterns;

import com.myapp.patterns.LunchOrder.MenuBuilder;

public class TestInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuBuilder menuBuilder=new LunchOrder.MenuBuilder();
	LunchOrder order=
	menuBuilder.burger("Veg").pizza("Cheese").icecream("BlackCurrant").build();

	System.out.println(order);
	}

}
