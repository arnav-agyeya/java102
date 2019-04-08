<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.survival.entities.SearchResultMain"	import="java.util.ArrayList" isELIgnored="false" import="java.util.ArrayList" isELIgnored="false"%>
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
<title>Sorting Results</title>
</head>
<body>
	<div class="global-font-style">
		<div class="container" align="center">
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<th>Hotel Name</th>
					<th>Satisfaction Rating</th>
					<th>Hotel Address</th>
					<th>Discount Offered</th>
					<th>Room Type</th>
					<th>Room Price</th>
				</tr>
				<%
					ArrayList<SearchResultMain> list = (ArrayList) request.getAttribute("resultSetSort");
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