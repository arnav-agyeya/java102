package com.airline.test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.airline.dao.FlightsDao;
import com.airline.dao.FlightsDaoImpl;
import com.airline.entity.Flights;
import com.airline.service.FlightsService;
import com.airline.service.FlightsServiceImpl;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class TestCsv {
	
	public static void main(String[] args) {
		
		FlightsService flightsService = new FlightsServiceImpl();
		Runnable r1=()->System.out.println(flightsService.sortFare(flightsService.searchFlights("Delhi", "Udaipur")));
		
		Runnable r2=()->System.out.println(flightsService.searchFlights("Delhi", "Bangalore"));
		
		List<Runnable> list=new ArrayList<>();
		list.add(r1);
		list.add(r2);

		ExecutorService pool=Executors.newFixedThreadPool(3);
		for(Runnable task:list)
		pool.execute(task);

		pool.shutdown();
		
		
	} 
}
	

