package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;
import com.survival.entities.Roomtype;

public interface RoomDao {

	public boolean insertRoom(Roomtype rtype)throws SQLException;	
	public boolean deleteRoom(Integer rtypeid) throws SQLException;
	public boolean deleteRoom(Integer rtypeid,Integer hid) throws SQLException;	
	public Roomtype searchRoom(Integer rtypeid,Integer hid) throws SQLException;
	public ResultSet getAllRooms() throws SQLException;
	
	
}
