<%@page import="com.survival.entities.BookingDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
</head>
<body>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<BookingDetails> arrList=new ArrayList<BookingDetails>();  
arrList=(ArrayList<BookingDetails>)request.getAttribute("BookingDetailsList");
if(arrList==null) 
System.out.println("No record found");
else
for(BookingDetails book:arrList) 
{ %>
<table style="width:100%">
  <tr>
    <th>Name</th>
    <th>Phone No</th> 
    <th>Email</th>
    <th>No Of Rooms</th>
    <th>CheckIn Date</th>
    <th>Checkout Date</th>
    <th>Hotel Name</th>
    <th>Package Name</th>
    <th>Cancel</th>
    <th>Checkout</th>
  </tr>
  <tr>
    <td><% out.println(book.getName()); %>
    <br>
    
		  <form name="f2" action="./update_Name" >
                  <input id="edit" type="submit" name="edit1" value="Edit" />
            
         </form>
    </td>
    <td><%out.println(book.getPhone_no()); %>
    <br>
		  <form name="f2" action="./update_Phone" >
                  <input id="edit" type="submit" name="edit2" value="Edit" />
                  </form>
    </td> 
    <td><%out.println(book.getEmail()); %>
     <br>
		  <form name="f2" action="./update_Email" >
                  <input id="edit" type="submit" name="edit3" value="Edit" />
          </form>
     </td> 
    <td><%out.println(book.getNo_of_rooms()); %></td>
    <td><%out.println(book.getCheck_in()); %></td>
    <td><%out.println(book.getCheck_out()); %></td>	
    <td><%out.println(book.getHotel_name()); %></td>	
    <td><%out.println(book.getPackage_name()); %></td>		
    <td><br>
		  <form name="f2" action="javascript:select();" >
                  <input id="edit" type="submit" name="Cancel" value="Cancel" />
          </form>
    </td>
     <td><br>
		
        <a href="./cout3?rid=<%= book.getReservation_id() %>&name=<%= book.getName() %>"><input id="edit" type="submit"  value="Checkout" /></a> 
          
    </td>
          
  </tr>
</table>
<%} %>


</body>
</html>