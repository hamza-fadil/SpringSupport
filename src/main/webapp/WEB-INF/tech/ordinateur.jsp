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
    <form:form method="POST" modelAttribute="ordinateur">
        <form:input type="hidden" path="idMateriel" id="idMateriel" class="form-control"/>
				<div class="form-control">
                <form:input class="form-control" path="espaceDisque" id="espaceDisque" placeholder="Espace disque"/>
                <form:errors path="espaceDisque" cssClass="error"/>
                </div>
                <div class="form-control">      
                <form:input class="form-control" path="processeur" id="processeur" placeholder="Processeur"/>
                <form:errors class="form-control"  path="processeur" cssClass="error"/>
                </div>
                <div class="form-control">            
                <form:input class="form-control" path="ram" id="ram" placeholder="RAM"/>
                <form:errors class="form-control" path="ram" cssClass="error"/>
                </div>
                <div class="form-control">   
                <form:input class="form-control" path="systemeExploitation" id="systemeExploitation" placeholder="Système exploitation"/>
                <form:errors path="systemeExploitation" cssClass="error"/>
                </div>
                <div class="form-control">   
                <form:input class="form-control" path="serieMateriel" id="serieMateriel" placeholder="Serie du materiel"/>
                <form:errors path="serieMateriel" cssClass="error"/>
                </div>
                <div class="form-control">   
                <form:select path="marque" class="form-control" required="true">
		               <option value="" disabled="true" selected="true">Choisissez une marque</option>         	
		               <c:forEach items="${marques}" var="p">
		               		<form:option value="${p.idMarque}">${p.nomMarque}</form:option>
               			</c:forEach>
               </form:select>
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