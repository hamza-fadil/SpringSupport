<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
 	<title>Imprimantes ${imp.serieMateriel}</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/technav.jsp" />
<h2 class=mx-5>Imprimantes :</h2><br>
		<div class="container ">
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
            <th>ID Materiel</th><th>Marque Imprimante</th><th>Gère couleurs</th><th>Gère le fax</th><th>Gère le scanner</th><th>Format papier</th><th>Vitesse d'impression</th><th>Numéro de série</th> <th class="no-sort">Editer</th><th class="no-sort">Supprimer</th>
        </tr>
        <tbody id="myTable">
               <c:forEach items="${imprimantes}" var="p">
							<tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.couleurs}</td>
					            <td>${p.fax}</td>
					            <td>${p.scanner}</td>
					            <td>${p.format_papier}</td>
					            <td>${p.vitesse_impression}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a class="btn btn-warning " href="<c:url value='/edit-${p.idMateriel}-Imprimante' />">Modifier</a></td>
					            <td><a class="btn btn-danger" href="<c:url value='/delete-${p.idMateriel}-Imprimante' />">Supprimer</a></td>
					         </tr>
				</c:forEach>
				</tbody>
  </table>
  	<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newImprimante' />">Ajouter une nouvelle imprimante</a></p>
  </div>
	<br>
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