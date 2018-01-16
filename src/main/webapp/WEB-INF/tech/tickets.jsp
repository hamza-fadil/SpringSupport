<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>Page d'acceuil</title>
	<jsp:include page="../includes/techhead.jsp" />
</head>
	
<body>
<jsp:include page="../includes/technav.jsp" />
	   <table class="table table-hover table-dark table-striped">
        <tr>
            <td>Titre</td><td>Contenu</td><td>Utilisateur</td><td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${tickets}" var="p">
            <tr>
            <td>${p.titreTicket}</td>
            <td>${p.contTicket}</td>
            <td>${p.user.username}</td>
          <td><a class="btn btn-success " href="<c:url value='/edit-${p.idTicket}-Ticket' />">Modifier</a></td>
            <td><a class="btn btn-danger " href="<c:url value='/delete-${p.idTicket}-Ticket' />">Fermer</a></td>
            </tr>
        </c:forEach>
    </table>
	<p><a class="btn btn-success float-right mx-5 " href="<c:url value='/newTicket' />">Ajouter un nouveau ticket</a></p>
	<br>
</body>

</html>