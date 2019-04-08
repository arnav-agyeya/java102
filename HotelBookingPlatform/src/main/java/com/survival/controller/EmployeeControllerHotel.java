package com.survival.controller;
import java.sql.SQLException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Hotel;
import com.survival.entities.Package;
import com.survival.entities.Roomtype;
import com.survival.service.HotelServiceImpl;
import com.survival.service.PackageService;
import com.survival.service.PackageServiceImpl;




@Controller
public class EmployeeControllerHotel {


	@Autowired
	HotelServiceImpl hService;
	
	@RequestMapping("/EmployeeDashboard")
	public ModelAndView empDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command",new Hotel());
		mv.setViewName("EmployeeDashboard");
		return mv;
	}

	@RequestMapping("/AddHotel")
	public ModelAndView addHotel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Hotel());
		mv.setViewName("HotelAdd");
		return mv;
	}

	
	@RequestMapping("/AddHotelResult")
	public ModelAndView insertResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
		
		try {
			if(hService.enterHotel(hotel))
			{
				modelAndView.setViewName("insertsuccesshotel");
			}
			else
			{
				modelAndView.setViewName("hotelfailure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping("/DeleteHotel")
	public ModelAndView deleteHotel()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Hotel());
		mv.setViewName("HotelDelete");
		return mv;
	}
	

	@RequestMapping("/DeleteHotelResult")
	public ModelAndView deleteResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
	
		try {
			if(hService.removeHotel(hotel.getHid()))
			{
				modelAndView.setViewName("deletesuccesshotel");
			}
			else
			{
				modelAndView.setViewName("hotelfailure");
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
	} 
	
//	@RequestMapping("/UpdateHotel")
//	public ModelAndView updateHotel() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("command", new Hotel());
//		mv.setViewName("HotelUpdate");
//		return mv;
//	}
//
	@RequestMapping("/UpdateHotelResult")
	public ModelAndView updateResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
		try {
			if(hService.enterHotel(hotel))
			{
				modelAndView.setViewName("insertsuccess");
			}
			else
			{
				modelAndView.setViewName("hotelfailure");
			}
			
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
//	
	
	
	
	@RequestMapping("/SearchHotel")
	public ModelAndView searchHotel()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Hotel());
		mv.setViewName("HotelSearch");
		return mv;
	}
	

	@RequestMapping("/SearchHotelResult")
	public ModelAndView searchResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
		try {
			if(hService.findHotel(hotel.getHid())!=null)
			{
				modelAndView.addObject("msg",hService.findHotel(hotel.getHid()));
				modelAndView.setViewName("searchsuccesshotel");		}
			else
			{
				modelAndView.setViewName("hotelfailure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
	} 
	
	
	@RequestMapping("/ViewHotel")
	public ModelAndView displayHotel()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Hotel());
		try {
			mv.addObject("msg",hService.viewAllHotel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("HotelView");
		return mv;
	}
	
	




//	@RequestMapping("/ViewSuccess")
//	public ModelAndView searchHotel1()
//	{
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("command",new Hotel());
//		try {
//			mv.addObject("msg",hService.findHotel()));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mv.setViewName("HotelView");
//		return mv;
//	}

//	@RequestMapping("/ViewPackage")
//	public ModelAndView displayPackage()
//	{
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("command",new Package());
//		try {
//			mv.addObject("msg",pService.getAllPackage(location));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mv.setViewName("HotelView");
//		return mv;
//	}
//	
	
}



