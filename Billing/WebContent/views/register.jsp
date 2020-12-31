<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sptags" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/register.css" />">
<meta charset="ISO-8859-1">
</head>
<c:url var="addAction" value="/customer/add" ></c:url>

<body>
<div class="signup-form">
	<sptags:form class="form-horizontal" action="${addAction}" commandName="customer">
	<h2>Register</h2>
	<p class="hint-text">Create your account !</p>

	  <label  for="username">Username</label>
	
	  <div class="form-group">
			
	  <sptags:input path="uname" class="form-control" required ="true"/><br>
	  </div>
  
   
	  <label class="control-label"  for="Password">Password</label>
	
	   <div class="col-75">
		<sptags:input type= "password" path="upass" class="form-control" required="true"/><br>
		</div>
	
	
	  <label class="control-label"  for="Address">Address</label>
	  
	
		<sptags:input path="address"  class="form-control" required="true"/><br>
	
	
     
	  <label class="control-label"  for="Role" >Role</label>
	  

		<sptags:input path="role"  class="form-control" required="true"/><br>
	
	
		<div class="form-group">
		<input type="submit" value="Register"  class="btn btn-black">
		   </div>
   
 
	</sptags:form>
	<div class="text-center">Already have an account? <a href="<c:url value='/' />">Sign in</a></div>
	</div>
</body>
</html>