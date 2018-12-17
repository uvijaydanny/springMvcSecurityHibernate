<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
	<title>Show Data</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	<h2>${formStudent.firstName}</h2>
	<br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value = "Logout" />
	</form:form>
</body>

</html>