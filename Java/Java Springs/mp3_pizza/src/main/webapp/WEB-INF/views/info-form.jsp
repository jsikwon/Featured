<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Form</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css">
</head>
<body>
	<div class="form-style-1">
	<form:form action="processForm" modelAttribute="order">
		<form:label path="customer.name">Customer Name:<span class="required">*</span>
		</form:label>
		<form:input path="customer.name" />
		<form:errors path="customer.name" cssClass="required" />
		<br>
		<form:label path="customer.address.street">Street:
		</form:label>
		<form:input path="customer.address.street" />
		<form:errors path="customer.address.street" cssClass="error" />
		<br>
		<form:label path="customer.address.city">City:
		</form:label>
		<form:input path="customer.address.city" />
		<form:errors path="customer.address.city" cssClass="error" />
		<br>
		<form:label path="customer.address.state">State:</form:label>
		<form:select path="customer.address.state">
			<form:options items="${stateList}" />
		</form:select>
		<br>
		<form:label path="customer.address.zip">Zipcode:
		</form:label>
		<form:input path="customer.address.zip" />
		<form:errors path="customer.address.zip" cssClass="error" />
		<br>
			</div>
			<table>
				<tr>
					<td>Pick the size:</td>
					<td><form:radiobuttons path="pizza.size" items="${sizeList}" />
						<br></td>
				</tr>
				<tr>
					<td>Pick the toppings:</td>
					<td><form:checkboxes path="pizza.toppings" items="${toppingList}" /></td>
				</tr>
			</table>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>