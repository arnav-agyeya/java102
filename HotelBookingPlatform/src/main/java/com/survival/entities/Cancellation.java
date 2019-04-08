package com.survival.entities;

import java.time.LocalDate;

public class Cancellation {
//	create table cancellation( reservationid number(10), cancellationdate date, chargeslab number(1));
	
	private Integer reservationid;
	private LocalDate cancellationdate;
	private Integer chargeslab;
	
	public Cancellation() {
		// TODO Auto-generated constructor stub
	}
	
	public Cancellation(Integer reservationid, LocalDate cancellationdate, Integer chargeslab) {
		super();
		this.reservationid = reservationid;
		this.cancellationdate = cancellationdate;
		this.chargeslab = chargeslab;
	}
	public Integer getReservationid() {
		return reservationid;
	}
	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}
	public LocalDate getCancellationdate() {
		return cancellationdate;
	}
	public void setCancellationdate(LocalDate cancellationdate) {
		this.cancellationdate = cancellationdate;
	}
	public Integer getChargeslab() {
		return chargeslab;
	}
	public void setChargeslab(Integer chargeslab) {
		this.chargeslab = chargeslab;
	}
	
	
}
