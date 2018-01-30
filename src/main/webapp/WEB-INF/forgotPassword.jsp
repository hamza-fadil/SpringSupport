
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 	
<head>
 	<title>Connexion</title>
	<jsp:include page="includes/head.jsp" />
</head>
<body><br><br>
<jsp:include page="includes/nav.jsp" />
<div class="container">
<form:form name="forgotPassword" class="form-horizontal" action="/forgotPassword" method="post">
    <div class="alert alert-warning">
    	Si vous avez oublier votre mot de passe, vous pouvez le changer en renseignant votre email, un email de confirmation vous sera envoyé ensuite.
      </div>
  		<c:if test="${not empty nonTrouv}">
				<div class="alert alert-danger" role="alert">${nonTrouv}</div>
		</c:if>
    <div class="form-group">
		<div class="form-group col">
			<input type='email' name='email' class="form-control" placeholder="Email" required/>
		</div>
		<div class="form-group col">
			<input name="submit" type="submit" value="Changer de mot de passe" class="btn btn-success" />
		</div>
	</div>
</form:form>
</div>
</body>

</html>
