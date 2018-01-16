<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
 <head>
<title>${ticket.titreTicket}</title>
<jsp:include page="../includes/adminhead.jsp" />
</head>

<body>
<jsp:include page="../includes/usernav.jsp" />
<br>
	<div class="container">
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
            <th>Titre</th><th>Contenu</th><th>Utilisateur</th><th>Type ticket</th><th class="no-sort">Fermer</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${tickets}" var="p">
            <tr>
            <td>${p.titreTicket}</td>
            <td>${p.contTicket}</td>
            <td>${p.user.username}</td>
            <td>${p.typeTicket}</td>
            <td><a class="btn btn-danger" href="/user/closeTicket-${p.idTicket}">Fermer</a></td>
            </tr>
        </c:forEach>
        </tbody>
        
    </table>
    </div>
    <br><br>
	<p><a href="<c:url value='/newTicket' />">Ajouter un nouveau ticket</a></p>
	
	<jsp:include page="../includes/footer.jsp" />
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