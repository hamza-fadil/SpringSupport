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
            <td>Email</td><td>Nom d'utilisateur</td><td>type Utilisateur</td><td>Actif</td><td>Date de création</td><td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${users}" var="p">
            <tr>
            <td>${p.email}</td>
            <td>${p.username}</td>
            <td>${p.typeUser}</td>
            <td><c:if test="${p.enabled ==1}">Oui</c:if><c:if test="${p.enabled ==0}">Non</c:if></td>
            <td>${p.createTime}</td>
          <td><a href="<c:url value='/edit-${p.idUser}-User' />">edit</a></td>
            <td><a href="<c:url value='/delete-${p.idUser}-User' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br><br>
	<p><a href="<c:url value='/newUser' />">Ajouter un nouveau user</a></p>

	<br>
	
</body>

</html>