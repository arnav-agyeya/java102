<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.survival.entities.TrendingMain"
	import="java.util.ArrayList" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Home</title>
</head>
<body>
	<div class="global-font-style">
		<div class="container" align="center">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Hotel Name</th>
						<th>Satisfaction Rating</th>
						<th>Hotel Address</th>
						<th>Discount Offered</th>
						<th>Room Type</th>
						<th>Room Price</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<TrendingMain> list = (ArrayList) request.getAttribute("trending");
						for (TrendingMain element : list) {
					%>
					<tr>
						<td>
							<%
								out.println(element.getHotelName());
							%>
						</td>
						<td>
							<%
								out.println(element.getRating());
							%>
						</td>
						<td>
							<%
								out.println(element.getAddress());
							%>
						</td>
						<td>
							<%
								out.println(element.getDiscount());
							%>
						</td>
						<td>
							<%
								out.println(element.getRoom_type());
							%>
						</td>
						<td>
							<%
								out.println(element.getPrice());
							%>
						</td>
						<td>
							<%
								out.println(element.getLocation());
							%>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br> <br>
			<form:form action="./searchresult">
				<table class="table table-bordered">
					<tr>
						<td>Enter the city: <form:select path="city"
								placeholder="Choose City">
								<form:option value="Jaipur">Jaipur</form:option>
								<form:option value="Delhi">Delhi</form:option>
								<form:option value="Mumbai">Mumbai</form:option>
							</form:select>
						</td>
						<td>Enter Minimum Price Limit: <form:input type="number"
								path="minPrice" /></td>
						<td>Enter Maximum Price Limit: <form:input type="number"
								path="maxPrice" /></td>
					</tr>
				</table>
				<br>
				<br>
				<input type="submit" value="Search!">
			</form:form>
		</div>
	</div>
</body>
</html>