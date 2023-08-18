<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
 	<a href=${pageContext.request.contextPath}/customer/list>Go to Pizza Order System</a>
	<br><br>
	<a href=${pageContext.request.contextPath}/api/customers>Get All Customers</a>
	<br><br>
	<a href=${pageContext.request.contextPath}/api/orders>Get All Orders</a>
</body>
</html>