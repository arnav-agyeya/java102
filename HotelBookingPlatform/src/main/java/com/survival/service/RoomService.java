package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Roomtype;

public interface RoomService {

	public boolean enterRoom(Roomtype room) throws SQLException;
	
	public boolean removeRoom(Integer rTypeID) throws SQLException;
	public boolean removeRoom(Integer rTypeID,Integer hid) throws SQLException;
	
	public Roomtype findRoom(Integer rTypeID,Integer hid) throws SQLException;
	
	public ResultSet viewAllRooms() throws SQLException;
	
}
