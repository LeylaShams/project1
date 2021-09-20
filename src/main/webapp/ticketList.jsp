<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket List</title>

<link rel="stylesheet" href="styles.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style>
th, td {
	border: 1px solid black;
}

h1 {
	text-align: center;
	margin: 25px;
}

#filterInput {
	width: 75%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}
</style>
<script type="text/javascript" language="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$.ajax(
				{url: "http://localhost:8080/project12/ListTicketsServlet?action=getTickets", 
					success: function(result){
						var tr ='';
						$.each(result,function(i,item){
							tr ='';
	 						tr += '<tr class="row-' + item.id + '"><td>' + item.id + '</td>';
							tr += '<td>' + item.employeeId.id + '</td>';
							tr += '<td>' + item.type + '</td>';
							tr += '<td>' + item.reimbursementAmount + '</td>';
							tr += '<td>' + item.status + '</td>';
							tr += '<td>' + item.description + '</td>';
							tr += '<td>' + item.timestamp + '</td>';
							
							//tr += '<td>' + 'Update Status' + '</td></tr>'
							tr += '<td>' + '<a href="#" onclick="updateTicket($(this),' + item.id + ')">Update</a>'; // &nbsp<a href="updateTicket.jsp">Update</a>' + '</td></tr>'; 
	  						//tr += '<td>' + '<a href="#" onclick="deleteRow($(this),'+item.id+')">Delete</a></td>';
							tr += '</tr>';
	  						$('#tickets').append(tr); 
						});
					}
				});
		});
		
	// not implemented
	function sortTable() {
		var table, rows, switching, i, x, y, shouldSwitch;
		  table = document.getElementById("tickets");
		  switching = true;
		  
		  while (switching) {
			 switching = false;
			 rows = table.rows;
			 
			 for (i = 1; i < (rows.length - 1); i++) {
				 shouldSwitch = false;
				 
				  
			      x = rows[i].getElementsByTagName("TD")[0];
			      y = rows[i + 1].getElementsByTagName("TD")[0];
			      
			      if (x > y) {
			    	  shouldSwitch = true;
			    	  break;
			      }
			 }
			 if (shouldSwitch) {
			     rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			      switching = true;
			 }
		  }
	}
	
	function updateTicket(elm, item){
		let newStatus = prompt("Please enter a status (pending/accpted/rejected):", "pending");
		let result;
		newStatus.toLowerCase().trim();
		
		if (newStatus === "pending" || newStatus === "accepted" || newStatus === "rejected") {
				$.ajax(
						{
							url: "http://localhost:8080/project12/UpdateTicketServlet?action=updateTicket&id=" 
									+ item + "&ticket_status=" + newStatus,
							success: function(result){
								alert("Status changed successfully!");
								location.reload();
								}
						}
					);
		} else {
			alert("Please enter a valid status");	
		}
	}


	function filterTable() {
		var input, filter, table, tr, td, i, txtValue;
		input = document.getElementById("filterInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("tickets");
		tr = table.getElementsByTagName("tr");

		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[4];
			if (td) {
				txtValue = td.textContent || td.innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
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

	<div class="container">
		<h1>List of All Tickets</h1>
	</div>

	<div class="table_list" align="center">
		<table id="tickets" class="table" border="1"
			cellpadding="5" style="width: 75%">
					<input type="text" id="filterInput" onkeyup="filterTable()" placeholder="Filter by status">
			
			<thead class="thead-dark">
				<tr style="background-color: black; color: white;">
					<th scope="col"><span>ID</span></th>
					<!-- onclick='sortTable();' -->
					<th scope="col">User ID</th>
					<th scope="col">Type</th>
					<th scope="col">Amount</th>
					<th scope="col">Status</th>
					<th scope="col">Description</th>
					<th scope="col">Date Created</th>
					<th scope="col">Update Status</th>
				</tr>
			</thead>

		</table>
	</div>
</body>
</html>