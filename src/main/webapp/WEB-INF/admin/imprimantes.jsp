<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />

	   <table>
        <tr>
            <td>ID Materiel</td><td>Marque Imprimante</td><td>Gère couleurs</td><td>Gère le fax</td><td>Gère le scanner</td><td>Format papier</td><td>Vitesse d'impression</td><td>Numéro de série</td> <td>Editer</td><td>Supprimer</td>
        </tr>
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
  </table>
	<p><a href="<c:url value='/newImprimante' />">Ajouter une nouvelle imprimante</a></p>
	<br>
	
</body>

</html>