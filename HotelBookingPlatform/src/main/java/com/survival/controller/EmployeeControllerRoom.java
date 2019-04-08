package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.survival.entities.Roomtype;

import com.survival.service.RoomServiceImpl;


@Controller
public class EmployeeControllerRoom {

	@Autowired
	RoomServiceImpl rService;




	@RequestMapping("/AddRoom")
	public ModelAndView addRoom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Roomtype());
		mv.setViewName("RoomAdd");
		return mv;
	}


	@RequestMapping("/AddRoomResult")
	public ModelAndView insertResult(@ModelAttribute Roomtype room) {

		ModelAndView modelAndView =new ModelAndView();

		try {

			switch(room.getRtypeid())
			{
			case 1: {room.setType("Deluxe : AC");} break;
			case 2: {room.setType("Deluxe : NON-AC");} break;
			case 3: {room.setType("Premium : King");} break;
			case 4: {room.setType("Premium : Queen");} break;

			}
			System.out.println("hello");
			if(rService.enterRoom(room))
			{
				System.out.println("enter room");
				modelAndView.setViewName("insertsuccessroom");
			}
			else
			{
				modelAndView.setViewName("failure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}


	@RequestMapping("/DeleteRoom")
	public ModelAndView deleteRoom()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Roomtype());
		mv.setViewName("RoomDelete");
		return mv;
	}


	@RequestMapping("/DeleteRoomResult")
	public ModelAndView deleteResult(@ModelAttribute Roomtype room) {

		ModelAndView modelAndView =new ModelAndView();

		try {
			if(rService.removeRoom(room.getRtypeid(),room.getHid()) )
			{
				modelAndView.setViewName("deletesuccessroom");
			}
			else
			{
				modelAndView.setViewName("failure");
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
	@RequestMapping("/UpdateRoomResult")
	public ModelAndView updateResult(@ModelAttribute Roomtype room) {

		ModelAndView modelAndView =new ModelAndView();
		try {
			if(rService.enterRoom(room)  )
			{
				modelAndView.setViewName("insertsuccess");
			}
			else
			{
				modelAndView.setViewName("failure");
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	//	



	@RequestMapping("/ViewRoom")
	public ModelAndView displayRoom()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Roomtype());
		try {
			mv.addObject("msg",rService.viewAllRooms() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("RoomView");
		return mv;
	}




}
