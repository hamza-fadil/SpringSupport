<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
 <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
rel="stylesheet">
<style>

.btn-block {
    display: block;
    width: 27%;
    margin:0px 110px ;

}

.form-control {
    display: block;
    width: 60%;
    }




#login-box {
width: 80%;
padding: 20px;
margin: 90px auto;
background: #fff;
-webkit-border-radius: 2px;
-moz-border-radius: 2px;
border: 1px solid #000;
}

</style>

</head>


<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse"
data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

<ul class="nav navbar-nav navbar-right">
        <li><a href="/registration"><span class="glyphicon
glyphicon-user"></span> Register</a></li>
        <li><a href="login"><span class="glyphicon
glyphicon-log-in"></span> Login </a></li>
    </ul>
    </div>
  </div>
</nav>
  <div class="alert alert-info clearfix" style="margin-top:-20px">
<a  class="alert-link" style="font-size:50px">Confirm</a>
</div>
<form:form name="confirmPassword" action="/confirmPassword" method="post"
class="form-horizontal">
<c:if test="${errorMessage!= null}">
            <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4  inputGroupContainer"
style="margin-top:7px" >
           <div class="alert alert-danger">
           <p>${errorMessage}</p>
           </div>
            </div>
            </div>
            </c:if>
        <input type="hidden" name="token" value="${confirmationToken}" >


        <div class="form-group">
<label class="col-md-4 control-label">Password</label>
<div class="col-md-4  inputGroupContainer">
<div class="input-group"> <span class="input-group-addon"><i
class="glyphicon glyphicon-lock"></i></span>
     <input type="password" placeholder="Password" class="form-control"
name="password"  id="password"/>
</div>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label">ConfirmPassword</label>
<div class="col-md-4  inputGroupContainer">
<div class="input-group"> <span class="input-group-addon"><i
class="glyphicon glyphicon-lock"></i></span>
      <input type="password" placeholder="Confirm Password"
class="form-control" name="confirm_password"  id="confirm_password"/>
<span id='message'></span>
</div>
</div>
</div>
<!-- <div class="form-group"> -->
<!-- <button type="submit" -->
<!--           class="btn btn-primary block full-width m-b">Save -->
<!--         </button> -->
<!-- </div> -->
<div class="form-group">

<label class="col-md-3 control-label"></label>
<label class="col-md-4 control-label"></label>
<div class="col-md-5">

<button type="submit" class="btn btn-primary">
  <i class="glyphicon glyphicon-refresh"> </i> Update
</button>
</div>
    </div>
      </form:form>

    <script src="../../webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>