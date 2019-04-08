package com.survival.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;
import com.survival.utils.DbConnectionHelper;

@Repository
public class BookingManagementDaoImpl implements BookingManagementDao {
    
	private DbConnectionHelper db;
	
	public BookingManagementDaoImpl() {
		db=new DbConnectionHelper();
	}
	
	@Override
	public User validateUser(String username, long phoneNo) throws SQLException {
		Connection conn= db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("Select * from userdb1 where user_name=? AND phone_number=?");
		preparedStatement.setString(1, username);
		preparedStatement.setLong(2, phoneNo);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBoolean(7));
			
		}
		else
		  return null;
	}


	@Override
	public ArrayList<BookingDetails> getActivetBookings(int user_Id) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<BookingDetails> arr=new ArrayList<>();
		Connection conn=db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("Select * from Reservation where u_Id=? and checkoutdate>=(select sysdate from dual)");
		preparedStatement.setInt(1, user_Id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			BookingDetails bookingDetails=new BookingDetails();
			Integer pId=resultSet.getInt("pId");
			bookingDetails.setPackage_name("No packages Selected");
			if(pId!=null)
			{   PreparedStatement preparedStatement2=conn.prepareStatement("Select pName from package where pId=?");
			    preparedStatement2.setInt(1, pId);
			    ResultSet resultSet2=preparedStatement2.executeQuery();
			    if(resultSet2.next())
				     bookingDetails.setPackage_name(resultSet2.getString(1));
			}
			PreparedStatement preparedStatement3=conn.prepareStatement("Select name,phone,email from guest where reservationid=?");
			preparedStatement3.setString(1, resultSet.getString("reservationid"));
			ResultSet resultSet3=preparedStatement3.executeQuery();
			if(resultSet3.next()) {
			bookingDetails.setName(resultSet3.getString("name"));
			bookingDetails.setEmail(resultSet3.getString("email"));
			bookingDetails.setPhone_no(resultSet3.getString("phone"));
			}
			bookingDetails.setCheck_in(resultSet.getDate("checkindate"));
			bookingDetails.setCheck_out(resultSet.getDate("checkoutdate"));
			bookingDetails.setNo_of_rooms(resultSet.getInt("noofrooms"));
			bookingDetails.setReservation_id(resultSet.getInt("reservationid"));
			PreparedStatement preparedStatement2=conn.prepareStatement("Select hname from hotel where hid=?");
			preparedStatement2.setString(1, resultSet.getString("hid"));
			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next())
			    bookingDetails.setHotel_name(resultSet2.getString(1));
		    arr.add(bookingDetails);
		}
		
		return arr;
	}

	@Override
	public ArrayList<BookingDetails> getInactivetBookings(int user_Id) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<BookingDetails> arr=new ArrayList<>();
		Connection conn=db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("Select * from Reservation where u_Id=? and checkoutdate<(select sysdate from dual)");
		preparedStatement.setInt(1, user_Id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			BookingDetails bookingDetails=new BookingDetails();
			Integer pId=resultSet.getInt("pId");
			bookingDetails.setPackage_name("No packages Selected");
			if(pId!=null)
			{   PreparedStatement preparedStatement2=conn.prepareStatement("Select pName from package where pId=?");
			    preparedStatement2.setInt(1, pId);
			    ResultSet resultSet2=preparedStatement2.executeQuery();
				bookingDetails.setPackage_name(resultSet2.getString(1));
			}
			PreparedStatement preparedStatement3=conn.prepareStatement("Select name,phone,email from guest where resesrvationid=?");
			preparedStatement3.setString(1, resultSet.getString("reservationid"));
			ResultSet resultSet3=preparedStatement3.executeQuery();
			bookingDetails.setName(resultSet3.getString("name"));
			bookingDetails.setEmail(resultSet3.getString("email"));
			bookingDetails.setPhone_no(resultSet3.getString("phone"));
			bookingDetails.setCheck_in(resultSet.getDate("checkindate"));
			bookingDetails.setCheck_out(resultSet.getDate("chekoutdate"));
			bookingDetails.setNo_of_rooms(resultSet.getInt("noofrooms"));
			bookingDetails.setReservation_id(resultSet.getInt("reservationid"));
			PreparedStatement preparedStatement2=conn.prepareStatement("Select hname from hotel where hid=?");
			preparedStatement2.setString(1, resultSet.getString("hid"));
			ResultSet resultSet2=preparedStatement2.executeQuery();
			bookingDetails.setHotel_name(resultSet2.getString(1));
		    arr.add(bookingDetails);
		}
		
		return arr;
	}

	@Override
	public boolean updateEmail(String name,long phone, String email) throws SQLException {
		Connection conn=db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("update guest "+"set email=? where name=? and phone=?");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2,name);
		preparedStatement.setLong(3,phone);
		if(preparedStatement.executeUpdate()>0)
			return true;
		return false;
		
	}

	@Override
	public boolean updatePhone(String name,long phone, long newPhone) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("update guest "+"set phone=? where name=? and phone=?");
		preparedStatement.setLong(1, newPhone);
		preparedStatement.setString(2,name);
		preparedStatement.setLong(3,phone);
		if(preparedStatement.executeUpdate()>0)
			return true;
		return false;
		
	}

	@Override
	public boolean updateName(String name,long phone, String newName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=db.getConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("update guest set name=? where name=? and phone=?");
		preparedStatement.setString(1, newName);
		preparedStatement.setString(2,name);
		preparedStatement.setLong(3,phone);
		if(preparedStatement.executeUpdate()>0)
			return true;
		return false;
		
		
	}
	
	
}
