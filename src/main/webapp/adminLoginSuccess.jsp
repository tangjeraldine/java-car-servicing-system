<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome, Admin!</title>
</head>
<body>
	<h1>
		<%
		out.println("Dear " + session.getAttribute("admin_username") + ", you are now logged in.");
		%>
	</h1>
	<h3>Select service below to begin:</h3>
	<ol>
	<li><a href="/car-service-center-mvc/viewCustomerDetails.jsp">View customer details</a></li>
	<li><a href="/car-service-center-mvc/viewServiceRequests.jsp">View service requests</a></li>
	<li><a href="/car-service-center-mvc/updateStatus.jsp">Update Status</a></li>
	</ol>
</body>
</html>