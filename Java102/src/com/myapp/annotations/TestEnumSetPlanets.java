package com.myapp.annotations;

import java.util.EnumSet;

public class TestEnumSetPlanets {

	public static void main(String[] args) {
		
		for(Planets planets:EnumSet.allOf(Planets.class)) {
			switch (planets) {
			case EARTH:
				System.out.println("Density Of earth "+planets.density() );
				break;
			case MARS:
				System.out.println("Density Of Mars "+planets.density());
				break;
			default:
				System.out.println("No Planet");
				break;
			}
		}
	}

}
