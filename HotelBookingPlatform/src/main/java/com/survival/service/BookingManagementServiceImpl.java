package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;
import com.survival.persistence.BookingManagementDao;
import com.survival.persistence.BookingManagementDaoImpl;

@Service
public class BookingManagementServiceImpl implements BookingManagementService {
	
	private BookingManagementDao bookingManagementDao;
	
	public BookingManagementServiceImpl() {
		bookingManagementDao=new BookingManagementDaoImpl();
	}

	@Override
	public User validateUser(String name, long phone) throws SQLException {
		return bookingManagementDao.validateUser(name,phone);
	}

	

	@Override
	public ArrayList<BookingDetails> getActiveBookings(int user_id) throws SQLException {
		return bookingManagementDao.getActivetBookings(user_id);
	}

	@Override
	public ArrayList<BookingDetails> getInactiveBookings(int user_id) throws SQLException {
		return bookingManagementDao.getInactivetBookings(user_id);
	}

	@Override
	public boolean updateName(String name, long phone, String newName) throws SQLException {
		return bookingManagementDao.updateName(name, phone, newName);
	}

	@Override
	public boolean updateEmail(String name, long phone, String email) throws SQLException {
		return bookingManagementDao.updateEmail(name, phone, email);
	}

	@Override
	public boolean updatePhone(String name, long phone, long newPhone) throws SQLException {
		return bookingManagementDao.updatePhone(name, phone, newPhone);
	}
	
	

}
