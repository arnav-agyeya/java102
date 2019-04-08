package com.survival.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.persistence.CheckoutDao;

@Service
public class CheckoutServiceImpl implements CheckoutService{
	
	@Autowired
	CheckoutDao checkoutDaoImpl;

	@Override
	public boolean checkoutUser(int reservationId, String status) throws ClassNotFoundException, SQLException {

		if(checkoutDaoImpl.setBookingStatus(reservationId,status))
			return true;
		
			return false;
	}

	@Override
	public boolean setBookingStatus(int reservationID, String status) throws ClassNotFoundException, SQLException {
		
		if(checkoutDaoImpl.setBookingStatus(reservationID, status))
			return true;
		
		return false;
	}

	@Override
	public int getHotelId(int reservationID) throws ClassNotFoundException, SQLException {
		
		return checkoutDaoImpl.getHotelId(reservationID);
	}
	
	
}
