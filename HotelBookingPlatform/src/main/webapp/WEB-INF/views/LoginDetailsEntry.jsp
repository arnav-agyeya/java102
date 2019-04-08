<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
 
  
</head>
<body>
<div class="container">
<h1>User Registration Form</h1>
<form:form action="./userRegistration" >
			<table class="table table-bordered">
			<tbody>
				<tr>
					<td>Name: </td>
					<td><form:input maxlength="50" path="user_Name" required="required" /></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input type="email" maxlength="35" path="email_Id" required="required" /></td>
				</tr>
				<tr>
					<td>Phone Number: </td>
					<td><form:input type="number" maxlength="10" path="phone_Number" required="required" /></td>
				</tr>
					<tr>
					<td>Address: </td>
					<td><form:input maxlength="100" path="user_Address" required="required" /></td>
				</tr>
				<tr>
					<td>Role: </td>
					<!--  
					<select>
						<option name="ind">Individual</option>
						<option name="cor">Corporate</option>
						<option name="emp">Employee</option>
					</select>
					-->  
					<td><form:input maxlength="3" path="login_Role" required="required" /></td>
				</tr>
				<tr>
					<td>UserName: </td>
					<td><form:input maxlength="20" path="login_Id" required="required" /></td>
				</tr>
					<tr>
					<td>Password: </td>
					<td><form:password maxlength="16" path="login_Password" required="required" /></td>
				</tr>
				</tbody></table>
			<input type="submit" value="Submit" /></form:form>
			</div>
</body>
</html>