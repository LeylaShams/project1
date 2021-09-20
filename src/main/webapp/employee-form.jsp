<html>
<head>
<meta charset="UTF-8">
<title>Expense Reimbursement System</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<script type="text/javascript" language="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
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
					<a class="nav-link" href="employee-list.jsp">Employee List</a>
					<a class="nav-link" href="employee-form.jsp">Add Employee</a>
					<a class="nav-link" href="ticketList.jsp">Ticket List</a>
					<a class="nav-link" href="addTicket.jsp">Add Ticket</a> 
				</div>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" style="text-align: center;">
				<h2 style="padding: 15px">Expense Reimbursement System</h2>
				<form
					action='http://localhost:8080/project12/EmployeeServlet?action=add'
					method='post'>
					<table>
						<tr>
							<th>Employee Name:</th>
							<td><input class="form-control" type="text" name="name"
								size="45" required /></td>
						</tr>
						<tr>
							<th>Employee Email:</th>
							<td><input class="form-control" type="email" name="email"
								size="45" required /></td>
						</tr>
						<tr>
							<th>Username:</th>
							<td><input class="form-control" type="text" name="username"
								size="15" required /></td>
						</tr>
						<tr>
							<th>Password:</th>
							<td><input class="form-control" type="number"
								name="password" size="15" required /></td>
						</tr>
						<tr>
							<th>Type</th>
							<td><input type="radio" id="emp" name="type"
								value="Employee"> <label for="emp">Employee</label> <input
								type="radio" id="manager" name="type" value="Finance manager" required>
								<label for="manager">Finance manager</label></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Save" /></td>
						</tr>
					</table>
				</form>


			</div>

			<div class="col-md-3"></div>
		</div>
	</div>


</body>
</html>