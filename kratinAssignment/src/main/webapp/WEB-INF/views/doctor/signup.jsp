<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Sign Up</h1>
	<form method="post" action="/doctor/signup">
		<table>
		<tr>
			<td>Enter Your Name:</td>
			<td>
			<input type="text" name="name" required="required">
			</td>
		</tr>
		
		<tr>
			<td>User Name:</td>
			<td>
			<input type="text" name="uname" required="required">
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
			<input type="text" name="pwd" required="required">
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" value="Sign Up">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>