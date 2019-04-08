package com.survival.service;

import java.util.ArrayList;

import com.survival.entities.CustInput;
import com.survival.entities.SearchResultMain;
import com.survival.entities.TrendingMain;

public interface SearchService 
{
	ArrayList<SearchResultMain> searchByLocation(String location);
	  ArrayList<SearchResultMain> filterPriceRange(CustInput customer);
	  ArrayList<SearchResultMain> filterPriceRangeD(CustInput customer);
	  ArrayList<SearchResultMain> sortPriceRangeAsc(CustInput customer);
	  ArrayList<SearchResultMain> sortPriceRangeDsc(CustInput customer);
	  ArrayList<SearchResultMain> sortAlphabetAsc(String location);
	  ArrayList<SearchResultMain> sortAlphabetDsc(String location);
	  ArrayList<SearchResultMain> sortByDiscount(CustInput customer);
	  ArrayList<SearchResultMain> sortByRating(CustInput customer);
	  ArrayList<TrendingMain> showTrending();
	  ArrayList<SearchResultMain> filterbyrating(CustInput customer,double rating);
	  int getHotelId(String hotelName);
	  int getPackageId(String packageName);
}
