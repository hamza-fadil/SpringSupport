<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajout Téléphone</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>     
    <form:form method="POST" modelAttribute="telephone">
        <form:input type="hidden" path="idMateriel" id="idMateriel"/>
        <table>
            <tr>
                <td><label for="nbCompte">Nombre de comptes SIP: </label> </td>
                <td><form:input path="nbCompte" id="nbCompte"/></td>
                <td><form:errors path="nbCompte" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="nbHotkey">Nombre de Hotkey: </label> </td>
                <td><form:input path="nbHotkey" id="nbHotkey"/></td>
                <td><form:errors path="nbHotkey" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="sip">Gère le SIP: </label> </td>
                <td><form:checkbox path="sip" id="sip" value="0"/></td>
                <td><form:errors path="sip" cssClass="error"/></td>
            </tr>
               
            <tr>
                <td><label for="poe">Gère le POE: </label> </td>
                <td><form:checkbox path="poe" id="poe" value="0"/></td>
                <td><form:errors path="poe" cssClass="error"/></td>
            </tr>
			<tr>
                <td><label for="serieMateriel">Numéro de série: </label> </td>
                <td><form:input path="serieMateriel" id="serieMateriel"/></td>
                <td><form:errors path="serieMateriel" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="idMarque">Marque ordinateur : </label> </td>
<%--                 <c:forEach items="${marques}" var="p">
 --%>          <tr>
<%--                 	<td>${p.nomMarque}</td>
					<td><form:radiobutton items="${p.nomMarque}" value="${p.idMarque}" path="marque" /></td>
					</c:forEach>
                	<td><form:errors path="marque" cssClass="error"/></td> --%>
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
    Revenir <a href="<c:url value='/ordinateurs' />">Liste de tous les ordinateurs</a>
    	<br>
	<a href="<c:url value='/' />">Index</a>
</body>
</html>