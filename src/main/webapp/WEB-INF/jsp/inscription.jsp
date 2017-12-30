<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 	<title>Page d'inscription</title>
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
		<li><a href="/" class="nav-link">Index</a></li>
		<li><a href="faq" class="nav-link">FAQ</a></li>
		<li><a href="about" class="nav-link">A propos</a></li>
		<li><a href="howto" class="nav-link">Aide</a></li>
	</ul>
	<ul class="nav justify-content-end">
		<li><a href="login" id="login">Connexion </a></li>
		<li><a href="inscription" id="inscription">Inscription</a></li>
	</ul>
</nav>
<br>
<br><br>
<c:if test="${emailDup }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Email dupliqué.
	</div>
</c:if>
<c:if test="${emailInv }">
	<div class="alert alert-danger">
  		<strong>Erreur!</strong> Email invalide.
	</div>
</c:if>
    <form:form method="POST" modelAttribute="user">
        <table>
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="username">Nom d'utilisateur: </label> </td>
                <td><form:input path="username" id="username"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="password">Mot de passe: </label> </td>
                <td><form:input path="password" id="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
               
      
            <tr>
                <td colspan="3">
                            <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>

<table width="100%" border="1" class="footer">
  <tbody>
    <tr>
      <td class="foot"> © 2017 Département des Systèmes de l'Information</td>
    </tr>
  </tbody>
</table>
</body>
</html>
