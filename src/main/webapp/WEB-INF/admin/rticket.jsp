<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>Ticket : ${ticket.titreTicket}</title>
	<jsp:include page="../includes/adminhead.jsp" />
	<style>
	.entry-footer .excerpt p {
   word-wrap: break-word;
}
</style>
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />
<br>
	<div class="container">
		<h2>${ticket.titreTicket}</h2><br>
		<p>${ticket.user.username}</p>
		<p>${ticket.etatTicket}</p>
		<p>${ticket.typeTicket}</p>
		<p>${ticket.contTicket}</p>
    </div>
	<br>
</body>

</html>