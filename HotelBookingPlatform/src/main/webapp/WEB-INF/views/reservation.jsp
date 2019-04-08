<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
	<form:form action="./reservation" modelAttribute="command"> 
Name : <form:input path="name" />
		<br></br>
Contact No. : <form:input type="number" path="phone" />
		<br></br>
Email Address : <form:input type="email"  path="email" />
		<br></br>
No. Of Rooms : <form:input path="noofrooms" />
		<br></br>
		
Room Type : <td><select name="rtypeid">
				<option value="">TYPE</option>
				<option value="1">Deluxe : AC</option>
				<option value="2">Deluxe : NON-AC</option>
				<option value="3">Premium : King</option>
				<option value="4">Premium : Queen</option>
		</select> <br></br>
		
Payment Mode : 
<td><select name="modeofpayment">
				<option value="">MODE</option>
				<option value="01">Online</option>
				<option value="02">Cash</option>
		</select> <br></br> <br></br>
		
			Check-IN Date
			<td><select name="inDay">
					<option value="">--Day--</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select> <select name="inMonth">
					<option value="">--Month--</option>
					<option value="01">Jan</option>
					<option value="02">Feb</option>
					<option value="03">Mar</option>
					<option value="04">Apr</option>
					<option value="05">May</option>
					<option value="06">Jun</option>
					<option value="07">Jul</option>
					<option value="08">Aug</option>
					<option value="09">Sep</option>
					<option value="10">Oct</option>
					<option value="11">Nov</option>
					<option value="12">Dec</option>
			</select> <select name="inYear">
					<option value="">--Year--</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
			</select>
		<br></br>
		
			<td>Check-OUT Date</td>
			<td><select name="outDay">
					<option value="">--Day--</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select> <select name="outMonth">
					<option value="">--Month--</option>
					<option value="01">Jan</option>
					<option value="02">Feb</option>
					<option value="03">Mar</option>
					<option value="04">Apr</option>
					<option value="05">May</option>
					<option value="06">Jun</option>
					<option value="07">Jul</option>
					<option value="08">Aug</option>
					<option value="09">Sep</option>
					<option value="10">Oct</option>
					<option value="11">Nov</option>
					<option value="12">Dec</option>
			</select> <select name="outYear">
					<option value="">--Year--</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
			</select>		
		<br></br>
		
		Package Details : 
<select name="dealtype">
				<option value=0>PACKAGE</option>
				<option value=1>Individual</option>
				<option value=2>Package 1</option>
				<option value=3>Package 2</option>
				
		</select> <br></br> <input type="submit" value="BOOK">
		
	</form:form>

</body>
</html>