package com.survival.entities;

public class Roomtype {
//	create table roomtype (rtypeid number(10) ,  type varchar(20), totalnoofrooms number(10), price number(5), 
//			hid number(10),primary id(rtypeid, hid), foreign key (hid) references hotel(hid));

	private Integer rtypeid;
	private String type;
	private Integer totalnoofrooms;
	private Integer price;
	private Integer hid;
	
	public Roomtype() {
		// TODO Auto-generated constructor stub
	}
	
	public Roomtype(Integer rtypeid, String type, Integer totalnoofrooms, Integer price, Integer hid) {
		super();
		this.rtypeid = rtypeid;
		this.type = type;
		this.totalnoofrooms = totalnoofrooms;
		this.price = price;
		this.hid = hid;
	}
	public Integer getRtypeid() {
		return rtypeid;
	}
	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTotalnoofrooms() {
		return totalnoofrooms;
	}
	public void setTotalnoofrooms(Integer totalnoofrooms) {
		this.totalnoofrooms = totalnoofrooms;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	
}
