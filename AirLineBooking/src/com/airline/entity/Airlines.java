package com.airline.entity;

public enum Airlines {
	AI("AirIndia"),
	JA("JetAirways"),
	SJ("SpiceJet");
	
	private String airlineName;
	
	private Airlines(String airlineName) {
		// TODO Auto-generated constructor stub
		
		this.airlineName=airlineName;
	}
	
}
