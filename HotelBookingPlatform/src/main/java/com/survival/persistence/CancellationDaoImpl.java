package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import org.springframework.stereotype.Repository;
import com.survival.utils.DbConnectionHelper;

@Repository
public class CancellationDaoImpl implements CancellationDao {

	@Override
	public boolean isValidUser(int userId, int reservationId) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Reservation WHERE u_Id = ? AND reservationId = ?");
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, reservationId);
		ResultSet resultSet=preparedStatement.executeQuery();
		boolean result=resultSet.next();
		connection.close();
		return result;
	}
	
	@Override
	public int isCancelled(int reservationId, LocalDate cancelDate,int chargeSlab)  throws ClassNotFoundException,SQLException{
		Connection connection = DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("Insert into cancellation values(?,?,?)");
		preparedStatement.setInt(1, reservationId);
		preparedStatement.setDate(2, Date.valueOf(cancelDate));
		preparedStatement.setInt(3, chargeSlab);
		int result=preparedStatement.executeUpdate();
		if(result<=0)
			return 0;
	    preparedStatement=connection.prepareStatement("UPDATE Reservation SET status = ? WHERE reservationId = ?");
		preparedStatement.setString(1, "cancelled");
		preparedStatement.setInt(2, reservationId);
		result=preparedStatement.executeUpdate();  
		connection.close();
		return result;
	}

	@Override
	public LocalDate getCheckInDate(int reservationId) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT checkindate FROM Reservation WHERE reservationId = ?");
		preparedStatement.setInt(1, reservationId);
		ResultSet resultSet=preparedStatement.executeQuery();
		LocalDate checkIndate=null;
		while(resultSet.next()) {
			checkIndate=(resultSet.getDate("checkindate")).toLocalDate();
		}
		connection.close();
		return checkIndate;
	}

	@Override
	public boolean isAlreadyCancelled(int reservationId) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Cancellation WHERE reservationId = ?");
		preparedStatement.setInt(1, reservationId);
		ResultSet resultSet=preparedStatement.executeQuery();
		boolean result=resultSet.next();
		connection.close();
		return result;
	}

	
}
