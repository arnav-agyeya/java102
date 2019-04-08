package com.survival.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.survival.entities.CustInput;
import com.survival.entities.SearchResultMain;
import com.survival.entities.TrendingMain;
import com.survival.persistence.SearchDao;
import com.survival.persistence.SearchDaoImpl;
@Service
public class SearchServiceImpl implements SearchService
{
    SearchDao searchdao= new SearchDaoImpl();;
	@Override
	public ArrayList<SearchResultMain> searchByLocation(String location) 
	{
		
		// TODO Auto-generated method stub
		return  searchdao.searchByLocation(location);
	}

	@Override
	public ArrayList<SearchResultMain> filterPriceRange(CustInput customer) 
	{
		return searchdao.filterPriceRange(customer);
	}

	@Override
	public ArrayList<SearchResultMain> sortPriceRangeAsc(CustInput customer) {
		return searchdao.sortPriceRangeAsc(customer);
	}

	@Override
	public ArrayList<SearchResultMain> sortPriceRangeDsc(CustInput customer) {
		
		return searchdao.sortPriceRangeDsc(customer);
	}

	@Override
	public ArrayList<SearchResultMain> sortAlphabetAsc(String location) {
		// TODO Auto-generated method stub
		return searchdao.sortAlphabetAsc(location);
	}

	@Override
	public ArrayList<SearchResultMain> sortAlphabetDsc(String location) {
		return searchdao.sortAlphabetDsc(location);
	}

	
	@Override
	public ArrayList<SearchResultMain> filterPriceRangeD(CustInput customer) 
	{
		
		 return searchdao.filterPriceRangeD(customer);
	}

	@Override
	public ArrayList<SearchResultMain> sortByDiscount(CustInput customer) {
		
		return searchdao.sortByDiscount(customer);
	}

	@Override
	public ArrayList<SearchResultMain> sortByRating(CustInput customer) {
		return searchdao.sortByRating(customer);
	}

	@Override
	public ArrayList<TrendingMain> showTrending() 
	{
		return searchdao.showTrending();
	}

	@Override
	public ArrayList<SearchResultMain> filterbyrating(CustInput customer, double rating) {
		return searchdao.filterbyrating(customer, rating);
	}

	@Override
	public int getHotelId(String hotelName) {
		return searchdao.getHotelId(hotelName);
	}

	@Override
	public int getPackageId(String packageName) {
		
		return searchdao.getPackageId(packageName);
	}
	
 
}
