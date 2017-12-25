<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
</head>
<body>

	<a href="<c:url value='/users' />">Utilisateurs</a>
	<br>
	<a href="<c:url value='/tickets' />">Tickets</a>
	<br>
	<a href="<c:url value='/fichiers' />">Fichiers</a>
	<br>	
	<a href="<c:url value='/ordinateurs' />">Ordinateurs</a>
	<br>
	<a href="<c:url value='/materiels' />">Materiels</a>
	<br>
	<a href="<c:url value='/marques' />">Marques</a>
	<br>
	<a href="<c:url value='/conversations' />">Conversations</a>
	<br>
	<a href="<c:url value='/telephones' />">Telephones</a>
	<br>
	<a href="<c:url value='/imprimantes' />">Imprimantes</a>
	<br>
	<a href="<c:url value='/' />">Index</a>
	<br>
	<br>
</body>

</html>