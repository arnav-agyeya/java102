package com.survival.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Guest;
import com.survival.entities.Reservation;
import com.survival.mixedEntities.ReservationGuest;
import com.survival.service.GuestService;
import com.survival.service.GuestServiceImpl;
import com.survival.service.ReservationService;
import com.survival.service.ReservationServiceImpl;

@Controller
//@SessionAttributes("reservationPage")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	@Autowired
	GuestService guestService;
	
	ReservationGuest reservationGuestNew = new ReservationGuest();
	int hid1;
	int pid1;
	int uid1;
	@RequestMapping("/resstart")
	public ModelAndView first(@RequestParam("hid") int hid,@RequestParam("pid") int pid,@RequestParam("uid")int uid)
	{
		hid1=hid;
		pid1=pid;
		uid1=uid;
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new ReservationGuest());
		mv.addObject("hid", hid);
		mv.addObject("pid", pid);
		mv.addObject("uid",uid);
		mv.setViewName("reservation");
		return mv;
	}
	
	@RequestMapping("/reservation")
	public ModelAndView reservation(@ModelAttribute ReservationGuest reservationGuest)
	{
		
		ModelAndView mv = new ModelAndView();
		
		
		Reservation reservation= new Reservation();
		Guest guest=new Guest();
		

		
		reservationGuest.setCheckindate();
		reservationGuest.setCheckoutdate();
		reservation.setCheckindate(reservationGuest.getCheckindate());
		reservation.setCheckoutdate(reservationGuest.getCheckoutdate());
		reservation.setDealtype(reservationGuest.getDealtype());
		
		reservation.setNoofrooms(reservationGuest.getNoofrooms());
		reservation.setPid(reservationGuest.getDealtype());
		int max=1;
		int maxguestid=1;
		try {
			max = reservationService.maxReservationId()+1;
			maxguestid= guestService.maxGuest()+1;
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(max);
		System.out.println(maxguestid);
		reservation.setReservationID(max);
		reservation.setRtypeid(reservationGuest.getRtypeid());
		reservation.setStatus("processing");
		reservation.setU_Id(1);
		reservation.setHid(2);
		
		
		
		
		if(hid1!=0) {
			reservationGuestNew.setHid(hid1);
			reservationGuestNew.setPid(0);
		}else {
			int a=reservationService.getHid(pid1);
			reservationGuestNew.setHid(a);
			reservationGuestNew.setPid(pid1);
		}
		
		reservationGuestNew.setU_Id(uid1);
		reservationGuestNew.copyCheckInDate(reservation.getCheckindate());
		reservationGuestNew.copyCheckOutDate(reservation.getCheckoutdate());
		reservationGuestNew.setDealtype(reservationGuest.getDealtype());
		reservationGuestNew.setEmail(reservationGuest.getEmail());
		reservationGuestNew.setGid(maxguestid);
		
		reservationGuestNew.setIs_active(reservationGuest.getIs_active());
		reservationGuestNew.setName(reservationGuest.getName());
		reservationGuestNew.setNoofrooms(reservationGuest.getNoofrooms());
		reservationGuestNew.setPhone(reservationGuest.getPhone());
		
		reservationGuestNew.setReservationID(max);
		reservationGuestNew.setRtypeid(reservationGuest.getRtypeid());
		reservationGuestNew.setStatus("booked");
		
		reservationGuestNew.setModeofpayment(reservationGuest.getModeofpayment());
		
		

	
		try {
			System.out.println(reservationService.checkAvailablity(reservation));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(reservationService.checkAvailablity(reservation)) {
				mv.addObject("command",reservationGuest);
				mv.setViewName("listBookingDetails");
				return mv;
			}else {
				
				mv.setViewName("notAvailable");
				return mv;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping("/listBookingDetails")
	public ModelAndView listDetails(@ModelAttribute ReservationGuest reservationGuest, HttpServletRequest request)
	{
		
		
				
		
		ReservationService reservationservice = new ReservationServiceImpl();
		Reservation reservation= new Reservation();
		
	
		reservation.setCheckindate(reservationGuestNew.getCheckindate());
		reservation.setCheckoutdate(reservationGuestNew.getCheckoutdate());
		reservation.setDealtype(reservationGuestNew.getRtypeid());
		
		reservation.setNoofrooms(reservationGuestNew.getNoofrooms());
		reservation.setPid(reservationGuestNew.getPid());
		reservation.setRtypeid(reservationGuestNew.getRtypeid());
		reservation.setStatus("booked");
		reservation.setU_Id(reservationGuestNew.getU_Id());
		reservation.setHid(reservationGuestNew.getHid());
		reservation.setReservationID(reservationGuestNew.getReservationID());
		
		System.out.println(reservation.getStatus()+" "+
							reservation.getDealtype()+" "+
							reservation.getHid()+" "+
							reservation.getNoofrooms()+" "+
							reservation.getPid()+" "+
							reservation.getReservationID()+" "+
							reservation.getRtypeid()+" "+
							reservation.getU_Id()+" "+
							reservation.getCheckindate()+" "+
							reservation.getCheckoutdate());
							
							
		
		
		Guest guest=new Guest();
		guest.setEmail(reservationGuestNew.getEmail());
		guest.setName(reservationGuestNew.getName());
		guest.setPhone(reservationGuestNew.getPhone());
		guest.setReservationid(reservation.getReservationID());
		guest.setGid(reservationGuestNew.getGid());
		guest.setIs_active(true);
		GuestService guestservice=new GuestServiceImpl();
		String paymentMode="";
		paymentMode = reservationGuestNew.getModeofpayment();
				System.out.println(paymentMode);
		ModelAndView mv = new ModelAndView();
		
		if(paymentMode.equalsIgnoreCase("02"))
		{
			try {
				System.out.println(reservationservice.bookHotel(reservation));
				guest.setModeofpayment("Cas");
				
				guest.toString();
				System.out.println(guestservice.enterGuest(guest));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			mv.setViewName("confirmationSuccessCash");
			
		}else if(paymentMode.equalsIgnoreCase("01"))
		{
			
			try {
				System.out.println(reservationservice.bookHotel(reservation));
				guest.setModeofpayment("Onl");
				System.out.println(guest.toString());
				System.out.println(guestservice.enterGuest(guest));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mv.setViewName("confirmationSuccessOnline");
		}
		else
		{
			mv.setViewName("confirmationFailure");
		}
		
		return mv;
	}
	
	@RequestMapping("/back")
	public ModelAndView goBack()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new ReservationGuest());
		mv.setViewName("reservation");
		return mv;
	}
}
