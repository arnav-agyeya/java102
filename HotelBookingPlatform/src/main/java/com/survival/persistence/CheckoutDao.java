package com.survival.persistence;

import java.sql.SQLException;

import com.survival.entities.Feedback;

public interface CheckoutDao {
	
	
	String getBookingStatus(int reservationID) throws ClassNotFoundException, SQLException;
	Boolean setBookingStatus(int reservationID, String status) throws ClassNotFoundException, SQLException;
	Boolean setHotelRating(int hid, int hotelrating) throws ClassNotFoundException, SQLException;
	int getHotelId(int reservationID) throws ClassNotFoundException, SQLException;
}
