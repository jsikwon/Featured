<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2>Monthly Amortization Schedule</h2>
	<p><strong>Monthly Payment:</strong> <fmt:formatNumber type="number" 
			pattern="###.##" value="${mortgage.monthlyPayment}" /></p>
	<table class="table table-bordered table-hover table-sm" style="width: 75%">
	<tr>
	<th>Payment No.</th>
	<th>Principal Paid</th>
	<th>Interest Paid</th>
	<th>Outstanding Balance</th>
	</tr>
	<c:forEach var = "eachPayment" items ="${mortgage.paymentList}">
	<tr>
		<td>${eachPayment.monthNo}</td>
		<td><fmt:formatNumber type="number" pattern="###.##" value="${eachPayment.principalPaid}" /></td>
		<td><fmt:formatNumber type="number" pattern="###.##" value="${eachPayment.interestPaid}" /></td>
		<td><fmt:formatNumber type="number" pattern="###.##" value="${eachPayment.outstanding}" /></td>
	</tr>
	</c:forEach>
	</table>


</body>
</html>