package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Roomtype;
import com.survival.persistence.RoomDaoImpl;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDaoImpl rDao;

	@Override
	public boolean enterRoom(Roomtype room) throws SQLException {
		return rDao.insertRoom(room);
	}

	@Override
	public boolean removeRoom(Integer rTypeID) throws SQLException {
		return rDao.deleteRoom(rTypeID);
	}

	@Override
	public Roomtype findRoom(Integer rTypeID,Integer hid) throws SQLException {
		return rDao.searchRoom(rTypeID,hid);
	}

	@Override
	public ResultSet viewAllRooms() throws SQLException {
		return rDao.getAllRooms();
	}

	@Override
	public boolean removeRoom(Integer rTypeID, Integer hid) throws SQLException {
		return rDao.deleteRoom(rTypeID, hid);
	}

}
