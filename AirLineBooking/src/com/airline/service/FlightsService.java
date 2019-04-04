package com.airline.service;
import com.airline.entity.Flights;
import java.util.ArrayList;


public interface FlightsService {
	
	public ArrayList<Flights> showAllFlights();
	public ArrayList<Flights> searchFlights(String source,String destination);
	
	public ArrayList<Flights> sortTime(ArrayList<Flights> listFlights);
	public ArrayList<Flights> sortFare(ArrayList<Flights> listFlights);
	public ArrayList<Flights> sortTimeAndFare(ArrayList<Flights> listFlights);
	
	
}
