
package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Hotel;
import com.survival.persistence.HotelDao;
import com.survival.persistence.HotelDaoImpl;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDaoImpl hd;
	
	
	@Override
	public boolean enterHotel(Hotel hotel) throws SQLException {
		
		return hd.insertHotel(hotel);
	}

	@Override
	public boolean removeHotel(Integer hotelId) throws SQLException {
		
		return hd.deleteHotel(hotelId);
	}

	@Override
	public ResultSet viewAllHotel() throws SQLException {
		// TODO Auto-generated method stub
		return hd.getAllHotels();
	}

	@Override
	public Hotel findHotel(Integer hotelId) throws SQLException {
	return hd.searchHotel(hotelId);
	}

	
}
