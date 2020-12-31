<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sptags" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register Item</title>
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
<body>
<c:url var="addAction" value="/item/add" ></c:url>

<body>
<div class="signup-form">
	<sptags:form class="form-horizontal" action="${addAction}" commandName="item" enctype="multipart/form-data">
	<h2>Add Item</h2>
	 	<div class="form-group">
	 	<sptags:input type="hidden" path="itemno" id="id"/>
	 	</div>
		ItemDescription:
		<div class="form-group">
		<sptags:input path="itemdesc" class="form-control" required="true"/><br>
		</div>
		Category:
		<div class="form-group">
		<sptags:input path="category" class="form-control" required="true"/><br>
		</div>
		Price :
		<div class="form-group">
		<sptags:input path="price" class="form-control" required="true"/><br>
		</div>
		Unit :
		<div class="form-group">	
		<sptags:input path="unit" class="form-control" required="true"/><br>
		</div>
		Image:
		<div class="form-group">
		<input type="file" name="photo">
		 </div>
		<div class="form-group">
		 <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-black"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-black"/>
                        </c:otherwise>
                    </c:choose>
                    </div>
	</sptags:form>
	<div class="text-center"><a href="<c:url value='/itemlist' />">Return to Welcome page</a></div>
	</div>
</body>
</html>