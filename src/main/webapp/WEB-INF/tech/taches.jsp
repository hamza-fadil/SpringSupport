<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/techhead.jsp" />
</head>
<body>
<jsp:include page="../includes/technav.jsp" />

<br>
	   <table class="table table-hover table-dark table-striped ">
        <tr>
            <td><strong>Nom Taches</strong></td><td><strong>Attribué à</strong></td><td><strong>Description</strong></td><td><strong>Fait</strong></td><td style="text-align:center;"><strong>Editer</strong></td>
        </tr>
        <c:forEach items="${taches}" var="p">
            <tr>
            <td>${p.nomTaches}</td>
            <td>${p.user.username}</td>
            <td>${p.descTaches}</td>
            <td id="btn"><c:if test="${p.faitTaches ==1}">Oui</c:if><c:if test="${p.faitTaches ==0}">Non</c:if></td>
          <td style="text-align:center;"><a class="btn btn-success " href="<c:url value='/edit-${p.idTaches}-Tache' />">Modifier</a></td>
            </tr>
        </c:forEach>
    </table>
	<p><a class="btn btn-success float-right mx-5 " href="<c:url value='/newTaches' />">Ajouter une nouvelle tache</a></p>

	<br>
	
</body>

</html>