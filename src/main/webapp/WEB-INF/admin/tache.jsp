<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
   <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
 
<body>
 <jsp:include page="../includes/adminnav.jsp" />
     
<div class="form-group">
    	<form:form method="POST" modelAttribute="tache">
    		<div class="form-control">
			<form:input path="nomTaches" id="nomTaches" class="form-control" placeholder="Nom Tache" />
	        <form:errors path="nomTaches" cssClass="error"/>
	        </div>
	        
	        <div class="form-control" >
	        <form:select path="user" class="form-control" required="true">
	        		<c:forEach items="${users}" var="p">
               		<form:option value="${p.idUser}">${p.username}</form:option>
               		</c:forEach>
            </form:select>
            </div>
            
			<div class="form-control">
	        <form:textarea path="descTaches" id="descTaches" rows="5" class="form-control" placeholder="Description de la tache"/>
	        <form:errors path="descTaches" cssClass="error"/>
	        </div>
	        <div class="form-control ">
	        <input type="submit" value="Envoyer" class="btn btn-success"/>
	        </div>
	        
        </form:form>
    </div>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/admin/ticket' />">Liste de tous les tickets</a>
</body>
</html>