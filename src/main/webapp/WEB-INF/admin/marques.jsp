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
<div class="container">
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
            <th>Nom Taches</th><th>Attribué à</th><th>Description</th><th>Fait</th><th class="no-sort">Editer</th><th class="no-sort">Supprimer</th>
        </tr>
        <tbody id="myTable">
        <c:forEach items="${taches}" var="p">
            <tr>
            <td>${p.nomTaches}</td>
            <td>${p.user.username}</td>
            <td>${p.descTaches}</td>
            <td><c:if test="${p.faitTaches ==1}">Oui</c:if><c:if test="${p.faitTaches ==0}">Non</c:if></td>
          <td><a class="btn btn-warning" href="<c:url value='/edit-${p.idTaches}-Tache' />">Modifier</a></td>
            <td><a class="btn btn-danger" href="<c:url value='/delete-${p.idTaches}-Tache' />">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
	<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newTaches' />">Ajouter une nouvelle tache</a></p>

	<script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
		</script>
		<script>
		$.noConflict();
		$(document).ready(function () {
		    $('#page').DataTable({
		    	"language": {
		    		"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
		        }
		    });
	        
		});
		</script>
</body>

</html>