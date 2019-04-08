package com.survival.entities;

public class Hotel {
//	create table hotel (hid number(10) primary key, city varchar(30), hname varchar(40), hotelrating number(1), 
//			address varchar(100), totalrooms number(5), discount number(3), nooffeedback number(38) );

	private Integer hid;
	private String city;
	private String hname;
	private Double hotelrating;
	private String address;
	private Integer totalrooms;
	private Integer discount;
	private Integer nooffeedback;
	private Integer occupiedrooms;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	
	public Hotel(Integer hid, String city, String hname, Double hotelrating, String address, Integer totalrooms,
			Integer discount, Integer nooffeedback, Integer occupiedrooms) {
		super();
		this.hid = hid;
		this.city = city;
		this.hname = hname;
		this.hotelrating = hotelrating;
		this.address = address;
		this.totalrooms = totalrooms;
		this.discount = discount;
		this.nooffeedback = nooffeedback;
		this.setOccupiedrooms(occupiedrooms);
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
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
	public Double getHotelrating() {
		return hotelrating;
	}
	public void setHotelrating(Double hotelrating) {
		this.hotelrating = hotelrating;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTotalrooms() {
		return totalrooms;
	}
	public void setTotalrooms(Integer totalrooms) {
		this.totalrooms = totalrooms;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getNooffeedback() {
		return nooffeedback;
	}
	public void setNooffeedback(Integer nooffeedback) {
		this.nooffeedback = nooffeedback;
	}

	public Integer getOccupiedrooms() {
		return occupiedrooms;
	}

	public void setOccupiedrooms(Integer occupiedrooms) {
		this.occupiedrooms = occupiedrooms;
	}
	
	
	
}
