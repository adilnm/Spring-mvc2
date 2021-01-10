<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Employee information</h1><br><br>
		
		<form action="update" method="post">
			<div class="row">
				<div class="col-md-3">Employee Name</div><div class="col-md-9"><input type="text" name="empName" value="${employee.employeeName}"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Email Id</div><div class="col-md-9"><input type="text" name="emailId" value="${employee.emailId}"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" name="password" value="${employee.password}" ></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Salary</div><div class="col-md-9"><input type="text" name="salary" value="${employee.salary}"></div>
			</div>
			</br>
			<input type="hidden" value="${employee.employeeId}" name="employeeId">
			<button type="submit" class="btn btn-success">Update</button>
		</form>
	</div>
</body>
</html>