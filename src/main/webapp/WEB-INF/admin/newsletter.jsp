<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
	<link href="https://cdn.quilljs.com/1.3.5/quill.snow.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../includes/adminnav.jsp" />

<form:form method="POST" action="/admin/newsletter">

<div id="form-container" class="container" style="height: 60%; ">
<div class="form-control">
	<select name="grpUtilisateurs" required class="form-control">
	<option value="" disabled selected>Groupe d'utilisateur</option>
	<option value="ROLE_USER">Utilisateurs</option>
	<option value="ROLE_TECH">Techniciens</option>
	<option value="ROLE_ADMIN">Administrateurs</option>
	</select>
</div>
<br>
<div class="form-control">
	<input type="text" name="titre" required placeholder="Titre du mail" class="form-control"/>
</div>
<br>
<div>

	<textarea name="mail" rows="10" class="form-control" required></textarea>
	<br>
	<div class="row" style="float:right;">
      <button class="btn btn-primary" type="submit">Envoyer Email</button>
    </div>
    </div>
</div>
</form:form>
	
</body>

<!-- Include the Quill library -->
<script src="https://cdn.quilljs.com/1.3.5/quill.js"></script>

<!-- Initialize Quill editor -->

</html>