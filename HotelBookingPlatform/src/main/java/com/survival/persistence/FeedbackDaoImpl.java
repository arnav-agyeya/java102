package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.survival.entities.Feedback;
import com.survival.utils.DbConnectionHelper;
import com.survival.utils.DbConnectionHelper;


@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public boolean insertFeedback(Feedback fd) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO FEEDBACK VALUES(?,?,?,?)");
		preparedStatement.setInt(1, fd.getBookingID());
		preparedStatement.setInt(2, fd.getHotelID());
		preparedStatement.setString(3, fd.getFeedbackDescription());
		preparedStatement.setInt(4, fd.getHotelRating());
		
		int f=preparedStatement.executeUpdate();
		
		if(f==0) 
			return false;
		return true;
	}

	@Override
	public ArrayList<Feedback> seeAllFeedback() throws SQLException, ClassNotFoundException {
		
		
		Connection connection= DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FEEDBACK");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		ArrayList<Feedback> result= new ArrayList<>();
		
		while(resultSet.next()) {
			Feedback fb = new Feedback(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(4),resultSet.getString(3));
			result.add(fb);
			
		}
		connection.close();
		
		for (Feedback fb : result) {
			System.out.println(fb);
		}
		
		return result;
	}

	@Override
	public boolean updateHotelRatingAndCount(int userRating, int hotelId) throws ClassNotFoundException, SQLException {
	Connection connection = DbConnectionHelper.getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT HOTELRATING,NOOFFEEDBACK FROM HOTEL WHERE HID=?");
		preparedStatement.setInt(1, hotelId);
		ResultSet resultSet=preparedStatement.executeQuery();
		double retrievedRating=-1;int retrievedFeedback=-1;
		if(resultSet.next()==true) {
		retrievedRating = resultSet.getDouble(1);
		retrievedFeedback = resultSet.getInt(2);
		}
		else {
			return false;
		}
		//System.out.println(retrievedFeedback);
		double temp = (retrievedRating*retrievedFeedback)+userRating;
		temp = temp/(retrievedFeedback+1);
				
		preparedStatement=connection.prepareStatement("UPDATE HOTEL SET HOTELRATING=?, NOOFFEEDBACK=? WHERE HID=?");
		preparedStatement.setDouble(1, temp);
		preparedStatement.setInt(2, retrievedFeedback+1);
		preparedStatement.setInt(3, hotelId);
		
		boolean fl= preparedStatement.execute();
		
		if(fl) return true;
		
		return true;
	}
	
	/*public static void main(String[] args) {
		FeedbackDao fff=new FeedbackDaoImpl();
		boolean fl=false;
		try {
			fl=fff.updateHotelRatingAndCount(2, 2);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fl);
	}*/

}
