<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
.container{

      height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

}

</style>
</head>
<body >
<div class="container container-table"  >
<div class="h-100  row align-items-center">
<div class="card">
</br>
<article class="card-body">
<a href="./registration" class="float-right btn btn-outline-primary">Sign up</a>
<h4 class="card-title mb-4 mt-1">Sign in</h4>
</br>
       <form:form action="./log">
    <div class="form-group">
       <label>Username</label>
        <form:input path="login_Id" required="reqiured" hint="Username" />
        
    </div> <!-- form-group// -->
</br>
    <div class="form-group">
       
       <label>Password</label>
        <form:password path="login_Password" required="required" hint="******" />
    </div> <!-- form-group// --> 
    </br>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
    </div> <!-- form-group// -->                                                           
</form:form>
</article>
</div> <!-- card.// -->
</div>
</div>
</body>
</html>

