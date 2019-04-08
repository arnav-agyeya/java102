

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList" import="com.survival.entities.Package"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <%@ include file = "header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Successfully searched</h1>
<table class="table table-bordered">
<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>No. of rooms</th>
			<th>Discount</th>
			<th>Rating</th>
			<th>No. of feedback</th>
			<th>Room Type Id</th>
		</tr>
		</thead>
		<tbody>
		<%

		Package p1=(Package)request.getAttribute("msg");		
		ArrayList<Package> ls = new ArrayList<Package>(); 
		ls.add(p1);
		
		
		

		
		
		for(Package element:ls){
			out.print("<tr>");
			out.println("<td>" + element.getPid() + "</td>");
			out.println("<td>" +element.getPname() + "</td>");
			out.println("<td>" +element.getHid() + "</td>");
			out.println("<td>" +element.getPrice() + "</td>");
			out.println("<td>" +element.getDescription() + "</td>");
			out.println("<td>" +element.getPackagetype() + "</td>");
			out.println("<td>" +element.getCity() + "</td>");
			out.println("<td>" +element.getNoofdays() + "</td>");
			out.println("<td>" +element.getRtypeid() + "</td>");
			out.print("</tr>");
		}
		
		
		%>
		
	
		
		
		
		</tbody>
	</table>

</body>
</html>