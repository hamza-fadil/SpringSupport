<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>Utilisateurs</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />
<br>  
<br>
		<div class="container ">
		  
	   <table id="page" class="table table-hover table-dark table-striped " >
	   <thead>
        <tr class="font-weight-bold">
        
            <th>Email</th><th>Nom d'utilisateur</th><th>Type d'utilisateur</th><th>Actif</th><th>Date de création</th><th class="no-sort">Editer</th><th class="no-sort">Désactiver/Activer</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${users}" var="p">
            <tr>
            <td>${p.email}</td>
            <td>${p.username}</td>
            <td><c:if test="${p.typeUser =='ROLE_USER'}">Utilisateur</c:if><c:if test="${p.typeUser == 'ROLE_ADMIN'}">Administrateur</c:if><c:if test="${p.typeUser == 'ROLE_TECH'}">Technicien</c:if></td>
            <td><c:if test="${p.enabled ==1}">Oui</c:if><c:if test="${p.enabled ==0}">Non</c:if></td>
            <td>${p.createTime}</td>
          <td><a class="btn btn-warning" href="<c:url value='/edit-${p.idUser}-User' />">Modifier</a></td>
            <td><a class="btn btn-danger" href="<c:url value='/enable-${p.idUser}-User' />">Désactiver</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    	<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newUser' />">Ajouter un nouveau user</a></p>
    
</div>
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