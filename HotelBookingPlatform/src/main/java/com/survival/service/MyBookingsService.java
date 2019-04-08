package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.survival.entities.MyBookingsPojo;

public interface MyBookingsService {

	public ArrayList<MyBookingsPojo> getmyActiveBookings(int userId) throws ClassNotFoundException, SQLException;
	public ArrayList<MyBookingsPojo> getmyInactiveBookings(int userId) throws ClassNotFoundException, SQLException;
}
