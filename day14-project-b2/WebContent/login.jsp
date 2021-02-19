<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-css-js.jsp" %>

<body>


<div class="container-fluid">

	<div class="row bg-dark" style="height:100vh">
		
		<div class="col-6 text-light  border-right d-flex flex-column justify-content-center align-items-center" style="border-right-width: 10px !important">
			<div class="bg-light text-dark px-4 py-2 rounded" style="font-size:1.75rem; font-family:cursive">Mini Project</div>
			
			<div class="row mt-4">
				<div class="col-10 offset-1" style="text-align: center; font-size:1.5rem; font-family: cursive">
					Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA),[17] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.
				</div>
			</div>  
		</div>
		
		
		
		<div class="col-6 text-light d-flex flex-column justify-content-center align-items-center">
			<form action="login-action" method="post" class="" style="width:50%">
				
				<c:if test="${param.q == 0 }">
					<div class="alert alert-danger">
						Application Errror
					</div>
				</c:if>
				
				<div class="bg-light text-dark py-3 rounded d-flex justify-content-center" style="font-family:cursive; font-size:1.5rem; font-weight:bold">
					Application Login
				</div>
			
				<div class="mt-1">
					<input name="username" class="form-control form-control-lg" type="text" placeholder="Username..." >
				</div>
				
				<div class="mt-1">
					<input name="password" class="form-control form-control-lg" type="password" placeholder="Password...">
				</div>
				
				
				<div class="mt-1">
					<input class="btn btn-secondary btn-block" type="submit" value="Login">
				</div>
				<div class="mt-1">
					<input class="btn btn-secondary btn-block" type="button" value="Cancel">
				</div>
				
				<div class="mt-1 d-flex justify-content-center text-primary" >
					<a href="register.jsp" class="btn btn-link">Register Here...</a> 
				</div>
			</form>	
		</div>
	</div>

</div>


</body>
</html>