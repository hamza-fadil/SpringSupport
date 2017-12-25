<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	<title>Page d'acceuil</title>
	<link rel="stylesheet" type="text/css" href="/style.css">
</head>

            <div align="right">Bienvenue, ${username }. <a href="logout">Se déconnecter</a></div>

<body>
	
	<br><br>
	<table width="100%" border="1">
				<tr>
					<td>
						<a href="/user/index">Index</a>
					</td>
					<td>
						<a href="/user/faq">FAQ</a>
					</td>
					<td>
						<a href="/user/news">Nouveautés</a>
					</td>
					<td>
						<a href="/user/about">A propos</a>
					</td>
					<td>
						<a href="/user/howto"> Comment utiliser l'interface ?</a>
					</td>	
				</tr>		
	</table>
<br><br>
<table width="100%" border="1">
  <tbody>
    <tr>
      <td><p>&nbsp;</p>
        <h1>Site de support informatique pour la société X.</h1>
        <p class="description">L'application permet de remonter l'information vers le département informatique le plus rapidement possible, en permettant à l'utilisateurs d'avoir accès a un suivi des tickets.</p>
        <p>Plus de détails pour l'utilisation du site <a href="howto.html">ici</a>.</p>
      <p>Pour s'inscrire cliquez <a href="inscription">ici</a>, la connexion c'est par <a href="/login">ici</a>.</p>
      <p>Cordialement, le département informatique.</p></td>
    </tr>
  </tbody>
</table>

<table width="100%" border="1">
  <tbody>
    <tr>
      <td> © 2017 Département des Systèmes de l'Information</td>
    </tr>
  </tbody>
</table>

</body>
</html>