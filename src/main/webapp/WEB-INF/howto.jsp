<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<head>
 	<title>Aide d'utilisation</title>
	<jsp:include page="includes/head.jsp" />
</head>
<body>
<jsp:include page="includes/nav.jsp" />
	<br><br>

<div class="container">
	<h1>Support informatique</h1><br>
	<h2>Description</h2>
		<p>L'application permet de remonter l'information vers le département informatique le plus rapidement possible, en permettant à l'utilisateurs d'avoir accès a un suivi des tickets.</p>
	<h2>Inscription</h2>
		<p>En suivant le lien suivant : <a href="/inscription">/Inscription</a> vous vous retrouverez dans l'interface d'inscription, renseignez votre email ainsi que votre mot de passe</p>
		<p>Vous allez recevoir un email vous demandant de confirmer votre email.</p>
		<p>Après confirmation vous pouvez vous connecter.</p>
	<h2>Connexion</h2>
		<p>Après inscription, la prochaine étape est l'identification pour commencer à utiliser le site.
		<p>En suivant le lien suivant : <a href="/login">/Connexion</a> vous vous retrouverez dans l'interface de connexion, renseignez votre email ainsi que votre mot de passe pour être rediriger à l'index</p>
	<h2></h2>
</div>

<jsp:include page="includes/footer.jsp" />
</body>
</html>