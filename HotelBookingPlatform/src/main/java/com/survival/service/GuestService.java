package com.survival.service;

import java.sql.SQLException;

import com.survival.entities.Guest;



public interface GuestService {
	public boolean enterGuest( Guest guest) throws SQLException;
	public int calculateBillAmount(Integer hid, Integer rtypeid) throws SQLException;
	public int maxGuest()throws SQLException;
	
}
