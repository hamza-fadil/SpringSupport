<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="fr">
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
          		<jsp:include page="../includes/technav.jsp" />
<br>

	<div class="card bg-dark mx-5 " id="menu" data-spy="affix" data-offset-top="205" style="float:right;">
          	<a class="btn btn-warning" href="<c:url  value='/edit-${idRapport}-Rapport' />">Modifier</a>
	</div>
	
    <div class="container">
    <div class="row">
        <div class="card bg-faded col-sm-6 pt-2 pb-2 ">Titre du rapport : ${rapport.nomRapport}</div>
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Utilisateur : ${rapport.user.username}</div>
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Titre du ticket : ${rapport.ticket.titreTicket}</div>
        <div class="card bg-faded col-sm-6 pt-2 pb-2">Type du ticket : <c:if test="${rapport.ticket.typeTicket=='L'}">Logiciel</c:if><c:if test="${rapport.ticket.typeTicket=='M'}">Materiel</c:if> </div>
        <div class="card bg-faded col-sm-12 pt-2 pb-2"><br><br>${rapport.descRapport}</div>
    </div>
</div>
</body>
</html>