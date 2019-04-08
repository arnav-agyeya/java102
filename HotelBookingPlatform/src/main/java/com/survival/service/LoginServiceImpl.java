package com.survival.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Login;
import com.survival.persistence.LoginDao;
@Service
public class LoginServiceImpl implements LoginService{
@Autowired 
private LoginDao loginDao;

	@Override
	public Login searchLogin(Login login) throws ClassNotFoundException, SQLException {
	Login loginPojo;
	loginPojo=loginDao.searchRecord(login.getLogin_Id(), login.getLogin_Password());
//	String role=loginPojo.getLogin_Role();
	return loginPojo;
	}

	@Override
	public int searchData(String username) throws ClassNotFoundException, SQLException {
		int userid;
		userid=loginDao.searchu_Id(username);
		return userid;
	}

}
