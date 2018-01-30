<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 	
<head>
 	<title>Changement de mot de passe</title>
	<jsp:include page="../includes/userhead.jsp" />
		<style>
#myInput{
display:none;
}
.justify-content-end{
margin-right:2%;
}
</style>
</head>
<body><br><br>
<jsp:include page="../includes/usernav.jsp" />
<div class="container">
		<c:if test="${not empty passChange}">
			<div class="alert alert-success" role="alert">${passChange}</div>
		</c:if>
				<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
<form:form name="changePassword" class="form-horizontal" action="/changePassword" method="post">
	<input type="hidden" name="token" value="${param.token }"/>
    <div class="form-group">
			<div class="form-group">
                <input type="password" name="password" id="password" placeholder="Mot de passe" class="form-control" required/>
                <form:errors path="password" cssClass="has-error "/>
            </div>   
			<div class="form-group">
                <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirmer Mot de passe" class="form-control" required/>
                <form:errors path="confirmPassword" cssClass="has-error "/>
            </div>
		<div class="form-group col">
			<input name="submit" type="submit" value="Changer de mot de passe" class="btn btn-success" />
		</div>
	</div>
</form:form>
</div>
</body>

</html>
