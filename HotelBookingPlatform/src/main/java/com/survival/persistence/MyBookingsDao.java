package com.survival.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.MyBookingsPojo;

public interface MyBookingsDao {
	public ArrayList<MyBookingsPojo> getmyActiveBookings(int userId) throws ClassNotFoundException, SQLException;
	public ArrayList<MyBookingsPojo> getmyInactiveBookings(int userId) throws ClassNotFoundException, SQLException;

}
