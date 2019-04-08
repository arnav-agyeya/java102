package com.survival.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.persistence.CancellationDao;
import com.survival.utils.CancellationSlab;


@Service
public class CancellationServiceImpl implements CancellationService {
	
@Autowired
CancellationDao cancellationDao;

	@Override
	public boolean isCancelled(int reservationId, int chargeSlab) throws ClassNotFoundException, SQLException {
		boolean result=false;
		
		LocalDate cancelDate =LocalDate.now();
		int i=cancellationDao.isCancelled(reservationId, cancelDate, chargeSlab);
		if(i>0)
			result=true;
		return result;
		}
		

	@Override
	public boolean isValidBooking(int reservationId, int userId) throws ClassNotFoundException, SQLException {
		boolean isValid=false;
		isValid=cancellationDao.isValidUser(userId, reservationId);
		return isValid;
	}

	@Override
	public int chargeSlab(int reservationId) throws ClassNotFoundException, SQLException {
		LocalDate cancelDate =LocalDate.now();
		LocalDate checkInDate=cancellationDao.getCheckInDate(reservationId);
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(cancelDate, checkInDate);
		if(noOfDaysBetween<0)
			return -1;
		int chargeSlab=CancellationSlab.chargeSlab(noOfDaysBetween);
		return chargeSlab;
	}


	@Override
	public boolean isAlreadyCancelled(int reservationId) throws ClassNotFoundException, SQLException {
		boolean result=cancellationDao.isAlreadyCancelled(reservationId);
		return result;
	}

}
