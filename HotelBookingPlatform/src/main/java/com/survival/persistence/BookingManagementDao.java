package com.survival.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;

public interface BookingManagementDao {
	
	public User validateUser(String username,long phoneNo) throws SQLException;
	public ArrayList<BookingDetails> getActivetBookings(int user_Id) throws SQLException;
	public ArrayList<BookingDetails> getInactivetBookings(int user_Id) throws SQLException;
	public boolean updateName(String name,long phone,String newName) throws SQLException;
	public boolean updateEmail(String name,long phone,String email) throws SQLException;
	public boolean updatePhone(String name,long phone,long newPhone)throws SQLException;

}
