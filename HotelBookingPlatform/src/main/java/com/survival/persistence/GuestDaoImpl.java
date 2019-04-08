package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.survival.entities.Guest;
import com.survival.utils.Queries;

@Repository
public class GuestDaoImpl implements GuestDao {
	
	
	private Connection conn;
	
	public GuestDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		
		
		
	}
	
	@Override
	public boolean insertGuest(Guest guest) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pState = conn.prepareStatement(Queries.ADD_GUEST);
//		create table guest (gid number(10) primary key, name varchar(70), phone number(10), email varchar(35), reservationid number(10), 
//				modeofpayment varchar(3), is_active Integer(1),foreign key (reservationid) references reservation(reservationid));
		
		pState.setInt(1,guest.getGid());
		pState.setString(2, guest.getName());
		pState.setLong(3, guest.getPhone());
		pState.setString(4, guest.getEmail());
		pState.setInt(5,guest.getReservationid());
		pState.setString(6, guest.getModeofpayment());
		pState.setString(7,"y");
		return pState.executeUpdate() > 0;
	}
	
	@Override
	public int getMaxGuestId() {
		int maxguestid=0;
		try {
		PreparedStatement ps= conn.prepareStatement("SELECT MAX(GID) FROM GUEST");
		ResultSet rs=ps.executeQuery();
		rs.next();
		maxguestid=rs.getInt("MAX(GID)");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return maxguestid;
		
		
		
		
		
	}
	

}
