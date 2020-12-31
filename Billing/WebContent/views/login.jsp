<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sptags" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/mystyle.css" />">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Welcome to Shopping Mart!!<br> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
<div class="login-form">
<c:url var="loginAction"  value="/login" ></c:url>
<sptags:form action="${loginAction}" modelAttribute="loginform">
  <div class="form-group">
		UserName:<sptags:input path="username" type="text" required="true"/><br>
		</div>
		  <div class="form-group">
		PassWord:<sptags:input path="password" type="password" required="true"/><br>
		</div>
		<input type="submit" value="Login" class="btn btn-black" >
	</sptags:form>
<a href="<c:url value='/customer/add' />">Register New User</a>
  </div>
         </div>
      </div>
</body>
</html>