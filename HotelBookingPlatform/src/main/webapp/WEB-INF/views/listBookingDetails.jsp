<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
    <%@page import="com.survival.mixedEntities.ReservationGuest" %>
    <%@page import="java.lang.*" %>
    <%@page import="java.time.LocalDate" %>
    <%@page import="java.time.format.DateTimeFormatter"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Details</title>
</head>
<body>

<%ReservationGuest reservationGuest =(ReservationGuest)request.getAttribute("reservationGuest"); %>
<h1> BOOKING DETAILS</h1>
<% out.println("Name - " + reservationGuest.getName());%><br></br>
<%out.println("Contact No - " + reservationGuest.getPhone());%><br></br>
<%out.println("Email Address - " + reservationGuest.getEmail());%><br></br>
<%out.println("No Of Rooms - " + reservationGuest.getNoofrooms());%><br></br>
<%out.println("Room Type - " + reservationGuest.getRtypeid());%><br></br>
<%out.println("Payment Mode - " + reservationGuest.getModeofpayment());%><br></br>
<%reservationGuest.setCheckindate();%>
<%reservationGuest.setCheckoutdate();%>
<%out.println("Check IN Date - " + reservationGuest.getCheckindate());%><br></br>
<%out.println("Check OUT Date - " + reservationGuest.getCheckoutdate());%><br></br>
<%out.println("Package Details - " + reservationGuest.getDealtype()); %><br></br>

<form action = "./listBookingDetails">

 <br></br> <input type="submit" value="CONFIRM">
</form>
</body>
</html>

