<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>Administration d'utilisateurs</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <base href="/"/>
	<style type="text/css">
		body {
	 		 padding-top: 40px;
			}		li {
			padding-right : 30px;
		}
	</style>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css'>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark nav-tabs nav-justified">
	<ul class="navbar-nav mr-auto">
		<li><a href="/admin/index" class="nav-link">Index</a></li>
		<li><a href="/admin/ticket" class="nav-link">Tickets</a></li>
		<li><a href="/admin/users" class="nav-link">Utilisateurs</a></li>
		<li><a href="/admin/taches" class="nav-link">Taches</a></li>
		<li><a href="/admin/parc" class="nav-link">Parc informatique</a></li>
		<li><a href="/admin/newsletter" class="nav-link">Newsletter</a></li>
		<li><a href="/admin/report" class="nav-link">Rapports</a></li>
		<li><a href="/admin/tests" class="nav-link">Tests</a></li>
	</ul>
	<c:choose >
		<c:when test="${not empty username}">
    		<ul class="nav justify-content-end">
        		<li class="navbar-text" style="color:white;">${username }  </li>
        		<li><a href="logout" class="btn btn-primary btn-danger">Se déconnecter</a></li>
        	</ul>
	    </c:when>
		<c:otherwise>
			<ul class="nav justify-content-end">
				<li><a href="login" id="login">Connexion </a></li>
				<li><a href="inscription" id="inscription">Inscription</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>
<br>
	   <table class="table-hover table-dark table-striped mx-2" style="width:100%">
        <tr>
            <td>Email</td><td>Nom d'utilisateur</td><td>type Utilisateur</td><td>Actif</td><td>Date de création</td><td>Editer</td><td>Supprimer</td>
        </tr>
        <c:forEach items="${users}" var="p">
            <tr>
            <td>${p.email}</td>
            <td>${p.username}</td>
            <td>${p.typeUser}</td>
            <td><c:if test="${p.enabled ==1}">Oui</c:if><c:if test="${p.enabled ==0}">Non</c:if></td>
            <td>${p.createTime}</td>
          <td><a href="<c:url value='/edit-${p.idUser}-User' />">edit</a></td>
            <td><a href="<c:url value='/delete-${p.idUser}-User' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br><br>
	<p><a href="<c:url value='/newUser' />">Ajouter un nouveau user</a></p>

	<br>
	<a href="<c:url value='/' />">Index</a>
	
</body>

</html>