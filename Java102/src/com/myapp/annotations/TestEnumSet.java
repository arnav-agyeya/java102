package com.myapp.annotations;

import java.util.EnumSet;

public class TestEnumSet {

	public static void main(String[] args) {
		
		for(Season season:EnumSet.allOf(Season.class)) {
			switch (season) {
			case SUMMER:
				System.out.println("Summer Season Start Month " 
			+season.getStartMonth()+ " Summer Season End Month "+season.getEndMonth());
				break;
			case WINTER:
				System.out.println("Winter Season Start Month " 
						+season.getStartMonth()+ " Winter Season End Month "+season.getEndMonth());
				break;
			default:
				System.out.println("Spring Season");
				break;
			}
		}
	}

}
