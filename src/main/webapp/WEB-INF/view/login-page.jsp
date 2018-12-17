<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {color:red; }
</style>
</head>
<body>
<h1>Login Page</h1>
	<c:if test="${param.error != null}">
	<i class="error">Invalid Login Details</i><br><br>
	</c:if>
	<c:if test="${param.logout != null}">
	<i class="error">Logout Successful</i><br><br>
	</c:if>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		User Id: <input type="text" name="username"/><br><br>
		Password: <input type="password" name="password" /><br><br>
		<input type="submit" value="Login" /><br><br>
	</form:form>
</body>
</html>