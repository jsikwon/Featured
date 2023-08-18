<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Form</title>

</head>
<body>
	<h2>${customerName}<br> Please Customize Your Pizza:</h2>
	<form:form action="addPizza" modelAttribute="newPizza">
	
	<table>
		<tr>
			<td>Pick the size:</td>
			<td><form:radiobuttons path="size" items="${sizeList}" /><br>
			</td>
		</tr>
		<tr>
			<td>Pick the toppings:</td>
			<td><form:checkboxes path="topping" items="${toppingList}" />
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add Pizza to Cart" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>