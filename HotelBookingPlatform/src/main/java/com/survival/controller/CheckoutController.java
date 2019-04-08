package com.survival.controller;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Reservation;
import com.survival.service.CheckoutService;





@Controller
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;
	
	private int hotelId;
	private int reservationId;
	
	@RequestMapping("/cout3")
	public ModelAndView checkouttest(@RequestParam("rid") int rid, @RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("rid", rid);
		mv.addObject("name",name);
		//Hotel h = new Hotel();
		//h.setHid(hid);
		//mv.addObject("command",new Hotel());
		mv.setViewName("checkout");
		return mv;
	}
	
	@RequestMapping("/cout")
	public ModelAndView checkoutFirstPass(@RequestParam("tb1") Integer reservationID) {
		ModelAndView mv = new ModelAndView();
		Reservation reservation = new Reservation();
		
		this.reservationId=reservationID;		
		
		mv.addObject("reservationID",reservationID);
		try {
			hotelId=checkoutService.getHotelId(reservationID);
			mv.addObject("hotelID",checkoutService.getHotelId(reservationID));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		mv.setViewName("feedback");
		return mv;
	}
	
	@RequestMapping("/cout2")
	public ModelAndView checkOutFinalPass() {
		ModelAndView mv = new ModelAndView();
		boolean fl = false;
		try {
			fl = checkoutService.setBookingStatus(reservationId, "processing");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fl)
			mv.addObject("message", "Suessful checkout");
		else
			mv.addObject("message", "Sorry");
		mv.setViewName("tata");
		
		return mv;
	}
}
	

	
	

//	@RequestMapping("/AddHotel")
//	public ModelAndView addHotel() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("command", new Hotel());
//		mv.setViewName("HotelAdd");
//		return mv;
//	}
//	
//	@RequestMapping("/AddHotelResult")
//	public ModelAndView insertResult(@ModelAttribute Hotel hotel) {
//		
//		ModelAndView modelAndView =new ModelAndView();
//		
//		try {
//			if(hService.enterHotel(hotel))
//			{
//				modelAndView.setViewName("insertsuccess");
//			}
//			else
//			{
//				modelAndView.setViewName("failure");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return modelAndView;
//	}
//	@RequestMapping("/DeleteHotel")
//	public ModelAndView delete()
//	{
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("command",new Hotel());
//		mv.setViewName("HotelDelete");
//		return mv;
//	}
//	
//	
//	@RequestMapping("/DeleteHotelResult")
//	public ModelAndView deleteResult(@ModelAttribute Hotel hotel) {
//		
//		ModelAndView modelAndView =new ModelAndView();
//		try {
//			if(hService.removeHotel(hotel.getHid()))
//			{
//				modelAndView.setViewName("deletesuccess");
//			}
//			else
//			{
//				modelAndView.setViewName("failure");
//}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return modelAndView;
//		
//	} 
//	
//	@RequestMapping("/ViewHotel")
//	public ModelAndView display()
//	{
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("command",new Hotel());
//		try {
//			mv.addObject("msg",hService.viewAllHotel());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mv.setViewName("HotelView");
//		return mv;
//	}





