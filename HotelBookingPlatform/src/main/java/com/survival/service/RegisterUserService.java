package com.survival.service;

import java.sql.SQLException;

import com.survival.dataTransferObject.RegisterLoginDetails;
import com.survival.entities.User;

public interface RegisterUserService {
	/**
	 * @param login
	 * @return
	 * @throws SQLException
	 * Inserts all the details of new user into database
	 */
	public boolean insertUserLoginDetails(RegisterLoginDetails login) throws SQLException;
	/**
	 * @param user
	 * @param login_Id
	 * @return
	 * @throws SQLException
	 * Inserts the personal details of new user into database
	 */
	public boolean insertUserPersonalDetails(User user) throws SQLException;
	
	/**
	 * @param login_Id
	 * @return
	 * @throws SQLException
	 * Checks if the username has already been taken 
	 */
	public boolean checkIfTheUserExists(String login_Id) throws SQLException;
}
