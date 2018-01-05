<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />
<br>
	   <table class="table-hover table-dark table-striped mx-2" style="width:100%">
        <tr>
            <td>Titre</td><td>Contenu</td><td>Utilisateur</td><td>Type ticket</td><td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${tickets}" var="p">
            <tr class='clickable-row' data-href='#'>
            <td>${p.titreTicket}</td>
            <td>${p.contTicket}</td>
            <td>${p.user.username}</td>
            <td>${p.typeTicket}</td>
          <td><a href="<c:url value='/edit-${p.idTicket}-Ticket' />">edit</a></td>
            <td><a href="<c:url value='/delete-${p.idTicket}-Ticket' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
	<p><a href="<c:url value='/newTicket' />">Ajouter un nouveau ticket</a></p>
	<br>
</body>

</html>