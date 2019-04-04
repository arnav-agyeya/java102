package com.airline.dao;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Airlines;
import com.airline.entity.Flights;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class FlightsDaoImpl implements FlightsDao {

	//private ArrayList<Flights> allFlights;
	
	private ArrayList<Flights> loadAllFlights(){
		
		ArrayList<Flights> allFlights = new ArrayList<>();
		//Air India
		try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader("C:\\Users\\arnagyey\\eclipse-workspace\\AirLineBooking\\src\\AirIndia_Flights.csv"); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            
	        	Flights flights = new Flights(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), Airlines.AI);
	        	//System.out.println(flights);
	        	 allFlights.add(flights);
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		//JetAirways
		
		try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader("C:\\Users\\arnagyey\\eclipse-workspace\\AirLineBooking\\src\\JetAirways_Flights.csv"); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            
	        	Flights flights = new Flights(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), Airlines.JA);
	        	
	        	 allFlights.add(flights);
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		//SpiceJet
		
		try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader("C:\\Users\\arnagyey\\eclipse-workspace\\AirLineBooking\\src\\SpiceJet_Flights.csv"); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            
	        	Flights flights = new Flights(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), Airlines.SJ);
	        	
	        	 allFlights.add(flights);
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		return allFlights;
	}
	
	@Override
	public ArrayList<Flights> showAllFlights() {
		ArrayList<Flights> allFlights =loadAllFlights();
		return allFlights;
	}

	@Override
	public ArrayList<Flights> searchFlights(String source, String destination) {
		// TODO Auto-generated method stub
		ArrayList<Flights> allFlights =loadAllFlights();
		
		ArrayList<Flights> result = new ArrayList<>();
		
		for(Flights flights : allFlights) {
			if(flights.getSource().equals(source) && flights.getDestination().equals(destination))
				result.add(flights);
		}
		
		
		
		return result;
	}

}
