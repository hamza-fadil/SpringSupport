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
            <td>ID Telephone</td><td>Marque Telephone</td><td>Nombre comptes</td><td>Nombre Hotkey</td><td>PoE</td><td>SIP</td><td>Numéro de série</td> <td>Editer</td><td>Supprimer</td>
        </tr>
        
        
                            <c:choose>
                        <c:when test="${imp}">
					       <tr>
					            <td>${telephone.idMateriel}</td>
					            <td>${telephone.marque.nomMarque}</td>
					            <td>${telephone.nbCompte}</td>
					            <td>${telephone.nbHotkey}</td>
					            <td>${telephone.sip}</td>
					            <td>${telephone.poe}</td>
					            <td>${telephone.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${telephone.idMateriel}-Telephone' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${telephone.idMateriel}-Telephone' />">delete</a></td>
           					</tr>
                        </c:when>
                        <c:otherwise>
					        <c:forEach items="${imprimantes}" var="p">
					        <tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.nbCompte}</td>
					            <td>${p.nbHotkey}</td>
					            <td>${p.sip}</td>
					            <td>${p.poe}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${p.idMateriel}-Telephone' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${p.idMateriel}-Telephone' />">delete</a></td>
					         </tr>
					        </c:forEach>
					        <br><br>
                        </c:otherwise>
                    </c:choose>
                    
                    
					        <c:forEach items="${telephones}" var="p">
					            <tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.nbCompte}</td>
					            <td>${p.nbHotkey}</td>
					            <td>${p.sip}</td>
					            <td>${p.poe}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${p.idMateriel}-Telephone' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${p.idMateriel}-Telephone' />">delete</a></td>
					            </tr>
					        </c:forEach>
							

    </table>
<p><a href="<c:url value='/newTelephone' />">Ajouter un nouveau Telephone</a></p>
					        <br><br>

	<br>
	<a href="<c:url value='/' />">Index</a>
	
</body>

</html>