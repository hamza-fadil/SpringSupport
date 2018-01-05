<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
    <head>
 	<title>Parc informatique</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />

<br>
	   <table class="table-hover table-dark table-striped mx-2" style="width:100%">
        <tr>
            <td>ID Materiel</td><td>Numero série</td><td>id Reparation</td><td>Editer</td><td>Supprimer</td>
        </tr>
       <c:forEach items="${materiels}" var="p">
            <tr>
            <td>${p.idMateriel}</td>
            <td>${p.serieMateriel }</td>
            <td>${p.reparationIdReparation}</td>
          	<td><a href="<c:url value='/view-${p.idMateriel}-Materiel' />">Afficher</a></td>
			<td><a href="<c:url value='/delete-${p.idMateriel}-Materiel' />">Supprimer</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <div class="form-group mx-5">
 	<select onchange="javascript:location.href = this.value;" class="form-control">
	 	<option value="" disabled="true" selected="true">Ajouter un materiel</option>      
	    <option value="/newOrdinateur" >Ordinateur</option>
	    <option value="/newImprimante">Imprimante</option>
	    <option value="/newTelephone">Telephone</option>
	</select>
	</div>
	<br>
</body>

</html>