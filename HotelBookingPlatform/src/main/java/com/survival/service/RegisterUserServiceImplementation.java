package com.survival.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.dataTransferObject.RegisterLoginDetails;
import com.survival.entities.Login;
import com.survival.entities.User;
import com.survival.persistence.UserDaoImplementation;

@Service
public class RegisterUserServiceImplementation implements RegisterUserService {

	@Autowired
	UserDaoImplementation userDao;
	
	/* (non-Javadoc)
	 * @see com.survival.service.RegisterUserService#insertUserLoginDetails(com.survival.dataTransferObject.RegisterLoginDetails)
	 * Inserts all the details of new user into database
	 */
	@Override
	public boolean insertUserLoginDetails(RegisterLoginDetails login) throws SQLException {
		
		boolean checkUserExistence = checkIfTheUserExists(login.getLogin_Id());
		
		if(checkUserExistence) {
			return false;
		}
		
		Login userLogin = new Login();
		
		userLogin.setLogin_Id(login.getLogin_Id());
		userLogin.setLogin_Password(login.getLogin_Password());
		userLogin.setLogin_Role(login.getLogin_Role());
		userLogin.setIs_active(true);
		int total = userDao.countNumberOfUsers();
		userLogin.setU_Id(total+1);
		
		if(userDao.insertLoginDetails(userLogin)) {
			User user = new User();
			user.setU_Id(userLogin.getU_Id());
			user.setEmail_Id(login.getEmail_Id());
			user.setPhone_Number(login.getPhone_Number());
			user.setUser_Address(login.getUser_Address());
			user.setUser_role(login.getLogin_Role());
			user.setUser_Name(login.getUser_Name());
			user.setIs_active(true);
			
			return insertUserPersonalDetails(user);
		}
		return false;
		
	}

	/* (non-Javadoc)
	 * @see com.survival.service.RegisterUserService#insertUserPersonalDetails(com.survival.entities.User, java.lang.String)
	 * Inserts the personal details of new user into database
	 */
	@Override
	public boolean insertUserPersonalDetails(User user) throws SQLException {
		
		boolean checkInsert = userDao.insertUserDetails(user);
		
		if(checkInsert)
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.survival.service.RegisterUserService#checkIfTheUserExists(java.lang.String)
	 * Checks if the username has already been taken
	 */
	@Override
	public boolean checkIfTheUserExists(String login_Id) throws SQLException {
		
		return userDao.searchUser(login_Id);
	}

}
