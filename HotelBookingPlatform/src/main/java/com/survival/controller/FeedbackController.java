package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Feedback;
import com.survival.service.FeedbackService;



@Controller
public class FeedbackController {
	
	private int rating;
	private String str;
	private int hotelId;
	private int reservationId;
	@Autowired
	 FeedbackService fbd;
	
	@RequestMapping("/cal2")
	public ModelAndView first(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("command", new Feedback());
		mv.setViewName("feedback");
		return mv;
	}
	
	@RequestMapping("/validatefeedback")
	public ModelAndView second (@RequestParam("tb1") String b1, @RequestParam("tb2") String b2 ,
			@RequestParam("rId") Integer rId,@RequestParam("hId") Integer hId){
		ModelAndView mv=new ModelAndView();
		
		hotelId = hId;
		reservationId=rId;
		rating=Integer.parseInt(b1);
		if(rating<3 && b2.isEmpty()) {
			mv.setViewName("bye");
		}
		else {
			str=b2;
			boolean fl=false,fl1=false;
			Feedback fb = new Feedback(rId,hId,rating,str);
			try {
				fl=fbd.insertFeedback(fb);
				fl1=fbd.updateHotelRating(rating, hId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(fl && fl1)mv.addObject("asdf", "Feedback Submitted Successfully");
			else if(b1.isEmpty()) mv.addObject("asdf", "We would have appreciated some suggestion!!!");
			else
				mv.addObject("asdf", "Could not submit feedback!!!");
			mv.setViewName("byebye");
		}
		return mv;
	}
	
	@RequestMapping("/cal")
	public ModelAndView third (@RequestParam("tb1") String b1 ){
		ModelAndView mv=new ModelAndView();
		str=b1;
		
		
		boolean fl=false,fl1=false;
		Feedback fb = new Feedback(reservationId ,hotelId,rating,str);
		try {
			fl=fbd.insertFeedback(fb);
			fl1=fbd.updateHotelRating(rating, hotelId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fl && fl1)mv.addObject("asdf", "Feedback Submitted Successfully");
		else if(b1.isEmpty()) mv.addObject("asdf", "We would have appreciated some suggestion!!!");
		else
			mv.addObject("asdf", "Could not submit feedback!!!");
		mv.setViewName("byebye");
		return mv;
	}
	
	

}
