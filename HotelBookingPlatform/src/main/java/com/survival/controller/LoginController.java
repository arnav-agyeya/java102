package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Login;
import com.survival.service.LoginService;
import com.survival.service.LoginServiceImpl;

@Controller
public class LoginController {

@Autowired
LoginServiceImpl loginService;

@RequestMapping("/")
public ModelAndView welcome()
{
	ModelAndView mv=new ModelAndView();
	mv.addObject("command",new Login());
	mv.setViewName("login");
	return mv;
	
}

@RequestMapping("/log")
public ModelAndView login(@ModelAttribute Login login ) throws ClassNotFoundException,SQLException
{
	ModelAndView mv=new ModelAndView();

	Login loginOb=new Login();
	loginOb=loginService.searchLogin(login);
   if(loginOb==null)
    {
		mv.addObject("loginsearch","Login denied");
		mv.setViewName("home");

	}
   else
   {   
	   mv.addObject("loginsearch","Login allowed");
       int uid=loginService.searchData(loginOb.getLogin_Id());
       mv.addObject("userid",uid);
	   String role=loginOb.getLogin_Role();
	   if(role.equalsIgnoreCase("ind") || role.equalsIgnoreCase("cor"))
	   {
		  
		   mv.setViewName("individual");
	   }
	  
	   else
	   {
		   mv.addObject("employee","EMPLOYEE");
		   mv.setViewName("employee");

	   }
   }
	return mv;
}
	@RequestMapping("/ContactUs")
	public ModelAndView ContactUs() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ContactUsPage");
		return mv;
	}
}
