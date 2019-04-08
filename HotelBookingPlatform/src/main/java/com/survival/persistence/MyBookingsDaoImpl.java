package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.survival.utils.DbConnectionHelper;
import com.survival.entities.MyBookingsPojo;
import com.survival.entities.Reservation;

@Repository
public class MyBookingsDaoImpl implements MyBookingsDao {


   
	@Override
	public ArrayList<MyBookingsPojo> getmyActiveBookings(int userId) throws ClassNotFoundException, SQLException
	{
		Connection connection=DbConnectionHelper.getConnection();

		//PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM RESERVATION where U_ID=?");
		PreparedStatement preparedStatement=connection.prepareStatement("select h.hname,h.city,rs.u_id,rs.hid,rs.pid,"
				+ "rs.status,rs.checkindate,rs.noofrooms,rs.checkoutdate,r.type,r.rtypeid,r.price,g.name,rs.reservationid,h.discount from hotel h,"
				+ " reservation rs, roomtype r, guest g where rs.u_id=? and rs.hid=h.hid and g.reservationid=rs.reservationid and status !='cancelled'"
				+ "and r.rtypeid=rs.rtypeid and rs.checkoutdate>sysdate order by rs.checkindate desc " );
		preparedStatement.setInt(1, userId);

		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<MyBookingsPojo>myBookingsList=new ArrayList<>();

		//Reservation reservation=null;

		while(resultSet.next())
		{
			
			MyBookingsPojo myBookingsPojo =new MyBookingsPojo ();
			
			myBookingsPojo.setHname(resultSet.getString(1));
			myBookingsPojo.setCity(resultSet.getString(2));
			myBookingsPojo.setU_Id(resultSet.getInt(3));
			myBookingsPojo.setHid(resultSet.getInt(4));
			myBookingsPojo.setPid(resultSet.getInt(5));
			myBookingsPojo.setStatus(resultSet.getString(6));
			myBookingsPojo.setCheckindate(resultSet.getDate(7));
			
			myBookingsPojo.setNoofrooms(resultSet.getInt(8));
			myBookingsPojo.setCheckoutdate(resultSet.getDate(9));
			
			
			myBookingsPojo.setType(resultSet.getString(10));
			myBookingsPojo.setRtypeid(resultSet.getInt(11));
			myBookingsPojo.setRoomPrice(resultSet.getInt(12));
			myBookingsPojo.setName(resultSet.getString(13));
			
			myBookingsPojo.setReservationID(resultSet.getInt(14));
		
			myBookingsPojo.setDiscount(resultSet.getInt(15));
			

           myBookingsList.add(myBookingsPojo);

		}
		connection.close();

		return myBookingsList;


	}
	
	
	
	
	@Override
	public ArrayList<MyBookingsPojo> getmyInactiveBookings(int userId) throws ClassNotFoundException, SQLException
	{
		Connection connection=DbConnectionHelper.getConnection();

		//PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM RESERVATION where U_ID=?");
		PreparedStatement preparedStatement=connection.prepareStatement("select h.hname,h.city,rs.u_id,rs.hid,rs.pid,rs.status,"
				+ "rs.checkindate,rs.noofrooms,rs.checkoutdate,r.type,r.rtypeid,r.price,g.name,rs.reservationid, h.discount  from hotel h, reservation rs,"
				+ " roomtype r, guest g  where rs.u_id=? and rs.hid=h.hid and g.reservationid=rs.reservationid and "
				+ "r.rtypeid=rs.rtypeid and (rs.checkoutdate<(select sysdate from dual) or ( rs.checkindate>(select sysdate from dual) and status like 'cancelled')  ) order by rs.checkindate desc");
		preparedStatement.setInt(1, userId);

		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<MyBookingsPojo>myBookingsList=new ArrayList<>();

		//Reservation reservation=null;

		while(resultSet.next())
		{
			
			MyBookingsPojo myBookingsPojo =new MyBookingsPojo ();
			
			myBookingsPojo.setHname(resultSet.getString(1));
			myBookingsPojo.setCity(resultSet.getString(2));
			myBookingsPojo.setU_Id(resultSet.getInt(3));
			myBookingsPojo.setHid(resultSet.getInt(4));
			myBookingsPojo.setPid(resultSet.getInt(5));
			myBookingsPojo.setStatus(resultSet.getString(6));
			myBookingsPojo.setCheckindate(resultSet.getDate(7));
			
			myBookingsPojo.setNoofrooms(resultSet.getInt(8));
			myBookingsPojo.setCheckoutdate(resultSet.getDate(9));
			
			
			myBookingsPojo.setType(resultSet.getString(10));
			myBookingsPojo.setRtypeid(resultSet.getInt(11));
			myBookingsPojo.setRoomPrice(resultSet.getInt(12));
			myBookingsPojo.setName(resultSet.getString(13));
			myBookingsPojo.setReservationID(resultSet.getInt(14));
			myBookingsPojo.setDiscount(resultSet.getInt(15));
			
		
			

           myBookingsList.add(myBookingsPojo);

		}
		connection.close();

		return myBookingsList;



	// To use connection if necessary


}
}
