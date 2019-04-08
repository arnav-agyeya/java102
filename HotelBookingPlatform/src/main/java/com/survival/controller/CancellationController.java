package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.survival.service.CancellationServiceImpl;



@Controller
public class CancellationController {
	@Autowired
	CancellationServiceImpl cancellationServiceImpl;
	
	private int rreservationId;
	private int chargeSlab;
	
	@RequestMapping("/cancelStart")
 	public ModelAndView showCancelMenu(@RequestParam("uid") int uid){
 		ModelAndView mv=new ModelAndView();
 		mv.addObject("userid", uid);
 	   mv.setViewName("cancelBooking");
 		return mv;
 	}
	
	@RequestMapping("/cancel")
 	public ModelAndView confirmCancelBooking(@RequestParam("reservationId") int reservationId, 
 			     @RequestParam("uid") int userId){

		rreservationId=reservationId;
 		ModelAndView mv=new ModelAndView();
 		boolean validUser=false,isAlreadyCancelled=false;
 		try {
			validUser=cancellationServiceImpl.isValidBooking(reservationId, userId);
			chargeSlab=cancellationServiceImpl.chargeSlab(reservationId);
			isAlreadyCancelled=cancellationServiceImpl.isAlreadyCancelled(reservationId);
		} 
 		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		if(validUser && chargeSlab>=0 && !isAlreadyCancelled)
 		{
 			mv.addObject("userid", userId);
 	   mv.addObject("cancelValue", chargeSlab);
 	   mv.setViewName("confirmCancel");
 		}
 		else if(!validUser)
 		{
 			mv.addObject("result", "Such Booking doesn't exist!!");
 	 	   mv.setViewName("cancelResult");
 		}
 		else if(chargeSlab<0)
 		{
 			mv.addObject("result", "Sorry this Booking can't be cancelled!! This Booking is OnGoing");
  	 	   mv.setViewName("cancelResult");
 		}
 		else if(isAlreadyCancelled)
 		{
 		   mv.addObject("result", "This Booking is already cancelled!!");
   	 	   mv.setViewName("cancelResult");
 		}
 		return mv;
 	}
	
	@RequestMapping("/confirmcancel")
 	public ModelAndView finalCancel(){
 		ModelAndView mv=new ModelAndView();
 		
 		boolean isCancelled=false;
 	    try {
			isCancelled=cancellationServiceImpl.isCancelled(rreservationId, chargeSlab);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    if(!isCancelled)
 	    
 	 		{
 	 		   mv.addObject("result", "Sorry this Booking can't be cancelled!!");
 	 	 	   mv.setViewName("cancelResult");
 	 		}
 	    else
 	    {
 	    	   mv.addObject("result", "Booking cancelled Successfully!!");
	 	 	   mv.setViewName("cancelResult");
 	    }
 		return mv;
 	}
	
}
