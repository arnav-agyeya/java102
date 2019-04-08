
package com.survival.persistence;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.survival.entities.Reservation;
import com.survival.utils.Queries;
@Repository
public class ReservationDaoImpl implements ReservationDao {

	
	private Connection conn;
	
	
	public ReservationDaoImpl() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",  "scott", "tiger");
	}
		
	 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

	
	
	
	@Override
	public boolean insertReservation(Reservation reservation)throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO RESERVATION VALUES (?,?,?,?,?,?,?,?,?,?)");
		pState.setInt(1, reservation.getReservationID());
		pState.setInt(2, reservation.getRtypeid());
		pState.setInt(3, reservation.getU_Id());
		pState.setInt(4, reservation.getHid());
		pState.setInt(5,reservation.getPid());
		pState.setString(6,reservation.getStatus());
		pState.setDate(7, Date.valueOf(reservation.getCheckindate()));
		pState.setInt(8, reservation.getNoofrooms());
		pState.setInt(9, reservation.getDealtype());
		pState.setDate(10, Date.valueOf(reservation.getCheckoutdate()));
		return pState.executeUpdate() > 0;
		
		
	}
/*
	@Override
	public Reservation searchReservation(String userEmail)throws SQLException {
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM RESERVATION WHERE ")
	}
*/
	@Override
	public ResultSet getAllReservations() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery(Queries.GET_ALL_RESERVATION);
	}

	@Override
	public boolean updateReservation(int u_id) throws SQLException {
		PreparedStatement pState = conn.prepareStatement(Queries.UPDATE_RESERVATION);
		pState.setString(1, "CANCELLED");
		pState.setInt(2, u_id);
		return pState.executeUpdate() > 0;	
		
		
	}
	@Override
	public ArrayList<Reservation> searchAllReservation(int u_id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps= conn.prepareStatement(Queries.CHECK_RESERVATION);
		ps.setInt(1, u_id);
		ResultSet rSet = ps.executeQuery();
		
		ArrayList<Reservation> ls=new ArrayList<>();
		while(rSet.next()) {
			Reservation r=new Reservation();
			r.setDealtype(rSet.getInt("DEALTYPE"));
			r.setHid(rSet.getInt("HID"));
			r.setNoofrooms(rSet.getInt("NOOFROOMS"));
			r.setPid(rSet.getInt("PID"));
			r.setReservationID(rSet.getInt("RESERVATIONID"));
			r.setRtypeid(rSet.getInt("RTYPEID"));
			r.setStatus(rSet.getString("STATUS"));
			r.setU_Id(rSet.getInt("U_ID"));
			r.setCheckindate(rSet.getDate("CHECKINDATE").toLocalDate());
			r.setCheckoutdate(rSet.getDate("CHECKOUTDATE").toLocalDate());
			
			ls.add(r);
		}
        return ls;
	}




	@Override
	public int noOfReservation(int u_id) throws SQLException {
		PreparedStatement ps= conn.prepareStatement(Queries.CHECK_NUMEBR_OF_BOOKINGS);
		ps.setInt(1, u_id);
		ResultSet rSet = ps.executeQuery();
		
		int count=0;
		while(rSet.next()) {
			count++;
			}
        return count;
	}




	@Override
	public boolean checkAvailable(Reservation reservation) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps= conn.prepareStatement("select count(*) from reservation where status='booked' and hid=? and rtypeid=? and checkindate>=? and checkoutdate<=?");
		ps.setDate(3, Date.valueOf(reservation.getCheckindate()));
		ps.setDate(4, Date.valueOf(reservation.getCheckoutdate()));
		ps.setInt(2, reservation.getRtypeid());
		ps.setInt(1, reservation.getHid());
		
		ResultSet rs=ps.executeQuery();
		rs.next();
		int booked=rs.getInt("COUNT(*)");
		
		ps=conn.prepareStatement(Queries.TOTAL_ROOMS);
		ps.setInt(1, reservation.getRtypeid());
		ps.setInt(2, reservation.getHid());
		
		rs=ps.executeQuery();
		rs.next();
		int totalrooms=rs.getInt("TOTALNOOFROOMS");
		
		if(totalrooms-booked>=reservation.getNoofrooms())
			return true;
		else 
			return false;
		
		
	}




	@Override
	public int getMaxReservationId() {
		int maxreservationid=0;
		try {
		PreparedStatement ps= conn.prepareStatement("SELECT MAX(RESERVATIONID) FROM RESERVATION");
		ResultSet rs=ps.executeQuery();
		rs.next();
		maxreservationid=rs.getInt("MAX(RESERVATIONID)");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return maxreservationid;
	}




	@Override
	public int getHotelId(int pid)  {
		PreparedStatement ps;
		int hid=0;
		try {
			ps = conn.prepareStatement("SELECT HID FROM PACKAGE WHERE PID=?");
			ps.setInt(1, pid);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			hid=rs.getInt("HID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        return hid;
	}
	
	
	
}
