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
</head>
<body>
	<div class="wrapper">
		<h1>Update Ticket Form</h1>
		<form action="add" method="post">
			<table>
				<tr>
					<td>Enter Name:</td>
					<td><input type="text" name="user_name" placeholder="Name"
						required /></td>
				</tr>
				<tr>
					<td>Enter Email:</td>
					<td><input type="email" name="user_email" placeholder="Email"
						required /></td>
				</tr>
				<tr>
					<td>Select Gender:</td>
					<td><input type="radio" name="user_gender" value="male"
						required /> Male <input type="radio" name="user_gender"
						value="female" /> Female</td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><select name="user_country" required>
							<option value="USA">USA</option>
							<option value="UK">UK</option>
							<option value="UAE">UAE</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save" /></td>
				</tr>
				<tr>
					<td><a href='ServletList'>View List</a></td>
				</tr>
			</table>
		</form>
	</div>
	<br>

	<form>
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
		<fieldset class="form-group">
			<div class="row">
				<legend class="col-form-label col-sm-2 pt-0">Radios</legend>
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios1" value="option1" checked> <label
							class="form-check-label" for="gridRadios1"> First radio </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios2" value="option2"> <label
							class="form-check-label" for="gridRadios2"> Second radio
						</label>
					</div>
					<div class="form-check disabled">
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios3" value="option3" disabled> <label
							class="form-check-label" for="gridRadios3"> Third
							disabled radio </label>
					</div>
				</div>
			</div>
		</fieldset>
		<div class="form-group row">
			<div class="col-sm-2">Checkbox</div>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck1">
					<label class="form-check-label" for="gridCheck1"> Example
						checkbox </label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Sign in</button>
			</div>
		</div>
	</form>


</body>
</html>