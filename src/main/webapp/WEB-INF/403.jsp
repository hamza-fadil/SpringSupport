<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Accès refusé</h1>

	<c:choose>
		<c:when test="${empty username}">
		  <h2>Désolé, vous n'avez pas le droit d'acceder à cette page!</h2>
		</c:when>
		<c:otherwise>
		  <h2>Désolé ${username} <br/>
                    Vous n'avez pas le droit d'acceder à cette page!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>