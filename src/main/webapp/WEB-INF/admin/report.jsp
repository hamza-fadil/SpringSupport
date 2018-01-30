<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <head>
 	<title>Rapports</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />
<br>
	<div class="container">
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
            <th>Titre</th><th>Utilisateur</th><th>Date de création</th><th>Titre du ticket</th><th class="no-sort">Afficher</th><th class="no-sort">Editer</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${rapports}" var="p">
        <tr>
            <td>${p.nomRapport}</td>
            <td>${p.user.username}</td>
            <td>${p.createTime}</td>
            <td>${p.ticket.titreTicket}</td>
            <td><a class="btn btn-info" href="<c:url  value='/read-${p.idRapport}-Rapport' />">Afficher</a> </td>
          <td><a class="btn btn-warning" href="<c:url  value='/edit-${p.idRapport}-Rapport' />">Modifier</a></td>
         </tr>
        </c:forEach>
        </tbody>
    </table>
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
		<jsp:include page="../includes/footer.jsp" />
</body>

</html>