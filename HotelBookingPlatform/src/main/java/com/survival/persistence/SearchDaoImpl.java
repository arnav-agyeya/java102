package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.survival.entities.CustInput;
import com.survival.entities.SearchResultMain;
import com.survival.entities.TrendingMain;
import com.survival.utils.DbConnectionHelper;

public class SearchDaoImpl implements SearchDao {

	@Override
	public ArrayList<SearchResultMain> searchByLocation(String location) 
	{
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {


			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =?");
			preparestament.setString(1, location);
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchList=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchList.add(result);
			}
			return searchList;
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;	
	}

	@Override
	public ArrayList<SearchResultMain> filterPriceRange(CustInput input) 
	{
		//System.out.println("input.getCity()"+input.getMaxPrice()+input.getMinPrice());
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {


			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? AND PRICE BETWEEN ? AND ? ORDER BY PRICE");
			preparestament.setString(1, input.getCity());
			preparestament.setInt(2, input.getMinPrice());
			preparestament.setInt(3, input.getMaxPrice());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;	

	}

	@Override
	public ArrayList<SearchResultMain> sortPriceRangeAsc(CustInput customer) 
	{

		Connection connection = null;
		PreparedStatement preparestament=null;
		try {

			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY PRICE");
			preparestament.setString(1,customer.getCity());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public ArrayList<SearchResultMain> sortPriceRangeDsc(CustInput customer) {
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();
			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY PRICE DESC");
			preparestament.setString(1,customer.getCity());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public ArrayList<SearchResultMain> sortAlphabetAsc(String location) 
	{
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {


			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY HNAME");
			preparestament.setString(1, location);
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<SearchResultMain> sortAlphabetDsc(String location) {
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY HNAME DESC");
			preparestament.setString(1, location);
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<SearchResultMain> filterPriceRangeD(CustInput input) 
	{
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {


			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? AND PRICE BETWEEN ? AND ? ORDER BY PRICE DESC");
			preparestament.setString(1, input.getCity());
			preparestament.setInt(2, input.getMinPrice());
			preparestament.setInt(3, input.getMaxPrice());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;		
	}

	@Override
	public ArrayList<SearchResultMain> sortByDiscount(CustInput customer) {

		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();
			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY DISCOUNT DESC");
			preparestament.setString(1, customer.getCity());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<SearchResultMain> sortByRating(CustInput customer) 
	{

		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? ORDER BY HOTELRATING DESC");
			preparestament.setString(1, customer.getCity());
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				//			    System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<TrendingMain> showTrending() {


		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT H.hname, H.city, H.hotelrating, H.address, H.discount, H.city, R.type, R.price FROM hotel H JOIN roomtype R ON H.hid = R.hid WHERE H.occupiedrooms/H.totalrooms >= 0.6 ORDER BY H.occupiedrooms/H.totalrooms DESC");
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<TrendingMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				TrendingMain result =new TrendingMain();
				result.setHotelName(resultSet.getString("HNAME"));
				System.out.println(result.getHotelName());
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				result.setLocation(resultSet.getString("CITY"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null; 
	}


	@Override
	public ArrayList<SearchResultMain> filterbyrating(CustInput customer, double rating) {
		Connection connection = null;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HNAME,HOTELRATING,ADDRESS,DISCOUNT,TYPE,PRICE FROM HOTEL A JOIN ROOMTYPE B ON A.HID=B.HID WHERE CITY =? AND HOTELRATING >=? ORDER BY HOTELRATING DESC");
			preparestament.setString(1, customer.getCity());
			preparestament.setDouble(2, rating);
			ResultSet resultSet=preparestament.executeQuery();
			ArrayList<SearchResultMain> searchListpa=new ArrayList<>();

			while(resultSet.next())
			{
				SearchResultMain result =new SearchResultMain();
				result.setHotelName(resultSet.getString("HNAME"));
				result.setRating(resultSet.getDouble("HOTELRATING"));
				result.setAddress(resultSet.getString("ADDRESS"));
				result.setDiscount(resultSet.getShort("DISCOUNT"));
				result.setRoom_type(resultSet.getString("TYPE"));
				result.setPrice(resultSet.getInt("PRICE"));
				searchListpa.add(result);
			}
			return searchListpa;
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;		
	}

	@Override
	public int getHotelId(String hotelName) 
	{
		Connection connection = null;
		int hotelID=0;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT HID FROM HOTEL WHERE HNAME = ?");
			preparestament.setString(1, hotelName);
			ResultSet resultSet=preparestament.executeQuery();
			if(resultSet.next()) {
			hotelID = resultSet.getInt("HID");
			return hotelID;
			}
			return -222;
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int getPackageId(String packageName) 
	{
		
		Connection connection = null;
		int PACKAGEID=0;
		PreparedStatement preparestament=null;
		try {
			connection=DbConnectionHelper.getConnection();

			preparestament = connection.prepareStatement("SELECT PID FROM PACKAGE WHERE PNAME = ?");
			preparestament.setString(1, packageName);
			ResultSet resultSet=preparestament.executeQuery();
			if(resultSet.next()) {
				PACKAGEID = resultSet.getInt("HID");
				return PACKAGEID;
				}
				return -222;
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally 
		{	
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}




}
