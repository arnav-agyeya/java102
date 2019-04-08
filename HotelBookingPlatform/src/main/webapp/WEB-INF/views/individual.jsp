<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<table class="table table-bordered">
<tbody>
<tr>
${userid}
<th><a href="./searchinput?uid=${userid}"><input type="submit" value="Plan your trip"></a></th>
<th><a href="./activeBookings?uid=${userid}"><input type="submit" value="My Active Bookings"></a></th>
<th><a href="./inactiveBookings?uid=${userid}"><input type="submit" value="My Previous Bookings"></a></th>
</tr>
</tbody>
</table>
<a href="./ContactUs">Contact Us</a>
</body>
</html>