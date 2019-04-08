package com.survival.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.CustInput;
import com.survival.entities.SearchResultMain;
import com.survival.service.PackageService;
import com.survival.service.SearchService;
@Controller
public class CustomerSearch 
{
  CustInput maininput=new CustInput();
  int uidglobal =0;
	@Autowired
	SearchService searchservice;
	@Autowired
	PackageService packageservice;
	@RequestMapping("/")
	ModelAndView intialize()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("demohome");
		return mv;
	}
	@RequestMapping("/searchinput")
	ModelAndView insert(@RequestParam("uid")int uid)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new CustInput());
		mv.addObject("trending", searchservice.showTrending());
		mv.setViewName("searchhome");
		uidglobal=uid;
		return mv;
	}
	@RequestMapping("/searchresult")
	ModelAndView viewSearchMain(@ModelAttribute CustInput cust)
	{
		maininput.setCity(cust.getCity());
		maininput.setMaxPrice(cust.getMaxPrice());
		maininput.setMinPrice(cust.getMinPrice());
		String city = cust.getCity();
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.searchByLocation(city);
		mv.addObject("resultSetLocation", resultSet);
		mv.setViewName("viewbylocation");
		return mv;
	}
	@RequestMapping("/filterpricelowhigh")
	ModelAndView viewFilterPrichAsc()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.filterPriceRange(maininput);
		mv.addObject("resultSetFilter", resultSet);
		mv.setViewName("viewbyfilter");
		return mv;
	}
	@RequestMapping("/filterpricehighlow")
	ModelAndView viewFilterPrichDsc()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.filterPriceRangeD(maininput);
		mv.addObject("resultSetFilter", resultSet);
		mv.setViewName("viewbyfilter");
		return mv;
	}
	@RequestMapping("/sorthotellowhigh")
	ModelAndView viewSortHnameAsc()
	{
		String city = maininput.getCity();
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortAlphabetAsc(city);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/sorthotelhighlow")
	ModelAndView viewSortHnameDsc()
	{
		String city = maininput.getCity();
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortAlphabetDsc(city);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/sortpricelowhigh")
	ModelAndView viewSortPriceAsc()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortPriceRangeAsc(maininput);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/sortpricehighlow")
	ModelAndView viewSortPriceDesc()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortPriceRangeDsc(maininput);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/sortbydiscount")
	ModelAndView viewSortByDiscount()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortByDiscount(maininput);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/sortbyrating")
	ModelAndView viewSortByRating()
	{
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.sortByRating(maininput);
		mv.addObject("resultSetSort", resultSet);
		mv.setViewName("viewbysort");
		return mv;
	}
	@RequestMapping("/filterbyrating")
	ModelAndView viewFilterRating(@RequestParam("filter")String filter)
	{
		double rating= Double.parseDouble(filter);
		ArrayList<SearchResultMain> resultSet = new ArrayList<>();
		ModelAndView mv = new ModelAndView();
		resultSet =  searchservice.filterbyrating(maininput, rating);
		mv.addObject("resultSetFilter", resultSet);
		mv.setViewName("viewbyfilter");
		return mv;
	}
	@RequestMapping("/booking")
	ModelAndView bookyourHotel(@RequestParam("hotelbook")String hotelName)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelID", searchservice.getHotelId(hotelName));
		mv.addObject("packageID",0);
		mv.addObject("userid", uidglobal);
		mv.setViewName("demohome");
		return mv;
	}
	@RequestMapping("/packagebooking")
	ModelAndView bookyourPackage(@RequestParam("packagebook")String pName)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageID", searchservice.getPackageId(pName));
		mv.addObject("hotelID",0);
		mv.addObject("userid", uidglobal);
		mv.setViewName("demohome");
		return mv;
	}
	@RequestMapping("/viewallpackages")
	ModelAndView viewPackageHotel()
	{
		String loc = maininput.getCity();
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("package",packageservice.getAllLocPackage(loc));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("viewbypackage");
		return mv;
	}
	@RequestMapping("/viewhotelpackage")
	ModelAndView viewallPackageHotel()
	{
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("package",packageservice.getAllPackage(1));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("viewbypackage");
		return mv;
	}
	
	
}
