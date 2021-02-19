<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Home Page</h1>
<div>Title :: ${title}</div>

<c:forEach var="cityItem" items="${cityList}">
	<div>${cityItem}</div>
</c:forEach>


<c:forEach var="userItem" items="${userList}">
	<div>${userItem.name } ${userItem.email}</div>
</c:forEach>

</body>
</html>