<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
</head>
<body>

	   <table border=1px>
        <tr>
            <td>Contenu conversation</td><td>id Ticket</td><td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${fichiers}" var="p">
            <tr>
            <td>${p.ticket.idTicket}</td>
            <td>${p.fichierJoint}</td>
          <td><a href="<c:url value='/get-${p.idFichier}-Fichier' />">Get</a></td>
            <td><a href="<c:url value='/delete-${p.idFichier}-Fichier' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
	<p><a href="<c:url value='/fichier' />">Ajouter une nouvelle image</a></p>
	<br>
	<a href="<c:url value='/' />">Index</a>
</body>

</html>