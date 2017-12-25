<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
User : ${pageContext.request.userPrincipal.name}
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<a href="<c:url value='/login' />">Login</a>
	<br>
<a href="<c:url value='/users' />">Utilisateurs</a>
	<br>
	<a href="<c:url value='/tickets' />">Tickets</a>
	<br>
	<a href="<c:url value='/fichiers' />">Fichiers</a>
	<br>	
	<a href="<c:url value='/ordinateurs' />">Ordinateurs</a>
	<br>
	<a href="<c:url value='/materiels' />">Materiels</a>
	<br>
	<a href="<c:url value='/marques' />">Marques</a>
	<br>
	<a href="<c:url value='/conversations' />">Conversations</a>
	<br>
	<a href="<c:url value='/telephones' />">Telephones</a>
	<br>
	<a href="<c:url value='/imprimantes' />">Imprimantes</a>
	<br>
	<a href="<c:url value='/' />">Index</a>
	<br>
	<br>
	<sec:authorize access="hasAuthority('Administrateur')">
		<!-- For login user -->
		<c:url value="/login?logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>
</body>
</html>