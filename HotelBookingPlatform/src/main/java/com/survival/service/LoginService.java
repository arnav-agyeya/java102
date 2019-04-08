package com.survival.service;

import java.sql.SQLException;

import com.survival.entities.Login;

public interface LoginService {
public Login searchLogin(Login login) throws ClassNotFoundException,SQLException;
public int searchData(String username) throws ClassNotFoundException,SQLException;
}
