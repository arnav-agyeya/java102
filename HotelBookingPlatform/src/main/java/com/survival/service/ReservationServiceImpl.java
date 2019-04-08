
package com.survival.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Reservation;
import com.survival.persistence.ReservationDao;
import com.survival.persistence.ReservationDaoImpl;

@Service
public class ReservationServiceImpl implements ReservationService {

	/*public boolean insertReservation(Reservation reservation) throws SQLException;
	
	public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
	*/
	@Autowired
	ReservationDao rd;

	public ReservationServiceImpl() {
		// TODO Auto-generated constructor stub
		rd=new ReservationDaoImpl();
	
	}
	
	
	@Override
	public boolean bookHotel(Reservation reservation) throws SQLException {
		// TODO Auto-generated method stub
		return rd.insertReservation(reservation);
	}

	@Override
	public ArrayList<Reservation> checkBooking(int u_id) throws SQLException {
		// TODO Auto-generated method stub
		return rd.searchAllReservation(u_id);
	}

	@Override
	public ResultSet getAllBookings() throws SQLException {
		// TODO Auto-generated method stub
		return rd.getAllReservations();
	}

	@Override
	public boolean updateBooking(int u_id) throws SQLException {
		// TODO Auto-generated method stub
		return rd.updateReservation(u_id);
	}

	@Override
	public boolean checkAvailablity(Reservation reservation) throws SQLException {
		// TODO Auto-generated method stub
		return rd.checkAvailable(reservation);
	}


	@Override
	public int checkNoOfBooked(int u_id) throws SQLException {
		// TODO Auto-generated method stub
		return rd.noOfReservation(u_id);
	}


	@Override
	public int maxReservationId() throws SQLException {
		// TODO Auto-generated method stub
		return rd.getMaxReservationId();
	}


	@Override
	public int getHid(int pid) {
		// TODO Auto-generated method stub
		return rd.getHotelId(pid);
	}
	
	
}


