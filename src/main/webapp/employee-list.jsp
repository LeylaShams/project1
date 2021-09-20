<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Reimbursement System</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style>
	th, td {
		border: 1px solid black;
	}
</style>
<script type="text/javascript" language="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

function deleteRow(elm, item){
	if (!confirm('Are you sure?')){
		return;	
}
	
	$.ajax(
			{		
				url:'http://localhost:8080/project12/EmployeeServlet?action=delete&id='+item,
				success: function(result){
					$("tr.row-"+item).remove();
					}});}


/* $(document).ready(function() {	
	$.ajax(
			{
				url:"http://localhost:8080/project1/EmployeeServlet?action=update",
				success:function(result){
					
	
}});} */

$(document).ready(function() {
	$.ajax(
			{url: "http://localhost:8080/project12/EmployeeServlet?action=getall", 
				success: function(result){
					console.log(result)
					var tr ='';
					$.each(result,function(i,item){
						console.log(item.name);
						tr ='';
 						tr += '<tr class="row-'+item.id+'"><td>' + item.id + '</td>';
						tr += '<td>' + item.name + '</td>';
						tr += '<td>' + item.email + '</td>';
						tr += '<td>' + '<a href="ticketList.jsp">Tickets table</a>' + '</td>'
						tr += '<td>' + '<a href="#" onclick="deleteRow($(this),'+item.id+')">Delete |</a>&nbsp<a href="employee-form.jsp">Edit</a>' + '</td></tr>'; 
  
						$('#employee').append(tr); 
					}); 
				}
			});});

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
	
	<div align="center">
		<h1>Expense Reimbursement System</h1>
		<h2 style="padding: 15px">
			List of All Employees
		</h2>
		<table id="employee" border="1"
			cellpadding="5" style="width: 75%">
			<tr style="background-color: black; color: white;">
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Tickets Info</th>
				<th>Action</th>
			</tr>
		</table>
	</div>

</body>
</html>