<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="staticContent/metaInfo.html" %>
</head>
<body>
<div class="container-fluid">
<%@ include file="staticContent/staticHeader.html" %>
<h3 style="text-align:center;">Add Interview Panel</h3> 
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10 animated fadeIn">
		<form:form action="${pageContext.request.contextPath}/intrPanel/updJob" method="POST" modelAttribute="j_intrPanel">
			<table>
				<tr><td>
				Candidate Id:
				</td>
				<td>
				<form:input path="candidateId" readonly="true"/>
				<form:errors cssClass="error" path="candidateId"/>
				</td></tr>
				
				<tr><td>
				Telephone Panel:
				</td>
				<td>
				<form:select path="telPanel" >
					<form:option value=""/>
					<form:options items="${j_ipList}"/>
				</form:select>
				<form:errors cssClass="error" path="telPanel"/>
				</td></tr>
				<tr><td>
				Technical 1 Panel:
				</td>
				<td>
				<form:select path="tech1Panel" >
					<form:option value=""/>
					<form:options items="${j_ipList}"/>
				</form:select>
				<form:errors cssClass="error" path="tech1Panel"/>
				</td></tr>
				<tr><td>
				Technical 2 Panel:
				</td>
				<td>
				<form:select path="tech2Panel" >
					<form:option value=""/>
					<form:options items="${j_ipList}"/>
				</form:select>
				<form:errors cssClass="error" path="tech2Panel"/>
				</td></tr>
				<tr><td>
				Managerial Panel:
				</td>
				<td>
				<form:select path="mgrPanel" >
					<form:option value=""/>
					<form:options items="${j_ipList}"/>
				</form:select>
				<form:errors cssClass="error" path="mgrPanel"/>
				</td></tr>
				<tr><td>
				HR Panel:
				</td>
				<td>
				<form:select path="hrPanel" >
					<form:option value=""/>
					<form:options items="${j_ipList}"/>
				</form:select>
				<form:errors cssClass="error" path="hrPanel"/>
				</td></tr>
				<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
			</table>
			
		</form:form>
	</div>
	<div class="col-md-1"></div>
</div>
</div>
</body>
</html>