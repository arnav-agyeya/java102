package com.survival.persistence;

import java.sql.SQLException;

import com.survival.entities.Guest;

public interface GuestDao {
	public boolean insertGuest(Guest guest)throws SQLException;	
	public  int getMaxGuestId()throws SQLException;
}
