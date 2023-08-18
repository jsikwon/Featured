<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<form:form action="processForm" modelAttribute="mortgage">
		<table>
			<tr>
				<td>Principal:</td>
				<td><form:input path="principal" /></td>
			</tr>
			<tr>
				<td>Down Payment:</td>
				<td><form:input path="downPayment" /></td>
			</tr>
			<tr>
				<td>Interest:</td>
				<td><form:input path="interestRate" /></td>
			</tr>
			<tr>
				<td>Loan Term:</td>
				<td><form:input path="loanTerm" /></td>
			</tr>
			
			<tr>
				<td />
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		</form:form>
</body>
</html>