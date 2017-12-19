<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajout Ticket</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
     
    <form:form method="POST" modelAttribute="ticket">
        <form:input type="hidden" path="idTicket" id="idTicket"/>
        <table>
            <tr>
                <td><label for="titreTicket">Titre: </label> </td>
                <td><form:input path="titreTicket" id="titreTicket"/></td>
                <td><form:errors path="titreTicket" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="contTicket">Contenu Ticket: </label> </td>
                <td><form:input path="contTicket" id="contTicket"/></td>
                <td><form:errors path="contTicket" cssClass="error"/></td>
            </tr>
			<tr>
                <td><label for="typeTicket">Type Ticket: </label> </td>
                <td><form:input path="typeTicket" id="typeTicket"/></td>
                <td><form:errors path="typeTicket" cssClass="error"/></td>
            </tr>
               
            <tr>
                <td><label for="user.username">Nom d'utilisateur: </label> </td>
                <td><form:input path="user.username" id="user.username"/></td>
                <td><form:errors path="user.username" cssClass="error"/></td>
            </tr>
            <tr>
<%--                 <td><label for="conversation.idConversation">Id conversation: </label> </td>
                <td><form:input path="conversation.idConversation" id="conversation.idConversation"/></td>
                <td><form:errors path="conversation.idConversation" cssClass="error"/></td>
            </tr> --%>
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/tickets' />">Liste de tous les tickets</a>
</body>
</html>