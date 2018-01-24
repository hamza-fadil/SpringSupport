<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
 	<title>Connexion</title>
	<jsp:include page="includes/head.jsp" />
</head>
<body>
<jsp:include page="includes/nav.jsp" />

	<div class="form-control" style="padding-top: 40px;">

		<h2 class="lead text-center">Veuillez renseigner votre login et mot de passe</h2>

		<c:if test="${not empty error}">
			<div class="bg-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="bg-danger">${msg}</div>
		</c:if>
		<br>
		
		<form name='loginForm' action="<c:url value='/login' />" method='POST' class="form-signin">
		<div class="container">
				<div class="form-group col">
				<input type='text' name='username' class="form-control" placeholder="Utilisateur"  required="true"/>
				</div>
				<div class="form-group col">
				<input type='password' name='password' class="form-control" placeholder="Mot de passe" required="true" />
				</div>
				<div class="form-group col">
				<input name="submit" type="submit" value="Se connecter" class="btn btn-success" />
				</div>
		  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	</form>
	</div>

</body>
</html>