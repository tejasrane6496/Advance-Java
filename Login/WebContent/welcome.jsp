<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		// below three lines for how to prevent the user to display previous page after log out
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Progma", "no-cache");//if using Http 1.0
	response.setHeader("Expires", "0");//if using Proxies

	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	Welcome....

	<form action="Logout">
		<input type="submit" value="Logout">

	</form>
</body>
</html>