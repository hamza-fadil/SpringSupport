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
        <c:forEach items="${conversations}" var="p">
            <tr>
            <td>${p.contenuConversation}</td>
            <td>${p.ticket.idTicket}</td>
          <td><a href="<c:url value='/edit-${p.idConversation}-Conversation' />">edit</a></td>
            <td><a href="<c:url value='/delete-${p.idConversation}-Conversation' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
	<p><a href="<c:url value='/newConversation' />">Ajouter une nouvelle conversation</a></p>
	<br>
	<a href="<c:url value='/' />">Index</a>
</body>

</html>