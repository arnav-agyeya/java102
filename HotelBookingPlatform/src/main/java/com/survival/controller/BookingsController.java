package com.survival.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.MyBookingsPojo;
import com.survival.service.MyBookingsService;

@Controller
public class BookingsController {
	
	//@Autowired
	//MyBookingsDaoImpl myBookingsDaoImpl;
	
	@Autowired
	MyBookingsService myBookingsService;
	
	
	@RequestMapping("/test")
	public ModelAndView first()
	{
		ModelAndView mv=new ModelAndView();
		//ArrayList<Reservation>bookings=null;
		
		//bookings= myBookingsDaoImpl.getmyBookings(userId);
		
		mv.setViewName("myBookings");
		return mv;
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@RequestMapping("/activeBookings")
	public ModelAndView fi(@RequestParam("uid") Integer uid) throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		ArrayList<MyBookingsPojo>myBookings=null;
		
		myBookings=myBookingsService.getmyActiveBookings(uid);
		
		if(null!=myBookings && myBookings.isEmpty())
		{
		mv.setViewName("noActiveBookings");
		}
		else
		{
	    mv.addObject("userid", uid);
		mv.addObject("bookingsList",myBookings);
		
		mv.setViewName("myActiveBookingsFound");
		}
		return mv;
	}
	
	@RequestMapping("/inactiveBookings")
	public ModelAndView fit(@RequestParam("uid") Integer uid) throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		ArrayList<MyBookingsPojo>myBookings=null;
		
		myBookings=myBookingsService.getmyInactiveBookings(uid);
		
		if(myBookings.isEmpty())
		{
		mv.setViewName("noInactiveBookings");
		}
		else
		{
		mv.addObject("bookingsList",myBookings);
		
		mv.setViewName("myPreviousBookingsFound");
		}
		return mv;
	}
	
	
	@RequestMapping("/modify")
	public ModelAndView fitd() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		
		
		
		return mv;
	}
	
/*	@RequestMapping("/cancelStart")
	public ModelAndView fitdd() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}*/

}
