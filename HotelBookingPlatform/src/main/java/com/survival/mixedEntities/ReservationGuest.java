package com.survival.mixedEntities;

import java.time.LocalDate;

public class ReservationGuest {

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
	private Integer gid;
	private String name;
	private Long phone;
	private String email;
	private String modeofpayment;
	private Boolean is_active;
	
	private String inDay;
	private String inMonth;
	private String inYear;
	private String outDay;
	private String outMonth;
	private String outYear;
	
	public ReservationGuest(Integer reservationID, Integer rtypeid, Integer u_Id, Integer hid, Integer pid,
			String status, LocalDate checkindate, Integer noofrooms, Integer dealtype, LocalDate checkoutdate, Integer gid,
			String name, Long phone, String email, String modeofpayment, Boolean is_active, String inDay,
			String inMonth, String inYear, String outDay, String outMonth, String outYear) {
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
		this.gid = gid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.modeofpayment = modeofpayment;
		this.is_active = is_active;
		this.inDay = inDay;
		this.inMonth = inMonth;
		this.inYear = inYear;
		this.outDay = outDay;
		this.outMonth = outMonth;
		this.outYear = outYear;
	}

	public ReservationGuest()
	{
		
	}
//	public void convertInDate()
//	{
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//		String date = this.inDay+"/"+this.inMonth+"/"+this.inYear;
//		this.checkindate = LocalDate.parse(date, formatter);
//	}
//	public void convertOutDate()
//	{
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//		String date = this.outDay+"/"+this.outMonth+"/"+this.outYear;
//		this.checkoutdate = LocalDate.parse(date, formatter);
//	}

	public Integer getReservationID() {
		return reservationID;
	}

	public Integer getRtypeid() {
		return rtypeid;
	}

	public Integer getU_Id() {
		return u_Id;
	}

	public Integer getHid() {
		return hid;
	}

	public Integer getPid() {
		return pid;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getCheckindate() {
		return checkindate;
	}

	public Integer getNoofrooms() {
		return noofrooms;
	}

	public Integer getDealtype() {
		return dealtype;
	}

	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}

	public Integer getGid() {
		return gid;
	}

	public String getName() {
		return name;
	}

	public Long getPhone(){
		return (Long)phone;
	}

	public String getEmail() {
		return email;
	}

	public String getModeofpayment() {
		return modeofpayment;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public String getInDay() {
		return inDay;
	}

	public String getInMonth() {
		return inMonth;
	}

	public String getInYear() {
		return inYear;
	}

	public String getOutDay() {
		return outDay;
	}

	public String getOutMonth() {
		return outMonth;
	}

	public String getOutYear() {
		return outYear;
	}

	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}

	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
	}

	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCheckindate() {
		int y=Integer.parseInt(this.getInYear());
		int m=Integer.parseInt(this.getInMonth());
		int d=Integer.parseInt(this.getInDay());
		
		LocalDate dt =  LocalDate.of(y,m,d);
		
		this.checkindate=dt;
		
		
	}

	public void setNoofrooms(Integer noofrooms) {
		this.noofrooms = noofrooms;
	}

	public void setDealtype(Integer dealtype) {
		this.dealtype = dealtype;
	}

	public void setCheckoutdate( ) {
		 
		int y=Integer.parseInt(this.getOutYear());
		int m=Integer.parseInt(this.getOutMonth());
		int d=Integer.parseInt(this.getOutDay());
		
		LocalDate dt =  LocalDate.of(y,m,d);
		
		this.checkoutdate=dt;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setModeofpayment(String modeofpayment) {
		this.modeofpayment = modeofpayment;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public void setInDay(String inDay) {
		this.inDay = inDay;
	}

	public void setInMonth(String inMonth) {
		this.inMonth = inMonth;
	}

	public void setInYear(String inYear) {
		this.inYear = inYear;
	}

	public void setOutDay(String outDay) {
		this.outDay = outDay;
	}

	public void setOutMonth(String outMonth) {
		this.outMonth = outMonth;
	}

	public void setOutYear(String outYear) {
		this.outYear = outYear;
	}

	public void copyCheckInDate(LocalDate date) {
		this.checkindate=date;
	}
	public void copyCheckOutDate(LocalDate date) {
		this.checkoutdate=date;
	}
	
	public static void main(String args) {
			ReservationGuest rg=new ReservationGuest();
			rg.setInDay("03");
			rg.setInMonth("12");
			rg.setInYear("2019");
			rg.setCheckindate();
			System.out.println(rg.getCheckindate());
	}


}
	