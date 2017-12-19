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
            <td>ID imprimante</td><td>Marque imprimante</td><td>Gère les couleurs</td><td>Gère le fax</td><td>Gère le scanner</td><td>Format papier</td><td>Vitesse d'impression</td><td>Numéro de série</td> <td>Editer</td><td>Supprimer</td>
        </tr>
        
                    <c:choose>
                        <c:when test="${imp}">
					       <tr>
								<td>${imprimante.idMateriel}</td>
					            <td>${imprimante.marque.nomMarque}</td>
					            <td>${imprimante.couleurs}</td>
					            <td>${imprimante.fax}</td>
					            <td>${imprimante.scanner}</td>
					            <td>${imprimante.format_papier}</td>
					            <td>${imprimante.vitesse_impression}</td>
					            <td>${imprimante.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${telephone.idMateriel}-Imprimante' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${telephone.idMateriel}-Imprimante' />">delete</a></td>
           					</tr>
                        </c:when>
                        <c:otherwise>
					        <c:forEach items="${imprimantes}" var="p">
					        <tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.couleurs}</td>
					            <td>${p.fax}</td>
					            <td>${p.scanner}</td>
					            <td>${p.format_papier}</td>
					            <td>${p.vitesse_impression}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${p.idMateriel}-Imprimante' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${p.idMateriel}-Imprimante' />">delete</a></td>
					         </tr>
					        </c:forEach>
					        <br><br>
								<p><a href="<c:url value='/newOrdinateur' />">Ajouter une nouvelle imprimante</a></p>
                        </c:otherwise>
                    </c:choose>
							

    </table>
					        <br><br>

	<br>
	<a href="<c:url value='/' />">Index</a>
	
</body>

</html>