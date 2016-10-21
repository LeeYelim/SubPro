<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>
<link rel="StyleSheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
<script src="<c:url value='/resources/js/jquery-1.11.2.js'/>"></script>

</head>
<body>
<div class="navbar navbar-default">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="<c:url value='/index.jsp' />">HOME</a>
  </div>
  <div class="navbar-collapse collapse navbar-responsive-collapse">
    <ul class="nav navbar-nav">
      <li><a href="<c:url value='/elec' />">Board</a></li>
      <li><a href="<c:url value='/' />">Ajax</a></li>
      <li><a href="<c:url value='/' />">MyBatis</a></li>
      <li><a href="<c:url value='/' />">Spring</a></li>
     </ul>
     <c:if test="${loginUser != null}">
     <ul class="nav navbar-nav navbar-right">
     	<li class="active"><a href="#">${loginUser}!</a></li>
      	<li><a href="<c:url value='/user/logout'/>" class="btn btn-danger">Logout</a></li>
     </ul>
     </c:if>
  </div>
</div>



