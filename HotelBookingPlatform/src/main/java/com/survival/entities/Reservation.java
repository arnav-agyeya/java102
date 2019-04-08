package com.survival.entities;
import java.time.LocalDate;

public class Reservation {
//	create table Reservation (reservationID number(10) primary key, rtypeid number(10), u_Id number(10), hid number(10), pid number(10), 
//			status varchar(10), checkindate date, noofrooms number(2), dealtype number(1), checkoutdate date,
//			foreign key (hid) references hotel(hid), foreign key (rtypeid) references roomtype(rtypeid), 
//			foreign key (u_Id) references userdb1(u_Id), foreign key (pid) references package(pid) );

	private Integer reservationID;
	private Integer rtypeid;
	private Integer u_Id;
	private Integer hid;
	private Integer pid;
	private String status;
	private LocalDate checkindate;
	private Integer noofrooms;
	private Integer dealtype;
	private LocalDate checkoutdate;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(Integer reservationID, Integer rtypeid, Integer u_Id, Integer hid, Integer pid, String status,
			LocalDate checkindate, Integer noofrooms, Integer dealtype, LocalDate checkoutdate) {
		super();
		this.reservationID = reservationID;
		this.rtypeid = rtypeid;
		this.u_Id = u_Id;
		this.hid = hid;
		this.pid = pid;
		this.status = status;
		this.checkindate = checkindate;
		this.noofrooms = noofrooms;
		this.dealtype = dealtype;
		this.checkoutdate = checkoutdate;
	}
	public Integer getReservationID() {
		return reservationID;
	}
	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}
	public Integer getRtypeid() {
		return rtypeid;
	}
	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
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
	public LocalDate getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(LocalDate checkindate) {
		this.checkindate = checkindate;
	}
	public Integer getNoofrooms() {
		return noofrooms;
	}
	public void setNoofrooms(Integer noofrooms) {
		this.noofrooms = noofrooms;
	}
	public Integer getDealtype() {
		return dealtype;
	}
	public void setDealtype(Integer dealtype) {
		this.dealtype = dealtype;
	}
	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(LocalDate checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	
	
	
}
