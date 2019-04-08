<%@page import="com.survival.entities.BookingDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
</head>
<body>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<BookingDetails> arrList=new ArrayList<BookingDetails>();  
arrList=(ArrayList<BookingDetails>)request.getAttribute("BookingDetailsList");
if(arrList==null) 
System.out.println("No record found");
else
for(BookingDetails book:arrList) 
{ %>
<table style="width:100%">
  <tr>
    <th>Name</th>
    <th>Phone No</th> 
    <th>Email</th>
    <th>No Of Rooms</th>
    <th>CheckIn Date</th>
    <th>Checkout Date</th>
    <th>Hotel Name</th>
    <th>Package Name</th>
  </tr>
  <tr>
    <td><% out.println(book.getName()); %></td>
    <td><%out.println(book.getPhone_no()); %></td>
    <td><%out.println(book.getEmail()); %></td>
    <td><%out.println(book.getNo_of_rooms()); %></td>
    <td><%out.println(book.getCheck_in()); %></td>
    <td><%out.println(book.getCheck_out()); %></td>	
    <td><%out.println(book.getHotel_name()); %></td>	
    <td><%out.println(book.getPackage_name()); %></td>		
  </tr>
</table>
<%} %>


</body>
</html>