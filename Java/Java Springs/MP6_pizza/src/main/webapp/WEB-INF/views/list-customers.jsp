<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	
	<h2>Customer List</h2>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
		</tr>
		
		<c:forEach var="eachCustomer" items="${customers}">
		
		<tr>
			<td>${eachCustomer.firstName}</td>
			<td>${eachCustomer.lastName}</td>
			<td>${eachCustomer.street}</td>
			<td>${eachCustomer.city}</td>
			<td>${eachCustomer.state}</td>
			<td>${eachCustomer.zip}</td>
			
			<td><form:form action="updateCustomer" method="post">
					<input type="hidden" name="customerId" value="${eachCustomer.id}" />
					<input type="submit" value="Update Customer Info" />
				</form:form></td>
			<td><form:form action="orderHistory" method="post">
					<input type="hidden" name="customerId" value="${eachCustomer.id}" />
					<input type="submit" value="Order History" />
				</form:form></td>
			<td><form:form action="orderPizza" modelAttribute="newPizza" method="post">
					<input type="hidden" name="customerId" value="${eachCustomer.id}" />
					<input type="submit" value="Order Pizza" />
				</form:form></td>
			<td><form:form action="deleteCustomer" method="post">
					<input type="hidden" name="customerId" value="${eachCustomer.id}" />
					<input type="submit" value="Delete Customer" />
				</form:form></td>	
		</tr>
		</c:forEach>		
	</table>
	<form action="addCustomer" method="post">
		<input type="submit" value="Add New Customer" />
	</form>
</body>
</html>