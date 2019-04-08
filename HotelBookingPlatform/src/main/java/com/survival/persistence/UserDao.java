package com.survival.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.Login;
import com.survival.entities.User;

public interface UserDao {
	public int countNumberOfUsers() throws SQLException;
	public boolean insertUserDetails(User user) throws SQLException;
	public int getUserId(String loginId) throws SQLException;
	public boolean insertLoginDetails(Login login) throws SQLException;
	public boolean searchUser(String loginId) throws SQLException;
	public ArrayList<User> getAllUsers();
	public String getUserRole(Long userId) throws SQLException;
}
