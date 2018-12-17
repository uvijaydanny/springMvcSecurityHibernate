<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>luv2code Company Home Page</title>
</head>
<style>
.error {color:red;}
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript">
      $(function() {
          $('#idDateField').datepicker();
      });
  </script>
<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	Welcome to the home page! 
	LogIn User <security:authentication property="principal.username" var="useridval"/><br>
	Cout value: <c:out value = "${useridval}"/>
	<security:authentication property="principal.authorities"/><br>
	<form:form action="showData" method="post" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
	</form:form>
	<security:authorize access="hasRole('MANAGER')">
	<a href="${pageContext.request.contextPath}/leaders">Manager List</a><br>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/systems">Admin List</a>
	</security:authorize>
	<br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>