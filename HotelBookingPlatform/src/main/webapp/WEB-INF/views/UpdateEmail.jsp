<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="from" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<from:form action="./updateEmail">
Enter Name    : <input type="text" name="name">
Enter Phone Number    : <input type="text" name="phone">
Enter New Email     : <input type="text" name="newEmail">
<br>
<input type="submit" value="Update">
</from:form>
</body>
</html>