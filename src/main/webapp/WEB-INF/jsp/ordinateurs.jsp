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
            <td>ID Ordinateur</td><td>Marque Ordinateur</td><td>Espace disque</td><td>Processeur</td><td>Ram</td><td>Systeme exploitation</td><td>Numéro de série</td> <td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${ordinateurs}" var="p">
            <tr>
            <td>${p.idMateriel}</td>
            <td>${p.marque.nomMarque}</td>
            <td>${p.espaceDisque}</td>
            <td>${p.processeur}</td>
            <td>${p.ram}</td>
            <td>${p.systemeExploitation}</td>
            <td>${p.serieMateriel}</td>
          <td><a href="<c:url value='/edit-${p.idMateriel}-Ordinateur' />">edit</a></td>
            <td><a href="<c:url value='/delete-${p.idMateriel}-Ordinateur' />">delete</a></td>
            </tr>
        </c:forEach>

    </table>
    <br><br>
	<p><a href="<c:url value='/newOrdinateur' />">Ajouter un nouvel Ordinateur</a></p>

	<br>
	<a href="<c:url value='/' />">Index</a>
	
</body>

</html>