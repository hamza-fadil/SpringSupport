<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajout User</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
     
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="idUser" id="idUser"/>
        <table>
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="username">Nom d'utilisateur: </label> </td>
                <td><form:input path="username" id="username"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="password">Mot de passe: </label> </td>
                <td><form:input path="password" id="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
               
            <tr>
                <td><label for="typeUser">Type utilisateur: </label> </td>
                <td><form:input path="typeUser" id="typeUser"/></td>
                <td><form:errors path="typeUser" cssClass="error"/></td>
            </tr>
                <tr>
                <td><label for="enabled">Actif: </label> </td>
                <td><form:input path="enabled" id="enabled"/></td>
                <td><form:errors path="enabled" cssClass="error"/></td>
            </tr>
      
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
    Revenir <a href="<c:url value='/users' />">Liste de tous les users</a>
</body>
</html>