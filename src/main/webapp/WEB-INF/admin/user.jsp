<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
 
<head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
	<style>
#myInput{
display:none;
}
.justify-content-end{
margin-right:2%;
}
</style>
</head>
 
<body>
 <jsp:include page="../includes/adminnav.jsp" />

<br>
     
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="idUser" id="idUser"/>
		
            	<div class="form-group mx-5">
                <form:input class="form-control" placeholder="Email" path="email" id="email" type="email" required="true"/>
                <form:errors path="email" cssClass="error"/>
				</div>
         
            
            	<div class="form-group mx-5">
                <form:input class="form-control" placeholder="Nom d'utilisateur" path="username" id="username" required="true"/>
                <form:errors path="username" cssClass="error"/>
            	</div>
            
            	<div class="form-group mx-5">
                <form:password class="form-control" placeholder="Mot de passe" path="password" id="password" value="${user.password }" required="true"/>
                <form:errors path="password" cssClass="error"/>
            	</div>
               	

     		
            	<div class="form-group mx-5">
            	<form:select path="typeUser" class="form-control" required="true">
            		<option value="" disabled="true" selected="true">Type d'utilisateur</option>
            		<form:option value="ROLE_ADMIN" >Administrateur</form:option>
	           		<form:option value="ROLE_USER">Utilisateur</form:option> 
	           		<form:option value="ROLE_TECH">Technicien</form:option>
                <form:errors path="typeUser" cssClass="error"/>
                </form:select>
            	</div>
       
            	
            	<div class="form-group mx-5">    
				<form:select path="enabled" class="form-control" required="true">
            		<option value="" disabled="true" selected="true">Actif</option>
            		<form:option value="1" >Oui</form:option>
	           		<form:option value="0">Non</form:option> 
                <form:errors path="enabled" cssClass="error"/>
                </form:select>
                <form:errors path="enabled" cssClass="error"/>
            	</div>
            	
      
            
                <div class="form-group mx-5">
                    <c:choose>
                        <c:when test="${edit}">
                            <input class="btn btn-success" type="submit" value="Mettre a jour"/>
                        </c:when>
                        <c:otherwise>
                            <input class="btn btn-success" type="submit" value="Enregistrer"/>
                        </c:otherwise>
                    </c:choose>
				</div>
    </form:form>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/admin/users' />">Liste de tous les users</a>
</body>
</html>