<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
<form action="/car-service-center-mvc/viewAllCustomers">
<button type="submit">View All Customers</button>
</form>
<form action="/car-service-center-mvc/searchCustomer">
<input type="text" name="customerSearch">
<button type="submit">Search Customer</button>
</form>
</body>
</html>