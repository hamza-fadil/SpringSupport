
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ include file = "header.jsp" %> --%>
<html>
 	
<head>
    <meta http-equiv="Content-Type" content="text/html;">  
    <title>Add User</title>
 
<style>
 	
    .error {
        color: #ff0000;
    }
    
</style>

</head>




<head>
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
 </head>
 

<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
	  
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

	<ul class="nav navbar-nav navbar-right">
        <li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Register</a></li>
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login </a></li>
    </ul>
    </div>
  </div>
</nav>

 



<%-- 	<form name="changePassword" action="/admin/password/change" method="POST" > --%>
<!--     <ul> -->
<!--         <li><label>User:</label> <input type='password' path="password" name='j_username' /></li> -->
        
<!--     </ul> -->
<%-- </form> --%>
  	<div class="alert alert-info clearfix" style="margin-top:-20px">
		<a  class="alert-link" style="font-size:50px">What's My Password?</a>
	</div>
	                            <c:if test="${success!= null}">
                             	<div class="alert alert-success">
                                    <p>${success}</p>
<!--                                     . This method works 24 hours a day -->
                                </div>
           					</c:if>
<form:form name="forgotPassword" class="form-horizontal" action="/forgotPassword" method="post">


    <div class="alert alert-warning">
    <strong>Warning!</strong> If you have forgotten your password you can reset it here
  </div>
  		
    <div class="form-group">
		<label class="col-md-4 control-label">Email</label>
		<div class="col-md-4  inputGroupContainer">
			<div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
			     <input type="email" placeholder="Email" class="form-control" name="email"  id="email"/>
			</div>
		</div>
	</div>
    			
    
    
    <div class="form-group">
		     	
		<label class="col-md-3 control-label"></label>
		<label class="col-md-4 control-label"></label>
		<div class="col-md-5">
			<button type="submit" class="btn btn-primary">
  				<i class="glyphicon glyphicon-refresh"> </i> Change
			</button>
		</div>
    </div>
</form:form>
    
    
    
<!--    	<script src="../../webjars/jquery/1.9.1/jquery.min.js"></script> -->
<!-- 	<script src="../../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->


<!-- <script> -->

<!-- </script> -->

	   	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
