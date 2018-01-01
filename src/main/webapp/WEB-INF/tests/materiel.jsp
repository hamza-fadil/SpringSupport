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
<%-- <c:choose>
<c:when test="${st=='tel'}">
    pizza. 
    <br />
</c:when>    
<c:otherwise>
    pizzas. 
    <br />
</c:otherwise>
</c:choose>
    <form:form method="POST" modelAttribute="materiel">
        <form:input type="hidden" path="idMateriel" id="idMateriel"/>
        <table>
            <tr>
                <td><label for="contenuConversation">Contenu: </label> </td>
                <td><form:input path="contenuConversation" id="contenuConversation"/></td>
                <td><form:errors path="contenuConversation" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="ticket.idTicket">Id Ticket: </label> </td>
                <td><form:input path="ticket.idTicket" id="ticket.idTicket"/></td>
                <td><form:errors path="ticket.idTicket" cssClass="error"/></td>
            </tr>
            <tr>
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
    <br/> --%>
    Revenir <a href="<c:url value='/materiels' />">Liste de toutes les materiels</a><br>
    <a href="<c:url value='/' />">Index</a>
</body>
</html>