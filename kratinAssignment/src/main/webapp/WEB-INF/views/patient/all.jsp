<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patients</title>
</head>
<body>
	<h1>${requestScope.mesg}</h1>
	<h3>Your patients</h3>
	
	<spring:url var="addPatUrl" value="/patient/addPatient" />
	<spring:url var="showPresUrl" value="/prescription/show" />
	<spring:url var="addPresUrl" value="/prescription/add" />
	
	<a href="${addPatUrl}">Add patient</a>
	
	<c:choose>
    	<c:when test="${requestScope.patients.isEmpty()}">
		<h3>Please add some patients.</h3>		
    </c:when>
    <c:otherwise>
	<ul>
		<c:forEach var="patient" items="${requestScope.patients}">
			<li>${patient.id}, ${patient.firstName}, ${patient.lastName}, ${patient.phoneNo} <a href="${showPresUrl}/${patient.id}">Show Prescription</a> </li>	
		</c:forEach>
	</ul>
    </c:otherwise>
     
	</c:choose>
</body>
</html>