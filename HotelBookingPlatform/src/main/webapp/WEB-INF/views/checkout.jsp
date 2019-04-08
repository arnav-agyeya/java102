<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apna Hotel:User Information</title>
</head>
<body>
<form:form action="./cout?tb1=${rid}">
<h1>Enter Reservation Id : ${rid}</h1> <br><br>
<h1>Enter Name : ${name} </h1><br>
<br><br><br>
<center><input type="submit" value="Next"></center>

</form:form>
</body>
</html>