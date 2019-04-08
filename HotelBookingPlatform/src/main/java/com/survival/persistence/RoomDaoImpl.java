package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.survival.entities.Hotel;
import com.survival.entities.Roomtype;

@Repository
public class RoomDaoImpl implements RoomDao {

private Connection conn;
	
	
	public RoomDaoImpl() {
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
	public boolean insertRoom(Roomtype rtype) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO ROOMTYPE VALUES (?,?,?,?,?)");
		pState.setInt(1, rtype.getRtypeid());
		pState.setString(2, rtype.getType());
		pState.setInt(3, rtype.getTotalnoofrooms());
		pState.setDouble(4,rtype.getPrice());
		pState.setInt(5, rtype.getHid());
		return pState.executeUpdate() > 0;
	}

	@Override
	public boolean deleteRoom(Integer rtypeid) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM ROOMTYPE WHERE RTYPEID=?");
		pState.setInt(1, rtypeid);
		return pState.executeUpdate() > 0;
	}

	@Override
	public Roomtype searchRoom(Integer rtypeid,Integer hid) throws SQLException {
PreparedStatement pstate = conn.prepareStatement("SELECT * FROM ROOMTYPE WHERE RTYPEID=? OR HID=?");
		
		pstate.setInt(1, rtypeid);
		pstate.setInt(2, hid);
		ResultSet rSet = pstate.executeQuery();
		Roomtype r=new Roomtype();
			rSet.next();
			r.setRtypeid(rSet.getInt("RTYPEID"));
			r.setType(rSet.getString("TYPE"));
			r.setTotalnoofrooms(rSet.getInt("TOTALNOOFROOMS"));
			r.setPrice(rSet.getInt("PRICE"));
			r.setHid(rSet.getInt("HID"));
			
			
		return r;
	}

	@Override
	public ResultSet getAllRooms() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM ROOMTYPE");
	}

	@Override
	public boolean deleteRoom(Integer rtypeid, Integer hid) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM ROOMTYPE WHERE RTYPEID=? AND HID=?");
		pState.setInt(1, rtypeid);
		pState.setInt(2, hid);
		return pState.executeUpdate() > 0;
	}

}
