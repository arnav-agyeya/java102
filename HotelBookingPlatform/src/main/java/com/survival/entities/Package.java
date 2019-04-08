
package com.survival.entities;

public class Package {
//	create table package (pid number(10) primary key, pname varchar(20), hid number(10), price number(5), 
//	description varchar(500), packagetype  number(1), city varchar(30), noofdays number(2), rtypeid number(10),
//	foreign key (hid) references hotel(hid) );

	private Integer pid;
	private String pname;
	private Integer hid;
	private Integer price;
	private String description;
	private Integer packagetype;
	private String city;
	private Integer noofdays;
	private Integer rtypeid;
	
	public Package() {
		
	}
	
	public Package(Integer pid, String pname, Integer hid, Integer price, String description, Integer packagetype,
			String city, Integer noofdays, Integer rtypeid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.hid = hid;
		this.price = price;
		this.description = description;
		this.packagetype = packagetype;
		this.city = city;
		this.noofdays = noofdays;
		this.rtypeid = rtypeid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPackagetype() {
		return packagetype;
	}
	public void setPackagetype(Integer packagetype) {
		this.packagetype = packagetype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(Integer noofdays) {
		this.noofdays = noofdays;
	}
	public Integer getRtypeid() {
		return rtypeid;
	}
	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
	}
	
	
}

