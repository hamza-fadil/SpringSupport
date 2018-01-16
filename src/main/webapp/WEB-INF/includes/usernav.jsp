<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.dropdown:hover>.dropdown-menu {
  display: block;
}

</style>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark nav-tabs nav-justified">
	<ul class="navbar-nav mr-auto">
		<li><a href="/user/index" class="nav-link">Index</a></li>
		<li><a href="/user/ticket" class="nav-link">Tickets</a></li>
	</ul>

    		<ul class="nav justify-content-end">
        		<li class="nav-item dropdown">
				      <a class="nav-link dropdown-toggle" style="color:white;" id="navbardrop" data-toggle="dropdown">
				        ${username }
				      </a>
				      <div class="dropdown-menu bg-dark">
				        <a class="dropdown-item bg-dark" style="color:white;" href="/user/changemdp">Changer mot de passe</a>
				      </div>
    			</li>         		<li><a href="logout" class="btn btn-primary btn-danger">Se déconnecter</a></li>
        	</ul>
</nav>