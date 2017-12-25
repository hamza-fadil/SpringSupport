<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
 	<title>Edition/Ajout d'utilisateurs</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <base href="/"/>
	<style type="text/css">
		body {
	 		 padding-top: 40px;
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
		<li><a href="/admin/faq" class="nav-link">FAQ</a></li>
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
     
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="idUser" id="idUser"/>

            	<div class="form-group">
                <label for="email">Email: </label> 
                <form:input path="email" id="email"/>
                <form:errors path="email" cssClass="error"/>
				</div>
         
            
            	<div class="form-group">
                <label for="username">Nom d'utilisateur: </label> 
                <form:input path="username" id="username"/>
                <form:errors path="username" cssClass="error"/>
            	</div>
            
            	<div class="form-group">
                <label for="password">Mot de passe: </label> 
                <form:password path="password" id="password"/>
                <form:errors path="password" cssClass="error"/>
            	</div>
               
            
     
            	<div class="form-group">
                <label for="typeUser">Type utilisateur: </label> 
                <form:input path="typeUser" id="typeUser"/>
                <form:errors path="typeUser" cssClass="error"/>
            	</div>
            	<div class="form-group">    
                <label for="enabled">Actif: </label> 
                <form:input path="enabled" id="enabled"/>
                <form:errors path="enabled" cssClass="error"/>
            	</div>
            	
      
            
                <div class="form-group">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
				</div>
    </form:form>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/admin/users' />">Liste de tous les users</a>
</body>
</html>