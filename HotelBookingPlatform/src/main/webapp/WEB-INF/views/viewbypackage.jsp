<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"
	import="com.survival.entities.Package"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Packages</title>
</head>
<body>
	<div class="global-font-style">
		<div class="container" align="center">
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<th>Package ID</th>
					<th>Package Name</th>
					<th>Hotel ID</th>
					<th>Price</th>
					<th>Description</th>
					<th>Package Type</th>
					<th>City</th>
					<th>Holiday Duration</th>
					<th>Room Type ID</th>
				</tr>
				<%
						ResultSet rs = (ResultSet) request.getAttribute("package");
						ArrayList<Package> ls = new ArrayList<Package>();
						while (rs.next()) {
							Package p = new Package();
							p.setPid(rs.getInt("pid"));
							p.setPname(rs.getString("pname"));
							p.setHid(rs.getInt("hid"));
							p.setPrice(rs.getInt("price"));
							p.setDescription(rs.getString("description"));
							p.setPackagetype(rs.getInt("packagetype"));
							p.setCity(rs.getString("city"));
							p.setNoofdays(rs.getInt("noofdays"));
							p.setRtypeid(rs.getInt("rtypeid"));

							ls.add(p);
						}

						for (Package element : ls) {
							out.print("<tr>");
							out.println("<td>" + element.getPid() + "</td>");
							out.println("<td>" + element.getPname() + "</td>");
							out.println("<td>" + element.getHid() + "</td>");
							out.println("<td>" + element.getPrice() + "</td>");
							out.println("<td>" + element.getDescription() + "</td>");
							out.println("<td>" + element.getPackagetype() + "</td>");
							out.println("<td>" + element.getCity() + "</td>");
							out.println("<td>" + element.getNoofdays() + "</td>");
							out.println("<td>" + element.getRtypeid() + "</td>");
							out.print("</tr>");
						}
					%>
			</table>
			<form action="./packagebooking">
				<table class="table table-bordered">
					<tr>
						<th>Enter Package Name to Book : <input type="text"
							name="packagebook"> <input type="submit" value="Book!"></th>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>