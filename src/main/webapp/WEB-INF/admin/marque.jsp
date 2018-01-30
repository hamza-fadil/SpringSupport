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
 <div class="form-group">
    <form:form method="POST" modelAttribute="marque">
				<div class="form-control">
                <form:input class="form-control" path="nomMarque" id="nomMarque" placeholder="Marque"/>
                <form:errors path="nomMarque" cssClass="error"/>
                </div>
               <div class="form-control">
			                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Mettre à jour" class="btn btn-success"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Ajouter" class="btn btn-success"/>
                        </c:otherwise>
                    </c:choose>    
                    </div> 
    </form:form>
</div>
    <br/>
    <br/>
    	<br>
</body>
</html>