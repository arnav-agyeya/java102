<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Booking</title>
<h1>Cancel Page</h1>
</head>
<body>
 <form action="./cancel?uid=${userid}" method="post">
Enter Reservation Id : <input type="text" name="reservationId"><br>
<input type="submit" value="Submit" name="operation">
</form>
</body>
</html>