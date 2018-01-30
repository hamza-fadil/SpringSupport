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

<nav class="navbar navbar-default navbar-expand-md navbar-dark bg-dark fixed-top nav-tabs nav-justified ">
	<ul class="navbar-nav mr-auto">
		<li><a href="/user/index" class="nav-link">Index</a></li>
		<li><a href="/user/ticket" class="nav-link">Tickets</a></li>
	</ul>
	<c:choose >
		<c:when test="${not empty username}">
    		<ul class="nav justify-content-end">

        		<li class="nav-item dropdown">
				      <a style="color:white;" class="nav-link dropdown-toggle "  id="navbardrop" data-toggle="dropdown">
				        ${username }
				      </a>
				      <div class="dropdown-menu dropdown-menu-left bg-dark">
				        <a style="color:white;" class="dropdown-item bg-dark"  href="/user/changemdp">Changer mot de passe</a>
				        <a style="color:white;" href="logout" class="dropdown-item bg-dark">Se déconnecter</a>
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