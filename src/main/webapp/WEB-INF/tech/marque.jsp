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
 <jsp:include page="../includes/technav.jsp" />   
 <div class="form-group">
    <form:form method="POST" modelAttribute="marque">
				<div class=" container">
                <form:input class="form-control" path="nomMarque" id="nomMarque" placeholder="Marque"/>
                <br>
                <input type="submit" value="Mettre à jour" class="btn btn-success" style="float:right;"/>
                </div>
                            
    </form:form>
</div>
    <br/>
    <br/>
    	<br>
</body>
</html>