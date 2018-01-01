<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark nav-tabs nav-justified">
	<ul class="navbar-nav mr-auto">
		<li><a href="/tech/index" class="nav-link">Index</a></li>
		<li><a href="/tech/ticket" class="nav-link">Tickets</a></li>
		<li><a href="/tech/taches" class="nav-link">Taches</a></li>
		<li><a href="/tech/parc" class="nav-link">Parc informatique</a></li>
		<li><a href="/tech/report" class="nav-link">Rapports</a></li>

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