<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
 	<title>Page de connexion</title>
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

	<div style="padding-top: 40px;">

		<h2>Veuillez renseigner votre login et mot de passe</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='/login' />" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
				  value="submit" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>