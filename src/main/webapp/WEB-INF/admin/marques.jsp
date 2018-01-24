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
            <th>Marques</th><th class="no-sort">Editer</th><th class="no-sort">Supprimer</th>
        </tr>
        <tbody id="myTable">
        <c:forEach items="${marques}" var="p">
            <tr>
            <td>${p.nomMarque}</td>
          <td><a class="btn btn-warning" href="<c:url value='/edit-${p.idMarque}-Marque' />">Modifier</a></td>
            <td><a class="btn btn-danger" href="<c:url value='/delete-${p.idMarque}-Marque' />">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
	<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newMarque' />">Ajouter une nouvelle marque</a></p>

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