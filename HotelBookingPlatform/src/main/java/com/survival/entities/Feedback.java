package com.survival.entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Feedback {

	private Integer bookingID;
	private int hotelID;
	private int hotelRating;
	private String feedbackDescription;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(Integer bookingID, int hotelID, int hotelRating, String feedbackDescription) {
		super();
		this.bookingID = bookingID;
		this.hotelID = hotelID;
		this.hotelRating = hotelRating;
		this.feedbackDescription = feedbackDescription;
	}
	public Integer getBookingID() {
		return bookingID;
	}
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public int getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}
	public String getFeedbackDescription() {
		return feedbackDescription;
	}
	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}
	@Override
	public String toString() {
		return "Feedback [bookingID=" + bookingID + ", hotelID=" + hotelID + ", hotelRating=" + hotelRating
				+ ", feedbackDescription=" + feedbackDescription + "]";
	}
	
	
	
}
/*public boolean insertFeedback(Feedback feedback) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO FEEDBACK VALUES (?,?,?)");
		pState.setInt(1, feedback.getBookingID());
		pState.setDouble(2, feedback.getHotelRating());
		pState.setString(3, feedback.getFeedbackDescription());
		return pState.executeUpdate() > 0;
	}

	public boolean deleteFeedback(int bookingID) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM FEEDBACK WHERE BID=?");
		pState.setInt(1, bookingID);
		return pState.executeUpdate() > 0;
	}

	public Feedback searchFeedback(int bookingID) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM FEEDBACK WHERE BID="+bookingID);
		return new Feedback(rSet.getInt(1), rSet.getInt(2),  rSet.getInt(3), rSet.getString(4));
	}

	public ResultSet getAllFeedback() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM FEEDBACK");
	}*/
