package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.survival.entities.Login;
import com.survival.entities.User;
import com.survival.utils.DbConnectionHelper;
import com.survival.utils.Queries;

@Repository
public class UserDaoImplementation implements UserDao {

	Connection conn = DbConnectionHelper.getConnection();
	
	/* (non-Javadoc)
	 * @see com.survival.persistence.UserDao#insertLoginDetails(com.survival.entities.Login)
	 * Inserts the login details of new user into database
	 */
	@Override
	public boolean insertLoginDetails(Login login) throws SQLException {
		
		PreparedStatement pState = conn.prepareStatement(Queries.INSERT_LOGIN_DETAILS);
		
		pState.setLong(1, login.getU_Id());
		pState.setBoolean(2, login.getIsActive());
		pState.setString(3, login.getLogin_Role());
		pState.setString(4, login.getLogin_Id());
		pState.setString(5, login.getLogin_Password());
		
		return pState.executeUpdate() > 0;
		
	}
	
	/* (non-Javadoc)
	 * @see com.survival.persistence.UserDao#countNumberOfUsers()
	 * Counts the number of users in the database
	 */
	@Override
	public int countNumberOfUsers() throws SQLException {
		
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(Queries.GET_TOTAL_USERS);
		result.next();
		int count = result.getInt("USERS");
		return count;
	}
	
	/* (non-Javadoc)
	 * @see com.survival.persistence.UserDao#getUserId(java.lang.String)
	 * Returns the user_id of user based on the entered login_id
	 */
	@Override
	public int getUserId(String loginId) throws SQLException {
		
		PreparedStatement stmt = conn.prepareStatement(Queries.GET_USER_ID);
		stmt.setString(1, loginId);
		ResultSet result = stmt.executeQuery();
		result.next();
		int userId = result.getInt("U_ID");
		return userId;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.survival.persistence.UserDao#insertUserDetails(com.survival.entities.User, long)
	 * Inserts the personal details of new user into database
	 */
	@Override
	public boolean insertUserDetails(User user) throws SQLException {
		
		PreparedStatement pState = conn.prepareStatement(Queries.INSERT_USER_DETAILS);
		
		pState.setLong(1, user.getU_Id());
		pState.setString(2, user.getEmail_Id());
		pState.setString(3, user.getUser_Name());
		pState.setLong(4, user.getPhone_Number());
		pState.setString(5, user.getUser_Address());
		pState.setString(6, user.getUser_role());
		pState.setBoolean(7, true);
		
		return pState.executeUpdate() > 0;
	}


	@Override
	public boolean searchUser(String loginId) throws SQLException {
		
		PreparedStatement pState = conn.prepareStatement(Queries.CHECK_USER);
		pState.setString(1, loginId);
		ResultSet rSet = pState.executeQuery();
		while(rSet.next()) {
			return true;
		}
		return false;
	}


	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserRole(Long userId) throws SQLException {
		
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(Queries.GET_USER_ROLE+userId);
		result.next();
		String role = result.getString("USER_ROLE");
		return role;
		
	}

}
