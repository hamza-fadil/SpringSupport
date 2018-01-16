<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <head>
 	<title>Rapports</title>
	<jsp:include page="../includes/techhead.jsp" />
</head>
<body>
<jsp:include page="../includes/technav.jsp" />

<br>
	   <table class="table table-hover table-dark table-striped ">
        <tr>
            <td>Titre rapport</td><td>Titre ticket</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${rapports}" var="p">
            <tr>
            <td>${p.nomRapport}</td>
            <td>${p.descRapport}</td>
            <td><a class="btn btn-danger " href="<c:url value='/delete-${p.idRapport}-Rapport' />">Supprimer</a></td>
            </tr>
        </c:forEach>
    </table>
	<br>
	
</body>

</html>