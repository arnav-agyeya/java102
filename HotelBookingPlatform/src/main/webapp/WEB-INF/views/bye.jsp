<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Please tell us how we can improve.
<p></p>
<form:form action= "./cal">
<center>
Please enter feedback:<textarea rows="10" cols="40" name="tb1"></textarea>
<input type="submit" value="SubmittFeedback">
</center>
</form:form>
</body>
</html>