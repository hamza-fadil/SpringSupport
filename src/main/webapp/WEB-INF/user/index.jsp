<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Index utilisateur</title>
<jsp:include page="../includes/userhead.jsp" />
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
<jsp:include page="../includes/usernav.jsp" />
	<br><br>
<div class="container">
        <h1>Site de support informatique pour la société X.</h1>
        <br>
        <p>L'application permet de remonter l'information vers le département informatique le plus rapidement possible, en permettant à l'utilisateurs d'avoir accès a un suivi des tickets.</p>
      	<p>Pour ajouter un ticket cliquez <a href="/newTicket">ici</a>.</p>
      	<p>Cordialement, le département informatique.</p>
</div>


<jsp:include page="../includes/footer.jsp" />

</body>
</html>