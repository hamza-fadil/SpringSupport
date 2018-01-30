<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 	<title>Page d'acceuil</title>
	<jsp:include page="includes/head.jsp" />
	
</head>
<body>
<jsp:include page="includes/nav.jsp" />
<br>
<br><br>
<div class="container">
<c:if test="${emailDup }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Email dupliqué.
	</div>
</c:if>
<c:if test="${emailInv }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Email invalide.
	</div>
</c:if>
<c:if test="${userTrouv }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Utilisateur dupliqué.
	</div>
</c:if>
<c:if test="${confirmPassword }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Les mots de passe ne sont pas indentique.
	</div>
</c:if>

    <form:form method="POST" modelAttribute="user">      
			<div class="form-group">
                <form:input path="email" type="email" id="email" placeholder="Email" class="form-control" required="true"/>
                <form:errors path="email" cssClass="has-error has-feedback"/>
            </div>
            
			<div class="form-group">	
                <form:input path="username" id="username" placeholder="Nom d'utilisateur" class="form-control" required="true"/>
                <form:errors path="username" cssClass="has-error has-feedback"/>
            </div>
            
			<div class="form-group">
                <form:password path="password" id="password" placeholder="Mot de passe" class="form-control" required="true"/>
                <%--  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" Pattern pour validation--%> 
                <form:errors path="password" cssClass="has-error "/>
            </div>   
			<div class="form-group">
                <form:password path="confirmPassword" id="confirmPassword" placeholder="Confirmer Mot de passe" class="form-control" required="true"/>
                <form:errors path="confirmPassword" cssClass="has-error "/>
            </div>   
           	<div class="form-group">
            <input type="submit" value="S'enregistrer" class="btn btn-success"/>
            </div>
            
  
    </form:form>
    <br/>
    <br/>
</div>
</body>
</html>
