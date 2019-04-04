package com.airline.dao;

import java.util.ArrayList;

import com.airline.entity.Flights;


public interface FlightsDao {
	
	public ArrayList<Flights> showAllFlights();
	public ArrayList<Flights> searchFlights(String source ,String destination);
	
	
}
