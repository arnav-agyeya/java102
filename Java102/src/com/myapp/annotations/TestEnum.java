package com.myapp.annotations;

public class TestEnum {

	public static void main(String[] args) {
		
		for(Season season:Season.values()) {
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
