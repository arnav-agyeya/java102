<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.survival.entities.SearchResultMain"
	import="java.util.ArrayList" isELIgnored="false"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th, td {
	text-align: center;
	vertical-align: middle;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<div class="global-font-style">
		<div class="container" align="center">
			<table class="table table-bordered">
				<tr>
					<th>Hotel Name</th>
					<th>Satisfaction Rating</th>
					<th>Hotel Address</th>
					<th>Discount Offered</th>
					<th>Room Type</th>
					<th>Room Price</th>
				</tr>
				<%
					ArrayList<SearchResultMain> list = (ArrayList) request.getAttribute("resultSetLocation");
					for (SearchResultMain element : list) {
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
				</tr>
				<%
					}
				%>
			</table>
			<div class="container">
				<h3>Filter Categories:-</h3>
				<br>
			</div>
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<th><a href="./filterpricelowhigh">Prices Low to High</a> | <a
						href="./filterpricehighlow">Prices High to Low</a></th>
				</tr>
				<tr>
					<th><form action="./filterbyrating">
							Satisfaction Rating (Left to Right -> 1 to 5 in increments of 1):<br>
							<br> <input type="range" name="filter" min="1" max="5"
								step="1"><br> <input type="submit" value="Filter">
						</form></th>
				</tr>
			</table>

			<div class="container">
				<h3>Sorting Categories:-</h3>
				<br>
			</div>
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<td><a href="./sorthotellowhigh">Hotel Name A to Z</a></td>
					<td><a href="./sortpricelowhigh">Prices Low to High</a></td>
					<td><a href="./sortbydiscount">Discount High to Low</a><br></td>
				</tr>
				<tr>
					<td><a href="./sorthotelhighlow">Hotel Name Z to A</a></td>
					<td><a href="./sortpricehighlow">Prices High to Low</a></td>

					<td><a href="./sortbyrating">Ratings High to Low</a></td>

				</tr>
			</table>
			<div class="container">
				<table style="width: 100%" class="table table-bordered">
					<tr>
						<td><a href="./viewallpackages">View Holiday Packages for
								selected City</a></td>
						<td><a href="./viewhotelpackage">View Hotel Packages for
								selected City</a></td>
					</tr>
				</table>
				<form action="./booking">
					<table class="table table-bordered">
						<tr>
							<th>Enter Hotel Name to Book : <input type="text"
								name="hotelbook"> <input type="submit" value="Book!"></th>
						</tr>
					</table>
				</form>
			</div>
		</div>
</body>
</html>
