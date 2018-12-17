<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h3> Registration done </h3>
<p>All Users</p>
<table style="width:100%">
<c:forEach var="user" items="${users}">
<tr>
<td>
    <c:out value="${user.name}"/>
</td>
<td>
    <c:out value="${user.emailAddress}"/>
</td>
<td>
    <c:out value="${user.dateOfBirth}"/>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>