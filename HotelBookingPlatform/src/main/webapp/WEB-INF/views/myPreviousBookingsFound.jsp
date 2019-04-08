<%@page import="com.survival.entities.MyBookingsPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My previous bookings</title>
</head>
<body>


<h1>My Previous Bookings</h1>

<table style="border: 1px solid">
	<tr>
	    <td>GusetName</td>
		<td>HotelName</td>
		<td>HotelCity   </td>
		<td>CheckInDate(yyyy-mm-dd)</td>
		<td>CheckOutDate(yyyy-mm-dd)</td>
		<td>No. of rooms</td>
		<td>RoomType   </td>
		<td>Status      </td>
		<td>TotalAmount</td>
		<td>discount(%)      </td>
		<td>Bill Amount      </td>
	<tr>

<% ArrayList<MyBookingsPojo> bookings=(ArrayList<MyBookingsPojo>)request.getAttribute("bookingsList");
for(MyBookingsPojo pojo:bookings){
%>
<tr>
        <td><% out.println(pojo.getName()); %></td>
		<td><% out.println(pojo.getHname()); %></td>
		<td><% out.println(pojo.getCity()); %></td>
		<td><% out.println(pojo.getCheckindate()); %></td>
		<td><% out.println(pojo.getCheckoutdate()); %></td>
		<td><% out.println(pojo.getNoofrooms()); %></td>
		<td><% out.println(pojo.getType()); %></td>
		<td><% out.println(pojo.getStatus()); %></td>
		<td><% out.println(pojo.getTotalPrice()); %></td>
		<td><% out.println(pojo.getDiscount()); %></td>
		<td><% out.println(pojo.getTotalPrice()-pojo.getTotalPrice()*pojo.getDiscount()/100); %></td>
		
		
	  
	<tr>

<%} %>
</table>





</body>
</html>