<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="context" value="${pageContext.request.contextPath}" />
<html lang="en">
  <head>
 	<title>Ticket : ${ticket.titreTicket}</title>
	<jsp:include page="../includes/adminhead.jsp" />
	<style>
	.entry-footer .excerpt p {
   word-wrap: break-word;
}
#myInput {
display:none;
}
.justify-content-end{
margin-right:2%;
}
</style>
</head>
<body>
	<jsp:include page="../includes/usernav.jsp" />
<br>
    <div class="container">
    <div class="row">
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Titre : ${ticket.titreTicket}</div>
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Utilisateur : ${ticket.user.username}</div>
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Etat du ticket : ${ticket.etatTicket}</div>
        <div class="card bg-faded col-sm-3 pt-2 pb-2">Type du ticket : <c:if test="${ticket.typeTicket=='M'}">Materiel</c:if><c:if test="${ticket.typeTicket=='L'}">Logiciel</c:if></div>
        <div class="card bg-faded col-sm-3 pt-2 pb-2">Crée le : ${ticket.createTime}</div>
        <div class="card bg-faded col-sm-12 pt-2 pb-2 text-info lead">${ticket.contTicket}</div>
        
        <div class="card bg-faded col-sm-12">
        	<c:if test="${empty ticket.fichiers}">
        	<c:if test="${not empty tooFAT}">
				<div class="alert alert-danger" role="alert">${tooFAT}</div>
			</c:if>
				<form:form method="POST" action="/add-${ticket.idTicket }" enctype="multipart/form-data">
					<div class="container mt-2">
  						<input id="input-id" type="file" class="file" name="file" data-preview-file-type="text">	
					</div>
        		</form:form>
        	</c:if>
        	<c:if test="${not empty ticket.fichiers}">
        		<table id="page" class="table table-hover table-striped" >
	   				<thead>
        				<tr class="font-weight-bold">
            				<th>Nom de fichier</th><th class="no-sort">Télécharger</th><th class="no-sort">Supprimer</th>
        				</tr>
        			</thead>
 				<c:forEach items="${ticket.fichiers}" var="p">
 				<tr>
	 				<td>${p.nomOrigine}</td>
	 				<td><img src="/image/${p.idFichier}" width="100" height="100"></td>
	 				<td><a class="btn btn-danger" href="/delete-${p.idFichier}-Fichier">Supprimer</a></td>
	 			</tr>

				</c:forEach> 
				<tr>

	 			</tr>
				</table>
				<form:form method="POST" action="/add-${ticket.idTicket }" enctype="multipart/form-data">
		        	<input type="hidden" name="idTicket" id="idTicket" value="${ticket.idTicket}"/>
         		<div class="container">
         	<c:if test="${not empty tooFAT}">
				<div class="alert alert-danger" role="alert">${tooFAT}</div>
			</c:if>
					<input id="input-id" type="file" class="file" name="file" data-preview-file-type="text">	
				</div>
        		</form:form>
			</c:if>
        </div>
        <div class="card bg-faded col-sm-12"><br>
        	<form:form method="POST" action="/com-${ticket.idTicket }">
			<textarea class="form-control" id="contenuConversation" name="contenuConversation" rows="5"  placeholder="Ajouter un commentaire" required></textarea><br>
			<input style="float:right;" type="submit" value="Envoyer" class="btn btn-success"/>
    	</form:form>
        </div>
        <div class="card bf-faded col-sm-12">
        	<c:forEach items="${ticket.conversations}" var="p">
 				<div class="col-sm-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${p.user.username}</strong> <span class="text-muted">le ${p.createTime }</span>
						</div>
					<div class="panel-body">
			${p.contenuConversation }
			</div><!-- /panel-body -->
			</div><!-- /panel panel-default -->
			</div><!-- /col-sm-5 -->
				</c:forEach> 
        </div>
        
        
    </div>
</div>
<script>
$(document).ready(function() {
    $('input[type="file"]').change(function() {
        var val = ($(this).val() != "") ? $(this).val() : "Aucun fichier selectionné";
        $('.filename').attr('placeholder', val);
    });
});
var originalPos;
$(document).on("scroll", function(e){
    if($("#menu").hasClass("affixed")){
        if($(document).scrollTop() <= originalPos)
            $("#menu").removeClass("affixed");
        return;
    }
       
    if((originalPos = $(document).scrollTop()) >= ($("#menu").offset().top - $("#menu").height())){
        $("#menu").addClass("affixed");
    }
})
// initialize with defaults
$("#input-id").fileinput();
 
// with plugin options
$("#input-id").fileinput({'showUpload':false, 'previewFileType':'any'});
</script>

</body>
</html>