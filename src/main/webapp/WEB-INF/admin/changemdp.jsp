<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
 
  <head>
 	<title>NewsLetter</title>
	<jsp:include page="../includes/adminhead.jsp" />
</head>
 
<body>
 <jsp:include page="../includes/adminnav.jsp" />

<br>
     
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="idUser" id="idUser"/>
		
            	
            	<div class="form-group mx-5">
                <form:password class="form-control" placeholder="Mot de passe" path="password" id="password" value="${user.password }" required="true"/>
                <form:errors path="password" cssClass="error"/>
            	</div>
                <div class="form-group mx-5">
				<input class="btn btn-success" type="submit" value="Modifier"/>
				</div>
    </form:form>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/admin/users' />">Liste de tous les users</a>
</body>
</html>