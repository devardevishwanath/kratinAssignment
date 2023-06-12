<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add new patient</h1>
	<h3>Hello, Dr. ${sessionScope.doc_info.docName}</h3>
	
	<spring:url value="/patient/all" var="allpatienturl" />
	<form method="post" action="/patient/addPatient">
		<table>
		<tr>
			<td>First Name:</td>
			<td>
			<input type="text" name="fname" required="required">
			</td>
		</tr>
		
		<tr>
			<td>Last Name:</td>
			<td>
			<input type="text" name="lname" required="required">
			</td>
		</tr>
		<tr>
			<td>Phone Number:</td>
			<td>
			<input type="text" name="phone" required="required">
			</td>
		</tr>
		
		<tr>
			<td>
			<input type="submit" value="Add Patient">
			</td>
			<td>
			<a href="${allpatienturl}">Cancel</a>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>