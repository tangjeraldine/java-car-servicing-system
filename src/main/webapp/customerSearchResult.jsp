<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<%
		out.println(session.getAttribute("cust_name") + "   "+ session.getAttribute("cust_username") + "   "+ session.getAttribute("cust_email") );
		%>
		<br>
		<a href="/car-service-center-mvc/viewCustomerDetails.jsp">Return to search</a>
</body>
</html>