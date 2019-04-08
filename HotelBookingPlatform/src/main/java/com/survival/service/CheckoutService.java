package com.survival.service;

import java.sql.SQLException;

public interface CheckoutService {
	boolean checkoutUser(int reservationId, String status) throws ClassNotFoundException, SQLException;
	boolean setBookingStatus(int reservationID, String status ) throws ClassNotFoundException, SQLException;
	int getHotelId(int reservationID) throws ClassNotFoundException, SQLException;
}
