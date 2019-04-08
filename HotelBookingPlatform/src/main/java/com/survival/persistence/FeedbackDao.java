package com.survival.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.Feedback;

public interface FeedbackDao {
	boolean insertFeedback(Feedback fd) throws ClassNotFoundException, SQLException;
	boolean updateHotelRatingAndCount(int userRating , int hotelId) throws ClassNotFoundException, SQLException;
	ArrayList <Feedback> seeAllFeedback() throws SQLException, ClassNotFoundException; 
}
