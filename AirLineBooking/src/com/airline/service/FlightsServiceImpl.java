package com.airline.service;

import java.util.ArrayList;
import java.util.Comparator;

import com.airline.dao.FlightsDao;
import com.airline.dao.FlightsDaoImpl;
import com.airline.entity.Flights;


public class FlightsServiceImpl implements FlightsService {

	private FlightsDao fd = new FlightsDaoImpl();
	
	@Override
	public ArrayList<Flights> showAllFlights() {
		
		return fd.showAllFlights();
	}

	@Override
	public ArrayList<Flights> searchFlights(String source, String destination) {
		// TODO Auto-generated method stub
		return fd.searchFlights(source, destination);
	}

	@Override
	public ArrayList<Flights> sortTime(ArrayList<Flights> listFlights) {
		
		Comparator<Flights> c=	
				(o1, o2)->((Integer)o1.getTime()).compareTo(o2.getTime());
		listFlights.sort(c);
		return listFlights;
		
		
	}

	@Override
	public ArrayList<Flights> sortFare(ArrayList<Flights> listFlights) {
		
		Comparator<Flights> c=	
				(o1, o2)->((Integer)o1.getFare()).compareTo(o2.getFare());
		listFlights.sort(c);
		return listFlights;
	}

	@Override
	public ArrayList<Flights> sortTimeAndFare(ArrayList<Flights> listFlights) {
		Comparator<Flights> c=	
				(o1, o2)->{
					
					if(((Integer)o1.getFare()).compareTo(o2.getFare())!=0) 
						return ((Integer)o1.getFare()).compareTo(o2.getFare());
					else
						return ((Integer)o1.getTime()).compareTo(o2.getTime());
						
						
					
					
				};
		listFlights.sort(c);
		return listFlights;
	}

}
