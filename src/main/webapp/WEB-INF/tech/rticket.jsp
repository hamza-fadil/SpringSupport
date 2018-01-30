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
.custom-file-name:after {
  content: attr(data-content) !important;
  position: absolute;
  top: 0px;
  left: 0px;
  display: block;
  height: 100%;
  overflow: hidden;
  padding: 0.5rem 1rem;
}
.fileuploader {
    position: relative;
    display: inline-block;
    overflow: hidden;
    cursor: default;
}

.filename {
    float: left;
    display: inline-block;
    outline: 0 none;
    height: 30px;
    width: 302px;
    overflow: hidden;
    border: 1px solid #CCCCCC;
    color: #777;
    text-shadow: 1px 1px 0px #fff;
    border-radius: 5px 0px 0px 5px;
    box-shadow: 0px 0px 1px #fff inset;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    padding: 6px 10px;
}

.filebutton {
    float: left;
    height: 30px;
    display: inline-block;
    outline: 0 none;
    cursor: pointer;
    border: 1px solid #CCCCCC;
    border-radius: 5px 5px 5px 5px;
    box-shadow: 0 0 1px #fff inset;
    color: #555555;
    margin-left: 3px;
    padding: 6px 12px;
    background: #DDDDDD;
    background:-moz-linear-gradient(top, #EEEEEE 0%, #DDDDDD 100%);
    background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #EEEEEE), color-stop(100%, #DDDDDD));filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#EEEEEE', endColorstr='#DDDDDD', GradientType=0);
}

.fileuploader input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    border: 0;
    height: 30px;
    cursor: pointer;
    filter:alpha(opacity=0);
    -moz-opacity: 0;
    -khtml-opacity: 0;
    opacity: 0;
    margin: 0;
    padding: 0;
}
</style>
</head>
<body>
          		<jsp:include page="../includes/technav.jsp" />
<br>

	<div class="card bg-dark mx-5 " id="menu" data-spy="affix" data-offset-top="205" style="float:right;">
	        <c:if test = "${ticket.etatTicket== 'close'}">
          		<a class="btn btn-success" href="<c:url  value='/open-${ticket.idTicket}-Ticket' />">Ouvrir</a>
          	</c:if>
          	<c:if test = "${ticket.etatTicket== 'open'}">
          		<a class="btn btn-danger" href="<c:url  value='/close-${ticket.idTicket}-Ticket' />">Fermer</a>
          	</c:if>
          	<a class="btn btn-warning" href="<c:url  value='/edit-${ticket.idTicket}-Ticket' />">Modifier</a>
          	<a class="btn btn-success" href="<c:url  value='/add-${ticket.idTicket}-Rapport' />">Ajouter</a> 
	</div>
	
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
        <c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
				<form:form method="POST" action="/add-${ticket.idTicket }" enctype="multipart/form-data">
					<div class="fileuploader">
  						<input id="input-id" type="file" class="file" name="file" data-preview-file-type="text">	
					</div>
        		</form:form>
        	</c:if>
        	<c:if test="${not empty ticket.fichiers}">
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
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
         		<div class="fileuploader">
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