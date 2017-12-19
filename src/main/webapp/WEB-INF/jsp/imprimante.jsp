<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajout imprimante</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>     
    <form:form method="POST" modelAttribute="imprimante">
        <form:input type="hidden" path="idMateriel" id="idMateriel"/>
        <table>
            <tr>
                <td><label for="fax">Gère le fax: </label> </td>
                <td><form:checkbox path="fax" id="fax" value="0"/></td>
                <td><form:errors path="fax" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="scanner">Gère le scanner: </label> </td>
                <td><form:checkbox path="scanner" id="scanner" value="0"/></td>
                <td><form:errors path="scanner" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="couleurs">Gère les couleurs: </label> </td>
                <td><form:checkbox path="couleurs" id="couleurs" value="0"/></td>
                <td><form:errors path="couleurs" cssClass="error"/></td>
            </tr>
               
            <tr>
                <td><label for="vitesse_impression">Vitesse d'impression: </label> </td>
                <td><form:input path="vitesse_impression" id="vitesse_impression" /></td>
                <td><form:errors path="vitesse_impression" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="format_papier">Format papier: </label> </td>
                <td><form:input path="format_papier" id="format_papier"/></td>
                <td><form:errors path="format_papier" cssClass="error"/></td>
            </tr>

			<tr>
                <td><label for="serieMateriel">Numéro de série: </label> </td>
                <td><form:input path="serieMateriel" id="serieMateriel"/></td>
                <td><form:errors path="serieMateriel" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="idMarque">Marque ordinateur : </label> </td>
                <tr>
               <form:select path="marque">
	               <c:forEach items="${marques}" var="p">
	               		<form:option value="${p.idMarque}">${p.nomMarque}</form:option>
	               </c:forEach>
               </form:select>
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
    Revenir <a href="<c:url value='/imprimantes' />">Liste de toutes les imprimantes</a>
    	<br>
	<a href="<c:url value='/' />">Index</a>
</body>
</html>