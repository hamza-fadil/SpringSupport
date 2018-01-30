<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<head>
<style>
div.container {
background-color: #ffffff;
}
div.container p {
font-family: Arial;
font-size: 16px;
font-style: normal;
font-weight: normal;
text-decoration: none;
text-transform: none;
color: #000000;
background-color: #ffffff;
}
</style>
 	<title>A propos</title>
	<jsp:include page="includes/head.jsp" />
</head>
<body>
<jsp:include page="includes/nav.jsp" />




<div class="container">
<h1>A propos</h1><br>
<p>Cette application à été faite pendant la session <i>Automne 2017</i> sous la tutelle du professeur <strong>FASSALI Tarik</strong>, par <strong>FADIL Hamza</strong>.</p>
<p><i>Spring MVC</i>, <i>Hibernate</i>, <i>HTML5</i> et <i>Bootstrap</i> ont tous été utilisé pour générer le résultat suivant.</p>
<p>Le rapport fourni avec le projet permet de voir plus en détails le fonctionnement du site.</p>
<p>Cordialement, FADIL Hamza</p>
</div>
<jsp:include page="includes/footer.jsp" />
</body>
</html>