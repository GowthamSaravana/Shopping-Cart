<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib uri="/WEB-INF/codatags.tld" prefix="coda" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
		
		body{
		background-color: #e6e6e6;
		}	 
		</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

<div align="center">
<h1>Spring MVC And Hibernate Shopping Cart</h1>

 

<coda:display />
<a href="<c:url value='/generatePDF' />">Generate PDF</a>
<a href="<c:url value='/itemlistuser' />">Back to Shopping</a>

</div>



</body>
</html>