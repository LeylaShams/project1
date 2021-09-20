<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<script>
/*
function validateLogin(elm, item){
	$.ajax(
			{		
				url: "http://localhost:8080/project1/LoginServlet?action=login",
				success: function(result){
					//TODO: pass id in url?
					}});}
					*/
</script>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="login.jsp">Login Page</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link disabled" href="employee-list.jsp">Employee List</a>
					<a class="nav-link disabled" href="employee-form.jsp">Add Employee</a>
					<a class="nav-link disabled" href="ticketList.jsp">Ticket List</a>
					<a class="nav-link disabled" href="addTicket.jsp">Add Ticket</a> 
				</div>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" style="text-align: left;">
				<h2 style="padding: 15px">Expense Reimbursement System</h2>
				<form
					action="http://localhost:8080/project1/LoginServlet?action=login"
					method="get">
					<table>
						<tr>
							<th>User ID:</th>
							<td><input class="form-control" type="number"
								name="id" size="15" required /></td>
						</tr>
						<tr>
							<th>Username:</th>
							<td><input class="form-control" type="text" name="username"
								size="45" required /></td>
						</tr>
						<tr>
							<th>Password:</th>
							<td><input class="form-control" type="number"
								name="password" size="15" required /></td>
						</tr>
	
						<tr>
							<td colspan="2" align="center"><input style="margin-top: 15px" type="submit"
								value="Submit" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>