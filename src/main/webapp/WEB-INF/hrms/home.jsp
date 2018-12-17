<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="staticContent/metaInfo.html" %>  
  <script type="text/javascript">
      $(function() {
          $('#idDateField').datepicker();
      });
  </script>
  <style>
  .errors {color: red; }
  </style>
</head>
<body>
<div class="container-fluid">
<%@ include file="staticContent/staticHeader.html" %>
<h3 style="text-align:center;">Create Job Request</h3>  
<form:form action="${pageContext.request.contextPath}/create" method="POST" modelAttribute="jobreq" autocomplete="off">
<table class="animated fadeIn">
<tr>
<td>Department: </td>
<td>
<form:select path="reqDept">
	<form:options items="${jobreq.department}"/>
</form:select>
<form:errors path="reqDept" cssClass="error"/>
</td>
</tr>
<tr>
<td>Position: </td>
<td><form:input path="posTitle" autocomplete="off"/>
<form:errors path="posTitle" cssClass="error"/>
</td>
</tr>
<tr>
<td>Job Description: </td>
<td><form:input path="jobDesc" autocomplete="off"/>
<form:errors path="jobDesc" cssClass="error"/>
</td>
</tr>
<tr>
<td>Job Responsibilities: </td>
<td><form:input path="jobResp" autocomplete="off"/>
<form:errors path="jobResp" cssClass="error"/>
</td>
</tr>
<tr>
<td>Job Skills: </td>
<td><form:input path="skills" autocomplete="off"/>
<form:errors path="skills" cssClass="error"/>
</td>
</tr>
<tr>
<td>Education: </td>
<td><form:input path="reqEdu" autocomplete="off"/>
<form:errors path="reqEdu" cssClass="error"/>
</td>
</tr>
<tr>
<td>Job Experience: </td>
<td><form:input path="jobExp" autocomplete="off"/>
<form:errors path="jobExp" cssClass="error"/>
</td>
</tr>
<tr>
<td>Vacancies: </td>
<td>
<form:select path="vacancies">
	<c:forEach var="tempVac" begin="0" end="100" >
	<form:option value="${tempVac}" />
	</c:forEach>
</form:select>
<form:errors path="vacancies" cssClass="error"/>
</td>
</tr>
<tr>
<td>Date Requested:</td>
<td><form:input path="reqDate"  id="idDateField"/></td>
<form:errors cssClass="errors" path="reqDate"/>
</tr>
<tr>
<td>Employment Type:</td>
<td><form:select path="empType">
	<form:option value="Permanent" />
	<form:option value="Contract" />
</form:select>
</td>
<form:errors cssClass="errors" path="empType"/>
</tr>
<tr>
<td>Comments: </td>
<td><form:textarea path="comments"/></td>
</tr>
<tr>
<td></td><td><input type="submit" value="SUBMIT" /></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>