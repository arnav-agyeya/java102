package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.survival.utils.DbConnectionHelper;
@Repository
public class CheckoutDaoImpl implements CheckoutDao {

	@Override
	public Boolean setBookingStatus(int reservationID, String status) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();

		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Reservation SET status = ? WHERE reservationId = ?");
		preparedStatement.setString(1, status);
		preparedStatement.setInt(2, reservationID);
		int f=preparedStatement.executeUpdate();

		if(f==0) 
			return false;
		return true;
	}

	@Override
	public String getBookingStatus(int reservationID) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();

		PreparedStatement preparedStatement=connection.prepareStatement("SELECT status from Reservation WHERE reservationId = ?");
		preparedStatement.setInt(1, reservationID);
		ResultSet resultSet = preparedStatement.executeQuery();

		return resultSet.getString(1);

	}

	@Override
	public Boolean setHotelRating(int hid , int hotelrating) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();

		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE hotel SET hotelrating = ? WHERE hid = ?");
		preparedStatement.setInt(1 , hotelrating);
		preparedStatement.setInt(2, hid);
		int f=preparedStatement.executeUpdate();

		if(f==0) 
			return false;
		return true;
	}

	@Override
	public int getHotelId(int reservationID) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();
		
		PreparedStatement preparedStatement= connection.prepareStatement("SELECT HID FROM RESERVATION WHERE RESERVATIONID=?");
		preparedStatement.setInt(1, reservationID);
		int hotelId=-1;
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			return(resultSet.getInt(1));
		}
		else
			return -1;
		
		
	}

}
