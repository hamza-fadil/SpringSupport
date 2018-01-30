<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.dropdown:hover>.dropdown-menu {
  display: block;
}
.navbar-default .navbar-nav > li > a:hover, .navbar-default .navbar-nav > li > a:focus {
    background-color: transparent;
    border-color:pink;
    color: #FFC0CB;
}

</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<nav class="navbar navbar-default navbar-expand-md navbar-light bg-warning fixed-top nav-tabs nav-justified ">
	<ul class="navbar-nav mr-auto">
		<li><a href="/tech/index" class="nav-link">Index</a></li>
		<li><a href="/tech/ticket" class="nav-link">Tickets</a></li>
		<li><a href="/tech/taches" class="nav-link">Taches</a></li>
		<li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="/tech/parcs" id="navbardrop" data-toggle="dropdown">
		        Parc informatique
		      </a>
		      <div class="dropdown-menu bg-warning">
		        <a class="dropdown-item bg-warning" href="/tech/ordinateurs">Ordinateurs</a>
		        <a class="dropdown-item bg-warning" href="/tech/telephones">Telephones</a>
		        <a class="dropdown-item bg-warning" href="/tech/imprimantes">Imprimantes</a>
		        <a class="dropdown-item bg-warning" href="/tech/marques">Marques</a>
		      </div>
    	</li>
		<li><a href="/tech/report" class="nav-link">Rapports</a></li>
	</ul>
	<c:choose >
		<c:when test="${not empty username}">
    		<ul class="nav justify-content-end">

        		<li class="nav-item dropdown">
				      <a class="nav-link dropdown-toggle "  id="navbardrop" data-toggle="dropdown">
				        ${username }
				      </a>
				      <div class="dropdown-menu dropdown-menu-left bg-warning">
				        <a class="dropdown-item bg-warning"  href="/tech/changemdp">Changer mot de passe</a>
				        <a href="logout" class="dropdown-item bg-warning">Se déconnecter</a>
				      </div>
    			</li>
        		    		<li>
    				  <input class="form-control float-right" id="myInput" type="text" placeholder="Rechercher">
    		
    		</li>
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