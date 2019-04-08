<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel</title>
</head>
<body>
You are going to Cancel this Booking.<br>
Please Note that you will be charged ${cancelValue}% of Bill Amount<br><br><br>
<a href="./activeBookings?uid=${userid}">Back</a>           <a href="./confirmcancel?uid=${userid}">Confirm</a>
</body>
</html>