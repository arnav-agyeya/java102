package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.Feedback;

public interface FeedbackService {
	ArrayList <Feedback> seeAllFeedbackService() throws SQLException, ClassNotFoundException;
	boolean insertFeedback(Feedback fbd) throws SQLException, ClassNotFoundException;
	boolean updateHotelRating(int userRating, int hotelId) throws SQLException, ClassNotFoundException;
	
}
