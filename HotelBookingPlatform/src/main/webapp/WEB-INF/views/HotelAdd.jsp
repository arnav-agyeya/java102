<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList" import="com.survival.entities.Package"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hotel Details</title>
</head>
<body>
<h1>Add Hotel Details</h1>
<form:form action="./AddHotelResult" method="post">
		Add Hotel Id:<form:input path="hid"/>		Add Hotel Name:<form:input path="hname"/>
		Add Total Rooms:<form:input path="totalrooms"/>
		Add Discount:<form:input path="discount"/><br>
		Add City:<form:input path="city"/>
		Add Address:<form:input path="address"/>
		Add Hotel Rating:<form:input path="hotelrating"/>
		Add Hotel No of Ratings:<form:input path="nooffeedback"/><br>
		
<input type="submit" name= "operations" value="Submit">
	</form:form>
</body>
</html>