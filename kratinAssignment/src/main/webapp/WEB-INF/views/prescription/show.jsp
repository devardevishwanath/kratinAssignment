<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello, Dr. ${sessionScope.doc_info.docName}</h2>
	<h2>Prescription for ${sessionScope.patient.firstName}</h2>
	
 	<spring:url var="addPrescUrl" value="/prescription/add" />
	
	 	<a href="${addPrescUrl}">Add prescription</a>
	
	<c:choose>
	    <c:when test="${requestScope.patient.prescriptions.isEmpty()}">
			<h3>Please add prescriptions.</h3>		
	    </c:when>
	    <c:otherwise>
		<ul>
			<c:forEach var="presc" items="${requestScope.patient.prescriptions}">
				<li>${presc.medicineName}, ${presc.dosage}, ${presc.timeToTakeDesage} </li>	
			</c:forEach>
		</ul>
	    </c:otherwise>
	</c:choose>
</body>
</html>