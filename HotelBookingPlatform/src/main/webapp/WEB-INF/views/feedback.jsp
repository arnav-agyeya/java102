<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<% %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="./validatefeedback">
Enter Rating (1-5) : <input type="text" name="tb1"><br><br>
Enter Feedback : <textarea rows="10" cols="50" name="tb2"></textarea><br>
<br><br><br>

<input type="text" type = "hidden" name="rId" value=${reservationID}>
<input type="text" type = "hidden"name="hId" value=${hotelID}>
<center><input type="submit" value="Submit"></center><br>

</form:form>
</body>
</html>