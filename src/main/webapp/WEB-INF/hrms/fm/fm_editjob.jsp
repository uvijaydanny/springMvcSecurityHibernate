<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="/WEB-INF/hrms/staticContent/metaInfo.html" %>
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
<%@ include file="/WEB-INF/hrms/staticContent/staticHeader.html" %>
<form:form action="${pageContext.request.contextPath}/finmgmt/update" modelAttribute="jobreq" method="POST">
<table class="animated fadeIn">
<tr>
<td>Department: </td>
<td>
<form:input path="reqDept" readonly="true" value="${jobreq.reqDept}"/>
</td>
</tr>
<tr>
<td>Position: </td>
<td><form:input path="posTitle" readonly="true" value="${jobreq.posTitle}"/>
</td>
</tr>
<tr>
<td>Job Description: </td>
<td><form:input path="jobDesc" readonly="true" value="${jobreq.jobDesc}"/>
</td>
</tr>
<tr>
<td>Job Responsibilities: </td>
<td><form:input path="jobResp" readonly="true" value="${jobreq.jobResp}"/>
</td>
</tr>
<tr>
<td>Job Skills: </td>
<td><form:input path="skills" readonly="true" value="${jobreq.skills}"/>
</td>
</tr>
<tr>
<td>Education: </td>
<td><form:input path="reqEdu" readonly="true" value="${jobreq.reqEdu}"/>
</td>
</tr>
<tr>
<td>Job Experience: </td>
<td><form:input path="jobExp" readonly="true" value="${jobreq.jobExp}"/>
</td>
</tr>
<tr>
<td>Vacancies: </td>
<td>
<form:input readonly="true" path="vacancies" value="${jobreq.vacancies}"/>
</td>
</tr>
<tr>
<td>Date Requested:</td>
<td><form:input path="reqDate"  readonly="true" value="${jobreq.reqDate}"/></td>
</tr>
<tr>
<td>Comments: </td>
<td><form:textarea path="comments" readonly="true" value="${jobreq.comments}"/></td>
</tr>
<tr>
<td>Employment Type: </td>
<td>
<form:input readonly="true" path="empType" value="${jobreq.empType}"/>
</td>
</tr>
<tr>
<security:authorize access="hasAnyRole('ROLE_MANAGEMENT','ROLE_FINANCE')">
<td>Update the status</td>
<td>	
	<form:select path="mmstatus" >
		<form:option value="Accept"/>
		<form:option value="Reject" />
	</form:select>
</td>
</security:authorize>
	<form:hidden path="reqId" value="${jobreq.reqId}"/>

</tr>
<tr>
<td colspan="2"><input type="submit" value="Update"/></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>