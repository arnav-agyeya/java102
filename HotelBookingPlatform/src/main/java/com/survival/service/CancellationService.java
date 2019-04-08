package com.survival.service;

import java.sql.SQLException;

public interface CancellationService {
	boolean isCancelled(int reservationId,int chargeSlab) throws ClassNotFoundException,SQLException;
	boolean isValidBooking(int reservationId,int userId) throws ClassNotFoundException,SQLException;
	int chargeSlab(int reservationId) throws ClassNotFoundException,SQLException;
	boolean isAlreadyCancelled(int reservationId) throws ClassNotFoundException,SQLException;
}
