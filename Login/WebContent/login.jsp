<%@page import="com.login.Message"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		
			<div
				class="col-12 bg-dark bg-gradient text-light d-flex justify-content-center align-items-center"
				style="height: 100vh">
				
				<form action="Login" method="post" class="mb-3 col-3">
				<h1>Login</h1><br>
				
				 <%
                                Message m = (Message) session.getAttribute("msg");
                                if (m != null) {
                            %>
                            <div class="alert <%= m.getCssClass() %>" role="alert">
                                <%= m.getContent() %>
                            </div> 


                            <%        
                                    session.removeAttribute("msg");
                                }
                            %>
				
				
				
					<div class="mb-3 col-12">
						<label class="form-label">Username:</label>
						<input type="text" class="form-control"
							placeholder="Enter Username" aria-describedby="emailHelp"
							name="uname">

						<div class="mb-3">
							<label class="form-label">Password:</label>
							<input type="password" class="form-control"
								placeholder="Enter Password" name="pass">
						</div>
						<div class="mb-3">
							<button type="submit" class="btn btn-primary"
								value="login">Login</button>
						</div>
				</form>


			</div>
		</div>
	</div>
</body>
</html>