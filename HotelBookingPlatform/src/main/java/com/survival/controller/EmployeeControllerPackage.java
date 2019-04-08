package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Hotel;
import com.survival.entities.Package;
import com.survival.service.HotelServiceImpl;
import com.survival.service.PackageService;
import com.survival.service.PackageServiceImpl;

@Controller
public class EmployeeControllerPackage {


	@Autowired
	PackageServiceImpl pService;
	
	@RequestMapping("/AddPackage")
	public ModelAndView addPackage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Package());
		mv.setViewName("PackageAdd");
		return mv;
	}
	
	@RequestMapping("/AddPackageResult")
	public ModelAndView insertResult(@ModelAttribute Package pack) {
		
		ModelAndView modelAndView =new ModelAndView();
		
		try {
			if(pService.insertPackage(pack))
			{
				modelAndView.setViewName("insertsuccess");
			}
			else
			{
				modelAndView.setViewName("packagefailure");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("/DeletePackage")
	public ModelAndView deletePackage()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Package());
		mv.setViewName("PackageDelete");
		return mv;
	}
	
	

	@RequestMapping("/DeletePackageResult")
	public ModelAndView deleteResult(@ModelAttribute Package pack) {
		
		ModelAndView modelAndView =new ModelAndView();
		try {
			if(pService.deletePackage(pack.getPid()))
			{
				modelAndView.setViewName("deletesuccess");
			}
			else
			{
				modelAndView.setViewName("packagefailure");
}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
	} 

	@RequestMapping("/SearchPackage")
	public ModelAndView searchHotel()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Package());
		mv.setViewName("PackageSearch");
		return mv;
	}


	@RequestMapping("/SearchPackageResult")
	public ModelAndView searchResultPackage(@ModelAttribute Package pack) {
		
		ModelAndView modelAndView =new ModelAndView();
		try {
			if(pService.getPackage(pack.getPid())!=null)
			{
				modelAndView.addObject("msg",pService.getPackage(pack.getPid()));
				modelAndView.setViewName("searchsuccesspackage");
			}
			else
			{
				modelAndView.setViewName("packagefailure");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
	} 
	
	
	@RequestMapping("/ViewPackage")
	public ModelAndView displayPackage()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Package());
		try {
			mv.addObject("msg",pService.getAllPackage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("PackageView");
		return mv;
	}
	
	
}
