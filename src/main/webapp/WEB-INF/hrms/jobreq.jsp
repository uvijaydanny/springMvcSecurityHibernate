<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="staticContent/metaInfo.html" %>
  <script type="text/javascript">
  $(function() {
	    $('#jobStatID').change(function() {
	    	this.form.submit();
	    });
	});
  </script>
</head>
<body>
  
<div class="container-fluid">
<%@ include file="staticContent/staticHeader.html" %>
<div style="margin-top:75px">
<h3 style="text-align:center;">Job Requests</h3>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10" class=" animated fadeIn" style="overflow-x:auto;">
	<form:form action="${pageContext.request.contextPath}/listJobReq" method="GET" modelAttribute="jobreq">
	<form:select path="jobstatus" id="jobStatID">
		<form:options items="${jobreq.pendingStatus}" />
	</form:select>
	</form:form>

<table class="table table-bordered animated fadeIn">
<tr>
<th>Requestor Name</th>
<th>Department</th>
<th>Requested Date</th>
<th>Position Title</th>
<th>Job Description</th>
<th>Job Responsibility</th>
<th>Skills</th>
<th>Education</th>
<th>Experience</th>
<th>Comments</th>
<th>Vacancies</th>
<th>Approver 1</th>
<th>Approver 2</th>
<th>Status</th>
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_MANAGER','ROLE_FINANCE','ROLE_MANAGEMENT')">
<th>
Edit
</th>
</security:authorize>

</tr>
<c:forEach items="${jobReq}" var="jobReq">
<tr>
<td>${jobReq.reqName}</td>
<td>${jobReq.reqDept}</td>
<td>${jobReq.reqDate}</td>
<td>${jobReq.posTitle}</td>
<td>${jobReq.jobDesc}</td>
<td>${jobReq.jobResp}</td>
<td>${jobReq.skills}</td>
<td>${jobReq.reqEdu}</td>
<td>${jobReq.jobExp}</td>
<td>${jobReq.comments}</td>
<td>${jobReq.vacancies}</td>
<td>${jobReq.mgrAppr}</td>
<td>${jobReq.finAppr}</td>
<c:choose>
<c:when test="${jobReq.jobstatus == 'APPROVED'}">
<td style="color:green">${jobReq.jobstatus}</td>
</c:when>
<c:when test="${fn:containsIgnoreCase(jobReq.jobstatus,'REJECT')}">
<td style="color:red">${jobReq.jobstatus}</td>
</c:when>
<c:when test="${fn:containsIgnoreCase(jobReq.jobstatus,'Pending')}">
<td style="color:orange">${jobReq.jobstatus}</td>
</c:when>
</c:choose>
<security:authorize access="hasRole('ROLE_ADMIN')">
<td>
<c:url var="updateLink" value="/admin/editjob">
	<c:param name="reqId" value="${jobReq.reqId}"/>
</c:url>
<a href="${updateLink}">Update</a>
</td>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_HR')">
<td>
<c:url var="managerUpd" value="/approver/editjob">
	<c:param name="reqId" value="${jobReq.reqId}"></c:param>
</c:url>
<a href="${managerUpd}">Update</a>
</td>
</security:authorize>
<security:authorize access="hasRole('ROLE_FINANCE')">
<td>
<c:if test="${jobReq.mastatus == 'AP'}">
<c:url var="fin_mgmgt_Upd" value="/finmgmt/editjob">
	<c:param name="reqId" value="${jobReq.reqId}"></c:param>
</c:url>
<a href="${fin_mgmgt_Upd}">Update</a>
</c:if>
</td>
</security:authorize>
<security:authorize access="hasRole('ROLE_MANAGEMENT')">
<c:if test="${jobReq.fastatus == 'AP'}">
<td>
<c:url var="fin_mgmgt_Upd" value="/finmgmt/editjob">
	<c:param name="reqId" value="${jobReq.reqId}"></c:param>
</c:url>
<a href="${fin_mgmgt_Upd}">Update</a>
</c:if>
</security:authorize>
</tr>
</c:forEach>
</table>
</div>
	<div class="col-md-1">
	</div>

</div>
</div>
</div>
</body>
</html>