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
		<div class="container ">
	  		<table id="page" class="table table-hover table-dark table-striped " >
	   		<thead>
       		<tr class="font-weight-bold">
            	<th>ID Materiel</th><th>Numero série</th><th class="no-sort">Afficher</th><th class="no-sort">Supprimer</th>
        	</tr>
        	<tbody id="myTable">
       <c:forEach items="${materiels}" var="p">
            <tr>
            <td>${p.idMateriel}</td>
            <td>${p.serieMateriel }</td>
          	<td><a class="btn btn-primary " href="<c:url value='/view-${p.idMateriel}-Materiel' />">Afficher</a></td>
			<td><a class="btn btn-danger " href="<c:url value='/delete-${p.idMateriel}-Materiel' />">Supprimer</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    <br><br>
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