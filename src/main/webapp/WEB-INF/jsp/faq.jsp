<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<head>
 	<title>A propos</title>
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
<c:choose >
<c:when test="${not empty username}">
            <div align="right">Bienvenue, ${username }. <a href="logout">Se déconnecter</a></div>
         </c:when>
		
<c:otherwise>
	<div align="right"><a href="login" id="login">Connexion </a> / <a href="inscription" id="inscription">Inscription</a></div>
</c:otherwise>
</c:choose>

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
	<br><br>
<table>
  <tbody>
    <tr>
      <td><p>&nbsp;</p>
        <h1>FAQ</h1>
        <p class="description">L'application permet de remonter l'information vers le département informatique le plus rapidement possible, en permettant à l'utilisateurs d'avoir accès a un suivi des tickets.</p>
        <p>Plus de détails pour l'utilisation du site <a href="howto.html">ici</a>.</p>
      <p>Pour s'inscrire cliquez <a href="inscription">ici</a>, la connexion c'est par <a href="/login">ici</a>.</p>
      <p>Cordialement, le département informatique.</p></td>
    </tr>
  </tbody>
</table>

<table>
  <tbody>
    <tr>
      <td> © 2017 Département des Systèmes de l'Information</td>
    </tr>
  </tbody>
</table>

</body>
</html>