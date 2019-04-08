package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;
import com.survival.persistence.HotelDao;

public interface HotelService {

	
	/*	public boolean insertHotel(Hotel hotel)throws SQLException;	
	public boolean deleteHotel(String hotelName) throws SQLException;
	public Hotel searchHotel(String hotelName) throws SQLException;
	public ResultSet getAllHotels() throws SQLException;*/
	
	public boolean enterHotel(Hotel hotel) throws SQLException;
	
	public boolean removeHotel(Integer hotelId) throws SQLException;
	
	public Hotel findHotel(Integer hotelId) throws SQLException;
	
	public ResultSet viewAllHotel() throws SQLException;
	
	
}

