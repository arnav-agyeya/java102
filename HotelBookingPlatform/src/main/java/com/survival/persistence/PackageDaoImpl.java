package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.survival.entities.Package;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.survival.utils.DbConnectionHelper;


public class PackageDaoImpl implements PackageDao {
	
	
	Connection conn;
	@Override
	public Package getRecord(int packageID) throws ClassNotFoundException,SQLException {
		conn=DbConnectionHelper.getConnection();
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM PACKAGE WHERE PID="+packageID);
		if(!rSet.next())
			return null;
		return new Package(rSet.getInt("PID"),rSet.getString("PNAME") , rSet.getInt("HID"), rSet.getInt("PRICE"),rSet.getString("DESCRIPTION"),rSet.getInt("PACKAGETYPE"),rSet.getString("CITY"), rSet.getInt("NOOFDAYS"), rSet.getInt("RTYPEID"));
	}

	@Override
	public boolean insertRecord(Package pack) throws ClassNotFoundException,SQLException {
		conn=DbConnectionHelper.getConnection();
		PreparedStatement pState = conn.prepareStatement("INSERT INTO PACKAGE VALUES (?,?,?,?,?,?,?,?,?)");
		pState.setInt(1, pack.getPid());
		pState.setString(2, pack.getPname());
		pState.setInt(3, pack.getHid());
		pState.setDouble(4, pack.getPrice());
		pState.setString(5, pack.getDescription());
		pState.setInt(6, pack.getPackagetype());
		pState.setString(7, pack.getCity());
		pState.setInt(8, pack.getNoofdays());
		pState.setInt(9, pack.getRtypeid());
		return pState.executeUpdate() > 0;
	}

	@Override
	public boolean deleteRecord(int pID) throws ClassNotFoundException,SQLException {
		conn=DbConnectionHelper.getConnection();
		PreparedStatement pState = conn.prepareStatement("DELETE FROM PACKAGE WHERE PID=?");
		pState.setInt(1, pID);
		return pState.executeUpdate() > 0;
	}

	@Override
	public ResultSet getAllRecord(String location) throws ClassNotFoundException,SQLException {
		conn=DbConnectionHelper.getConnection();
		PreparedStatement pState = conn.prepareStatement("SELECT * FROM PACKAGE WHERE CITY=?");
		pState.setString(1, location);
		return pState.executeQuery();
	}

	@Override
	public ResultSet getAllRecord() throws ClassNotFoundException, SQLException {
		conn=DbConnectionHelper.getConnection();
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM PACKAGE");
	}
	
	@Override
	public ResultSet getAllRecords(int ptype) throws ClassNotFoundException, SQLException {
		conn=DbConnectionHelper.getConnection();
		Statement state=conn.createStatement();
		return state.executeQuery("SELECT * FROM PACKAGE WHERE PACKAGETYPE="+ptype);
	}

}