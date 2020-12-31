<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sptags" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/nav.css" />">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<br/>


<c:url var="generateAction" value="/generatedate" ></c:url>
<c:url var="generatesingleAction" value="/generatesingledate" ></c:url>
<br/>
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
      <ul class="nav navbar-nav">
<li><a href="<button type="button" class="btn btn-black" data-toggle="modal" data-target="#myModal">Generate Between</a></li>
<li><a href="<button type="button" class="btn btn-black" data-toggle="modal" data-target="#myModal1">Generate Specific Records</a></li>
<li><a href="<button type="button" class="btn btn-black" data-toggle="modal" data-target="#myModal2">Generate All Record</a></li>
<li><a href="<button type="button" class="btn btn-black" data-toggle="modal" data-target="#myModal3">Add Item</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value='/logout' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
       </div>
  </div>
</nav>
  
<div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Generate Between</h4>
        </div>
        <div class="modal-body">
         <a href="<c:url value='/item/add' />">Add New Item</a>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Generate Between</h4>
        </div>
        <div class="modal-body">
          <sptags:form action="${generateAction}" commandName="date">
						Start Date : <sptags:input type="date" path="invoicestart" required="true"/><br/>
						<br/>
						End Date : <sptags:input type="date" path="invoiceend" required="true" /><br/>
						<br/>
						<input type="submit" value="Generate" class="btn btn-black">
						</sptags:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Generate Specific Records</h4>
        </div>
        <div class="modal-body">
          <sptags:form action="${generatesingleAction}" commandName="singledate">
						Date : <sptags:input type="date" path="datevalue" required="true"/><br>
						<br/>
						<input type="submit" value="Generate" class="btn btn-black">

					</sptags:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Generate All</h4>
        </div>
        <div class="modal-body">
        <a href="<c:url value='/generateall' />">Generate Invoice Report</a>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
<div class="bs-example">
	<table class="table table-hover">
	<thead>
	<tr>
		<th width="120">Item Name</th>
		<th width="120">Category</th>
		<th width="120">Price</th>
		<th width="120">Unit</th>
		<th width="60">Image</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${items}" var="item">
		<tr>
			<td>${item.itemdesc}</td>
			<td>${item.category}</td>
			<td>${item.price}</td>
			<td>${item.unit}</td>
			<td><img src="<c:url value='/imageDisplay?id=${item.itemno}' />" width="100" height="100"></td>
			<td><a href="<c:url value='/edit/${item.itemno}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${item.itemno}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>