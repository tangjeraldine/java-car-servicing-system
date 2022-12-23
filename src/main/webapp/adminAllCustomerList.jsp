<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<%@ page import = "java.util.*" %>
<%@ page import = "com.accenture.model.*" %>
	<%
	ArrayList<CustomerDetail> al = (ArrayList<CustomerDetail>)session.getAttribute("al");
	for (CustomerDetail x:al) {
		out.println(x);
	}
	%>
</body>
</html>