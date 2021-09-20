<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ticket</title>

<link rel="stylesheet" href="styles.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style>
	h1 {
		text-align: center;
		padding: 25px;
	}
</style>
<script>
	//TODO: Show different alert if add fails
	function submitForm(elm, item) {
		$('#myForm')
		.ajax({
			url: "http://localhost:8080/project1/AddTicketServlet?action=addTicket&user_id=" + item,
			success: alert("Ticket added!")
		});
	}
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

 	<form id="myForm" class="form-signin" action="addTicket" method="post" target="_top">
	<!-- 		<img class="mb-4" src="img/ticket.jpg" alt="ticket image" width="200"
			height="150"> -->
		<h1>Submit Ticket</h1>
		
		<input type="number" name="reimbursement_amount" class="form-control"
			placeholder="Reimbursement amount" min="0.01" step="0.01" required
			autofocus="">
		<textarea name="ticket_description" class="form-control scroll"
			placeholder="Description" style="height: 100px" required></textarea>

		<fieldset class="form-group" style="text-align: left">
			<div class="row">
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ticket_type"
							id="gridRadios1" value="lodging" checked> <label
							class="form-check-label" for="gridRadios1"> Lodging </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ticket_type"
							id="gridRadios2" value="travel"> <label
							class="form-check-label" for="gridRadios2"> Travel </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ticket_type"
							id="gridRadios2" value="food"> <label
							class="form-check-label" for="gridRadios2"> Food </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ticket_type"
							id="gridRadios2" value="other"> <label
							class="form-check-label" for="gridRadios2"> Other </label>
					</div>
				</div>
			</div>
		</fieldset>

		<!-- TODO: replace placeholder number with userId -->
		<button onclick="submitForm($(this),' + 2 + ')" id="submitButton" class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
		
		<p class="mt-5 mb-3 text-muted">© 2021 - All time</p>

	</form>
</body>
</html>
