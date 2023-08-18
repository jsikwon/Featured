<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	<h2>Customer Info:</h2>
	Customer Name: ${order.customer.name}<br>
	Street: ${order.customer.address.street}<br>
	City: ${order.customer.address.city}<br>
	State: ${order.customer.address.state}<br>
	Zipcode: ${order.customer.address.zip}<br>
	<h2>Pizza Order:</h2>
	<br> Size: ${order.pizza.size}
	<c:forEach var="eachTopping" items="${order.pizza.toppings}">
				${eachTopping}&emsp;
		</c:forEach>
	
</body>
</html>