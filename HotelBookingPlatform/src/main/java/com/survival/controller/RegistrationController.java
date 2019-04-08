package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.survival.dataTransferObject.RegisterLoginDetails;
import com.survival.service.RegisterUserServiceImplementation;

@Controller
public class RegistrationController {
	
	@Autowired
	RegisterUserServiceImplementation userService;
	
	/**
	 * @return
	 */
	@RequestMapping("/registration")
	public ModelAndView enterLoginDetails() {
		ModelAndView modelAndViewForRgistration = new ModelAndView();
		modelAndViewForRgistration.addObject("command",new RegisterLoginDetails());
		modelAndViewForRgistration.setViewName("LoginDetailsEntry");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		return modelAndViewForRgistration;
	
	}	
	
	/**
	 * Register User
	 * @param login
	 * @return
	 */
	@RequestMapping("/userRegistration")
	public ModelAndView enterPersonalDetails(@ModelAttribute RegisterLoginDetails login) {
		ModelAndView modelAndViewForStatus = new ModelAndView();
		
		try {
			boolean checkUserExistence = userService.insertUserLoginDetails(login);
			if(checkUserExistence) {
				modelAndViewForStatus.addObject("SuccessfulLogin", "Congrats, you are registered successfully.\nContinue to login.");
				modelAndViewForStatus.setViewName("RegistrationSuccessful");       //go to login page made by Swati       
			}
			else {
				modelAndViewForStatus.addObject("EntryFailed", "Sorry, username already taken. Please choose another username.");
				modelAndViewForStatus.setViewName("RegistrationFailed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			modelAndViewForStatus.addObject("EntryFailed", "Sorry, something went wrong. Please contact admin.");
			modelAndViewForStatus.setViewName("RegistrationFailed");
		}   
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}   
		return modelAndViewForStatus;
	
	}
	
}
