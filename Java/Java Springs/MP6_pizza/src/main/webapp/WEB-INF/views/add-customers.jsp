<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Info</title>
</head>
<body>
	<b>Please enter customer info:</b>

	<form:form action="processCustomer" modelAttribute="customer"
		method="post">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:select path="state">
						<form:options items="${stateList}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><form:input path="zip" /></td>
			</tr>			
			<tr>
				<td></td>
				<td><input type="submit" value="Save Customer" /></td>
				</tr>				
		</table>
		<a href=${pageContext.request.contextPath}/customer/list>Back to Customer List</a>

	</form:form>
</body>
</html>