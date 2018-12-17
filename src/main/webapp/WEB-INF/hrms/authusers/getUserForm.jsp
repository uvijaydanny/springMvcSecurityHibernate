<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/hrms/staticContent/metaInfo.html" %>
</head>
<body>
<div class="container-fluid">
<%@ include file="/WEB-INF/hrms/staticContent/staticHeader.html" %> 
<div style="margin-top:75px;">
<h3 style="text-align:center">User Registration</h3>
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6 animated fadeIn">
	<form:form autocomplete="off" action="${pageContext.request.contextPath}/addUser" method="POST" modelAttribute="j_userauth">
	<table>
		<tr>
			<th>User Name:</th>
			<td><form:input path="username" autocomplete="off"/>
			<form:errors cssClass="error" path="username"/></td>
		</tr>
		<tr>
			<th>Password:</th>
			<td><form:password path="password"  autocomplete="off"/>
			<form:errors cssClass="error" path="password"/></td>
		</tr>
		<tr>
			<th>Email Id:</th>
			<td><form:input path="emailid" autocomplete="off"/>
			<form:errors cssClass="error" path="emailid"/></td>
		</tr>
		<tr>
		<th>ROLES</th>
		<td> 
		<form:select path="roles">
			<form:option value=""/>
			<form:option value="ADMIN" />
			<form:option value="MANAGER" />
			<form:option value="HR" />
		</form:select> </td>
		</tr>
		<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
		
	</table>
	</form:form>
	
	</div>
	<div class="col-md-3"></div>
</div>
</div>
</div>
</body>
</html>