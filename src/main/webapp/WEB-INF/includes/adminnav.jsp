<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.dropdown:hover>.dropdown-menu {
  display: block;
}

</style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark nav-tabs nav-justified ">
	<ul class="navbar-nav mr-auto">
		<li><a href="/admin/index" class="nav-link">Index</a></li>
		<li><a href="/admin/ticket" class="nav-link">Tickets</a></li>
		<li><a href="/admin/users" class="nav-link">Utilisateurs</a></li>
		<li><a href="/admin/taches" class="nav-link">Taches</a></li>
		<li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="/admin/parcs" id="navbardrop" data-toggle="dropdown">
		        Parc informatique
		      </a>
		      <div class="dropdown-menu bg-dark">
		        <a class="dropdown-item bg-dark" style="color:white;" href="/admin/ordinateurs">Ordinateurs</a>
		        <a class="dropdown-item bg-dark" style="color:white;" href="/admin/telephones">Telephones</a>
		        <a class="dropdown-item bg-dark" style="color:white;" href="/admin/imprimantes">Imprimantes</a>
		        <a class="dropdown-item bg-dark" style="color:white;" href="/admin/marques">Marques</a>
		      </div>
    	</li>
		<li><a href="/admin/newsletter" class="nav-link">Newsletter</a></li>
		<li><a href="/admin/report" class="nav-link">Rapports</a></li>
	</ul>
	<c:choose >
		<c:when test="${not empty username}">
    		<ul class="nav justify-content-end">
    		<li>
    				  <input class="form-control float-right" id="myInput" type="text" placeholder="Rechercher">
    		
    		</li>
        		<li class="nav-item dropdown">
				      <a class="nav-link dropdown-toggle" style="color:white;"  id="navbardrop" data-toggle="dropdown">
				        ${username }
				      </a>
				      <div class="dropdown-menu bg-dark">
				        <a class="dropdown-item bg-dark" style="color:white;" href="/admin/changemdp">Changer mot de passe</a>
				      </div>
    			</li>
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