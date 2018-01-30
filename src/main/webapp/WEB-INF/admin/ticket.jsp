<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
<div class="container">
<div class="form-group">
    	<form:form method="POST" modelAttribute="ticket">
    		<div class="form-control">
			<form:input path="titreTicket" id="titreTicket" class="form-control" placeholder="Titre" required="true" />
	        <form:errors path="titreTicket" cssClass="error"/>
	        </div>
	        
	        <div class="form-control" >
	        <form:select path="typeTicket" class="form-control" required="true">
	        		<option value="" disabled="true" selected="true">Type de ticket</option>      
	           		<form:option value="M" >Materiel</form:option>
	           		<form:option value="L">Logiciel</form:option>
            </form:select>
            </div>
			<div class="form-control" >
	        <form:select path="etatTicket" class="form-control" required="true">
	           		<form:option value="open" selected="true" >Ouvert</form:option>
            </form:select>
            </div>
			<div class="form-control">
	        <form:textarea path="contTicket" id="contTicket" rows="5" class="form-control" placeholder="Contenu du ticket" required="true"/>
	        <form:errors path="contTicket" cssClass="error"/>
	        </div>
			<br>
	        <input style="float:right;" type="submit" value="Envoyer" class="btn btn-success"/>

        </form:form>
    </div>
</div>
<jsp:include page="../includes/footer.jsp" />
</body>
</html>