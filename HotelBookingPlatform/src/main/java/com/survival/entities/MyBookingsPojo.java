package com.survival.entities;

import java.sql.Date;

public class MyBookingsPojo {

	private String city;
	private String hname;
	
	private Integer reservationID;
	
	private Integer u_Id;
	private Integer hid;
	private Integer pid;
	private String status;
	private Date checkindate;
	private Integer noofrooms;
	private String type;
	private Integer rtypeid;
	private Date checkoutdate;
	private String name;
	private Integer roomPrice;
	private Integer discount;
	private int totalPrice;
	
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	

	
	Reservation reservation=new Reservation();
	Hotel hotel=new Hotel();
	Roomtype rommType=new Roomtype();
	Guest guest=new Guest();
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Integer getReservationID() {
		return reservationID;
	}
	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}
	public Integer getU_Id() {
		return u_Id;
	}
	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}
	public Integer getNoofrooms() {
		return noofrooms;
	}
	public void setNoofrooms(Integer noofrooms) {
		this.noofrooms = noofrooms;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getRtypeid() {
		return rtypeid;
	}
	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
	}
	public Date getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTotalPrice() {
		 int price=noofrooms*roomPrice;
		 
		 return price;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Roomtype getRommType() {
		return rommType;
	}
	public void setRommType(Roomtype rommType) {
		this.rommType = rommType;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	
	
	
	
	
}
