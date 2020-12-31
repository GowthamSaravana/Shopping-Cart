<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sptags" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/cartd.css" />">
<title>Cart</title>
</head>
</body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav"><h2>WELCOME USER</h2></ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value='/logout' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
       </div>
  </div>
</nav>
<div class="container -sm border">
<c:url var="shoppingAction"  value="/shopping" ></c:url>

 <div class="basket-labels">
        <ul>
          <li class="item item-heading">Item Desc</li>
          <li class="price">Price</li>
          <li class="quantity">Quantity</li>
        </ul>
      </div>
	<sptags:form action="${shoppingAction}" modelAttribute="cart">
  
	<c:forEach items="${items}" var="item">
	 
			<sptags:input path="itemno" value="${item.itemno}" type="hidden"/>
			<div class="basket-product">
	   		  <div class="item">
			   <div class="product-image">
			     <img src="<c:url value='/imageDisplay?id=${item.itemno}' />">
			</div>
			<div class="product-details">
			<strong> ${item.itemdesc}</strong>
			</div>
			</div>
			 <div class="price">
			${item.unit}.${item.price}
			</div>
		 	<div class="quantity">	
			<sptags:input path="quantity" class="quantity-field" type="number" value="0"  min="0" required="true"/>
			</div>
			</div>
	</c:forEach>

     <div class="center">  
	<input type="submit"  class="btn btn-black" value="submit">
	</div>
	</sptags:form>
		</div>
		

</body>
</html>