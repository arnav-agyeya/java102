<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Package Details</h1>
<form:form action="./AddPackageResult" method="post">
		Add Package Id:<br><form:input path="pid"/><br>
		Add Package Name:<br><form:input path="pname"/><br>
		Add Hotel Id:<br><form:input path="hid"/><br>
		Add Price:<br><form:input path="price"/><br>
		Add Description:<br><form:input path="description"/><br>
		Add Package Type:<br><form:input path="packagetype"/><br>
		Add City:<br><form:input path="city"/><br>
		Add No. of Days:<br><form:input path="noofdays"/><br>
		Add Room Type ID:<br><form:input path="rtypeid"/><br>
		
<input type="submit" name= "operations" value="Submit">
	</form:form>
</body>
</html>