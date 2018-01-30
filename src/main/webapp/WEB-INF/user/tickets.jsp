<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="fr">
  <head>
 	<title>Tickets</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/usernav.jsp" />
<br>
	<div class="container">
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
            <th>Titre</th><th>Utilisateur</th><th>Type ticket</th><th class="no-sort">Afficher</th><th class="no-sort">Editer</th><th class="no-sort">Etat du ticket</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${tickets}" var="p">
        <tr>
            <td>${p.titreTicket}</td>
            <td>${p.user.username}</td>
            <td>
			<c:if test = "${p.typeTicket== 'M'}">
          		Materiel
          	</c:if>
          	<c:if test = "${p.typeTicket== 'L'}">
          		Logiciel
          	</c:if>
            </td>
            <td><a class="btn btn-info" href="<c:url  value='/read-${p.idTicket}-Ticket' />">Afficher</a> </td>
          <td><a class="btn btn-warning" href="<c:url  value='/edit-${p.idTicket}-Ticket' />">Modifier</a></td>
          <td>
          	<c:if test = "${p.etatTicket== 'close'}">
          		<a class="btn btn-danger" href="<c:url  value='/user/ticket' />">Fermer</a>
          	</c:if>
          	<c:if test = "${p.etatTicket== 'open'}">
          		          		<a class="btn btn-success" href="<c:url  value='/user/ticket' />">Ouvert</a>
          		
          	</c:if>
          </td>
         </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
	<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newTicket' />">Ajouter un nouveau ticket</a></p>
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