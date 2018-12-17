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
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-9 animated fadeIn" style="overflow-x:auto;">
	<table  class="table table-bordered">
		<tr>
			<th>User Name</th>
			<th>Email Id</th>
			<th>Role</th>
		</tr>
		<c:forEach items="${j_userlist}" var="userlist">
		<tr>
			<td>${userlist.username}</td>
			<td>${userlist.emailid}</td>
			<td>${userlist.roles}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<div class="col-md-1">
	</div>
</div>
</div>
</body>
</html>