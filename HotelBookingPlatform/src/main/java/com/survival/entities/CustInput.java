package com.survival.entities;

public class CustInput 
{
 private String city;
 private int minPrice;
 private int maxPrice;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getMinPrice() {
	return minPrice;
}
public void setMinPrice(int minPrice) {
	this.minPrice = minPrice;
}
public int getMaxPrice() {
	return maxPrice;
}
public void setMaxPrice(int maxPrice) {
	this.maxPrice = maxPrice;
}
public CustInput(String city, int minPrice, int maxPrice) {
	super();
	this.city = city;
	this.minPrice = minPrice;
	this.maxPrice = maxPrice;
}
public CustInput() {
	super();
}

}
