<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
 <head>
 	<title>Administration de tickets</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <base href="/"/>
	<style type="text/css">
		body {
	 		 padding-top: 40px;
			}		li {
			padding-right : 30px;
		}
	</style>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css'>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
 
<body>
 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark nav-tabs nav-justified">
	<ul class="navbar-nav mr-auto">
		<li><a href="/admin/index" class="nav-link">Index</a></li>
		<li><a href="/admin/ticket" class="nav-link">Tickets</a></li>
		<li><a href="/admin/users" class="nav-link">Utilisateurs</a></li>
		<li><a href="/admin/taches" class="nav-link">Taches</a></li>
		<li><a href="/admin/parc" class="nav-link">Parc informatique</a></li>
		<li><a href="/admin/newsletter" class="nav-link">Newsletter</a></li>
		<li><a href="/admin/report" class="nav-link">Rapports</a></li>
		<li><a href="/admin/tests" class="nav-link">Tests</a></li>
	</ul>
	<c:choose >
		<c:when test="${not empty username}">
    		<ul class="nav justify-content-end">
        		<li class="navbar-text" style="color:white;">${username }  </li>
        		<li><a href="logout" class="btn btn-primary btn-danger">Se déconnecter</a></li>
        	</ul>
	    </c:when>
		<c:otherwise>
			<ul class="nav justify-content-end">
				<li><a href="login" id="login">Connexion </a></li>
				<li><a href="inscription" id="inscription">Inscription</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>
     
    <form:form method="POST" modelAttribute="ticket">
        <form:input type="hidden" path="idTicket" id="idTicket"/>
        <table>
            <tr>
                <td><label for="titreTicket">Titre: </label> </td>
                <td><form:input path="titreTicket" id="titreTicket"/></td>
                <td><form:errors path="titreTicket" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="contTicket">Contenu Ticket: </label> </td>
                <td><form:input path="contTicket" id="contTicket"/></td>
                <td><form:errors path="contTicket" cssClass="error"/></td>
            </tr>
			<tr>
                <td><label for="typeTicket">Type Ticket: </label> </td>
                <td><form:input path="typeTicket" id="typeTicket"/></td>
                <td><form:errors path="typeTicket" cssClass="error"/></td>
            </tr>
 <!--               Ajouter un utilisateur par son surnom -->
            <tr>
                <td><label for="user.idUser">Nom d'utilisateur: </label> </td>
                <td><form:input path="user.idUser" id="user.idUser"/></td>
                <td><form:errors path="user.idUser" cssClass="error"/></td>
            </tr>
            <tr>
<%--                 <td><label for="conversation.idConversation">Id conversation: </label> </td>
                <td><form:input path="conversation.idConversation" id="conversation.idConversation"/></td>
                <td><form:errors path="conversation.idConversation" cssClass="error"/></td>
            </tr> --%>
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Revenir <a href="<c:url value='/admin/ticket' />">Liste de tous les tickets</a>
</body>
</html>