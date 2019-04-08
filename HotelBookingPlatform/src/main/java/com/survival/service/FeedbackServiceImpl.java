package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Feedback;
import com.survival.persistence.FeedbackDao;


@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackDao fbd ;
	
	@Override
	public ArrayList<Feedback> seeAllFeedbackService() throws SQLException, ClassNotFoundException {
		
		ArrayList<Feedback> result = fbd.seeAllFeedback();   
		return result;
	}

	@Override
	public boolean insertFeedback(Feedback fbdpojo) throws SQLException, ClassNotFoundException {
		//fbd=new FeedbackDaoImpl();
		boolean fl=fbd.insertFeedback(fbdpojo);
		
		if(fl)
			return true;
		return false;
	}

	@Override
	public boolean updateHotelRating(int userRating, int hotelId) throws SQLException, ClassNotFoundException {
		boolean fl = fbd.updateHotelRatingAndCount(userRating, hotelId);
		
		if(fl) return true;
		return false;
	}
	
	/*public static void main(String[] args) {
		FeedbackService fff=new FeedbackServiceImpl();
		boolean fl=false;
		try {
			fl=fff.insertFeedback(new Feedback(2,2,3,"kjaskdfj"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("look");
	}*/

}
