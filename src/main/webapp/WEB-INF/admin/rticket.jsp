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
</style>
</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />
<br>
    <div class="container">
    <div class="row">
        <div class="card bg-faded col-sm-6">${ticket.titreTicket}</div>
        <div class="card bg-faded col-sm-6">${ticket.user.username}</div>
        <div class="card bg-faded col-sm-6">${ticket.etatTicket}</div>
        <div class="card bg-faded col-sm-3"><c:if test="${ticket.typeTicket=='M'}">Materiel</c:if><c:if test="${ticket.typeTicket=='L'}">Logiciel</c:if></div>
        <div class="card bg-faded col-sm-3">${ticket.createTime}</div>
        <div class="card bg-faded col-sm-12"><br><br>${ticket.contTicket}</div>
        
        <div class="card bg-faded col-sm-12">
        	<c:if test="${empty ticket.fichiers}">
				<form:form method="POST" action="/add-${ticket.idTicket }" enctype="multipart/form-data">
		        	<input type="hidden" name="idTicket" id="idTicket" value="${ticket.idTicket}"/>
		            <input type="file" name="file"/>
		            <input type="submit"/>
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
		            <input type="file" name="file"/>
		            <input type="submit"/>
        		</form:form>
			</c:if>
        </div>
        <div class="card bf-faded col-sm-12">
        	<c:forEach items="${ticket.conversations}" var="p">
 				<tr>
	 				<td>${p.contenuConversation}</td>
	 				<td><a  href="/delete-${p.idConversation}-Conversation">Supprimer</a></td>
	 			</tr>

				</c:forEach> 
        </div>
        <div class="card bg-faded col-sm-12">
        	<form:form method="POST" action="/com-${ticket.idTicket }">
			<textarea id="contenuConversation" name="contenuConversation" rows="5"  placeholder="Ajouter un commentaire" required="true"></textarea>
			<input type="submit" value="Envoyer" class="btn btn-success"/>
    	</form:form>
        </div>
    </div>
</div>


</body>

</html>