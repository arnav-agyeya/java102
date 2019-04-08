package com.survival.persistence;

import java.sql.SQLException;
import java.time.LocalDate;

public interface CancellationDao {
	        boolean isValidUser(int userId, int reservationId)throws ClassNotFoundException,SQLException;
            int isCancelled(int reservationId, LocalDate cancelDate,int chargeSlab) throws ClassNotFoundException,SQLException;
            LocalDate getCheckInDate(int reservationId) throws ClassNotFoundException,SQLException;
            boolean isAlreadyCancelled(int reservationId) throws ClassNotFoundException,SQLException;
}
