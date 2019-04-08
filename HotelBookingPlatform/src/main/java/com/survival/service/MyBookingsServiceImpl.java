package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.MyBookingsPojo;
import com.survival.persistence.MyBookingsDao;

@Service
public class MyBookingsServiceImpl implements MyBookingsService {

	@Autowired
	private MyBookingsDao myBookingsDao;
	@Override
	public ArrayList<MyBookingsPojo> getmyActiveBookings(int userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<MyBookingsPojo>activeBookings;
		activeBookings=myBookingsDao.getmyActiveBookings(userId);
		
		return activeBookings;
	}
	
	@Override
	public ArrayList<MyBookingsPojo> getmyInactiveBookings(int userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//MyBookingsDao myBookingsDao=new MyBookingsDaoImpl();
		ArrayList<MyBookingsPojo>inactiveBookings;
		inactiveBookings=myBookingsDao.getmyInactiveBookings(userId);
		
		return inactiveBookings;
	}
   
}
