<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
   <head>
 	<title>Ajouter un rapport</title>
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
 <jsp:include page="../includes/technav.jsp" />
     
<div class="form-group container">
    	<form:form method="POST" modelAttribute="rapport">
    		<div class="mt-2 mb-2" >
			<form:input path="nomRapport" id="nomRapport" class="form-control" placeholder="Nom Rapport" />
	        <form:errors path="nomRapport" cssClass="error"/>
	        </div>
	        <div class="mt-2 mb-2">
			<form:textarea path="descRapport" id="descRapport" class="form-control" placeholder="Description Rapport" />
	        <form:errors path="descRapport" cssClass="error"/>
	        </div>
	        <div class="mt-2 mb-2" style="float:right;">
	        <input type="submit" value="Envoyer" class="btn btn-success"/>
	        </div>
	        
        </form:form>
    </div>
</body>
</html>