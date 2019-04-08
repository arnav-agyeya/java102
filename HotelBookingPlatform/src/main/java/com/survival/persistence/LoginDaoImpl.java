package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.survival.entities.Login;
import com.survival.utils.DbConnectionHelper;

//import oracle.net.aso.r;
@Repository
public class LoginDaoImpl implements LoginDao{
@Override
	public Login searchRecord(String username, String password) throws ClassNotFoundException, SQLException {
		Connection connection=DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM LOGIN WHERE LOGIN_ID=? AND LOGIN_PASSWORD=? AND IS_ACTIVE=?");
		preparedStatement.setString(1,username);
		preparedStatement.setString(2, password);
		preparedStatement.setBoolean(3, true);
		ResultSet resultSet=preparedStatement.executeQuery();
		Login login=null;
		if(resultSet.next())
		{
			
			login=new Login();
			login.setU_Id(resultSet.getInt("U_ID"));
			login.setIs_active(resultSet.getBoolean("IS_ACTIVE"));
			login.setLogin_Role(resultSet.getString("LOGIN_ROLE"));
			login.setLogin_Id(resultSet.getString("LOGIN_ID"));
			login.setLogin_Password(resultSet.getString("LOGIN_PASSWORD"));
		}
		connection.close();
		
		return login;
		
			
	}

@Override
public int searchu_Id(String login_Id) throws ClassNotFoundException, SQLException {
Connection connection=DbConnectionHelper.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("SELECT U_ID FROM LOGIN WHERE LOGIN_ID=? ");
preparedStatement.setString(1,login_Id);
ResultSet resultSet=preparedStatement.executeQuery();
int userId=0;
if(resultSet.next())
{	
userId=resultSet.getInt("U_ID");
}
connection.close();
return userId;
}

}
