<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="staticContent/metaInfo.html" %>
<style>
/* body {
	background-image: url("<c:url value="/resources/img/testimg.jpg"/>");
	background-repeat: no-repeat;
	background-size: cover;
} */
</style>
</head>
<body>
<div class="container">
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4 animated fadeIn" style="background-color:white;margin-top:15%; padding:25px 100px; opacity:0.8; border-radius:15px;">
		<h2 style="text-align:center" class="animated jello">Login</h2>
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" autocomplete="off">
		<div class="form-group">
		<label for="username">User Id:</label>
		<input type="text" class="form-control" name="username" id="username" placeholder="Enter user name" autocomplete="off"/>
		</div>
		<div class="form-group">
		<label for="password">Password: </label>
		<input type="password" name="password" class="form-control" id="password" placeholder="Enter password" autocomplete="off"/>
		</div>
		<input type="submit" value="Login" />
		</form:form>
			<c:if test="${param.error != null}">
			<i class="error animated jello">Invalid Login Details</i>
			</c:if>
			<c:if test="${param.logout != null}">
			<i class="error animated jello">Logout Successful</i>
			</c:if>
	</div>
	</div>
	<div class="col-md-4"></div>
</div>
</body>
</html>