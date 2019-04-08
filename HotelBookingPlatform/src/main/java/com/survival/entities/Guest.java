package com.survival.entities;

public class Guest {
//	create table guest (gid number(10) primary key, name varchar(70), phone number(10), email varchar(35), reservationid number(10), 
//			modeofpayment varchar(3), is_active Integer(1),foreign key (reservationid) references reservation(reservationid));

	private Integer gid;
	private String name;
	private Long phone;
	private String email;
	private Integer reservationid;
	private String modeofpayment;
	private Boolean is_active;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}
	
	public Guest(Integer gid, String name, Long phone, String email, Integer reservationid, String modeofpayment,
			Boolean is_active) {
		super();
		this.gid = gid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.reservationid = reservationid;
		this.modeofpayment = modeofpayment;
		this.is_active = is_active;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getReservationid() {
		return reservationid;
	}
	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}
	public String getModeofpayment() {
		return modeofpayment;
	}
	public void setModeofpayment(String modeofpayment) {
		this.modeofpayment = modeofpayment;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	
}
