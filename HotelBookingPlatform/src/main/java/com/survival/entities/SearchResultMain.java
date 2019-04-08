package com.survival.entities;

public class SearchResultMain 
{
private String hotelName;
private double rating;
private String address;
private int discount;
private String room_type;
private int price;
 public SearchResultMain() {
	super();
}

public SearchResultMain(String hotelName, double rating, String address, int discount, String room_type) {
		super();
		this.hotelName = hotelName;
		this.rating = rating;
		this.address = address;
		this.discount = discount;
		this.room_type = room_type;
	}

public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public String getRoom_type() {
	return room_type;
}
public void setRoom_type(String room_type) {
	this.room_type = room_type;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
