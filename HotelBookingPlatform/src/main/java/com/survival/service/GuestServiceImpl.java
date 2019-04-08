package com.survival.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Guest;
import com.survival.entities.Hotel;
import com.survival.persistence.GuestDao;
import com.survival.persistence.GuestDaoImpl;


@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	GuestDao guestDao;
	
	
	public GuestServiceImpl() {
		// TODO Auto-generated constructor stub
		guestDao=new GuestDaoImpl();
	}
	
	@Override
	public boolean enterGuest(Guest guest) throws SQLException {
		// TODO Auto-generated method stub
		return guestDao.insertGuest(guest) ;
	}
	@Override
	public int calculateBillAmount(Integer hid, Integer rtypeid ) throws SQLException {
		// TODO Auto-generated method stub
		HotelServiceImpl hotelServiceImpl =new HotelServiceImpl();
		Hotel hotel=hotelServiceImpl.findHotel(hid);
		
		
		return 0;
	}

	@Override
	public int maxGuest() throws SQLException {
		guestDao=new GuestDaoImpl();
		return guestDao.getMaxGuestId();
	}
	
}
