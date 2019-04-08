package com.survival.persistence;

import java.sql.SQLException;

import com.survival.entities.Login;

public interface LoginDao {
public Login searchRecord(String username,String password) throws ClassNotFoundException,SQLException;
public int searchu_Id(String login_Id) throws ClassNotFoundException ,SQLException;
}
