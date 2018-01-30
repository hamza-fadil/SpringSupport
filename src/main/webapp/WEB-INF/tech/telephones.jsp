<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <head>
 	<title>Telephones ${imprimante.serieMateriel}</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
 
<body>
 <jsp:include page="../includes/technav.jsp" /> 
<h2 class=mx-5>Téléphones :</h2><br>
	<div class="container">	   
	<table id="page" class="table table-hover table-dark table-striped ">
        <thead>
        <tr class="font-weight-bold">
            <th>ID Telephone</th><th>Marque Telephone</th><th>Nombre comptes</th><th>Nombre Hotkey</th><th>PoE</th><th>SIP</th><th>Numéro de série</th> <th>Editer</th><th>Supprimer</th>
        </tr>
        </thead>
        <tbody id="myTable">
                            <c:choose>
                        <c:when test="${imp}">
					       <tr>
					            <td>${telephone.idMateriel}</td>
					            <td>${telephone.marque.nomMarque}</td>
					            <td>${telephone.nbCompte}</td>
					            <td>${telephone.nbHotkey}</td>
					            <td>${telephone.sip}</td>
					            <td>${telephone.poe}</td>
					            <td>${telephone.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${telephone.idMateriel}-Telephone' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${telephone.idMateriel}-Telephone' />">delete</a></td>
           					</tr>
                        </c:when>
                        <c:otherwise>
					        <c:forEach items="${imprimantes}" var="p">
					        <tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.nbCompte}</td>
					            <td>${p.nbHotkey}</td>
					            <td>${p.sip}</td>
					            <td>${p.poe}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a href="<c:url value='/edit-${p.idMateriel}-Telephone' />">edit</a></td>
					            <td><a href="<c:url value='/delete-${p.idMateriel}-Telephone' />">delete</a></td>
					         </tr>
					        </c:forEach>
					        <br><br>
                        </c:otherwise>
                    </c:choose>
					        <c:forEach items="${telephones}" var="p">
					            <tr>
					            <td>${p.idMateriel}</td>
					            <td>${p.marque.nomMarque}</td>
					            <td>${p.nbCompte}</td>
					            <td>${p.nbHotkey}</td>
					            <td>${p.sip}</td>
					            <td>${p.poe}</td>
					            <td>${p.serieMateriel}</td>
					          	<td><a class="btn btn-warning"   href="<c:url value='/edit-${p.idMateriel}-Telephone' />">edit</a></td>
					            <td><a class="btn btn-danger" href="<c:url value='/delete-${p.idMateriel}-Telephone' />">delete</a></td>
					            </tr>
					        </c:forEach>
			</tbody>
    </table>
    </div>
    
<p><a class="btn btn-success float-right mx-5" href="<c:url value='/newTelephone' />">Ajouter un nouveau Telephone</a></p>
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