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
    $('#jobname').change(function() {
    	this.form.submit();
    });
});
</script>
<script type="text/javascript">
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script> 
</head>
<body>
<div class="container-fluid">
<%@ include file="staticContent/staticHeader.html" %>  
<h3 style="text-align:center;">Interview Candidates List</h3>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-9 animated fadeIn" style="overflow-x:auto;">
	<form:form id="jobnameId" action="${pageContext.request.contextPath}/candidate/cList" method="GET" modelAttribute="candidate">
		Search First Name: <br><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search names.." title="Type in a name">
		<br><br>
		Job ID:	<br>
		<form:select path="jobname">
			<form:option value="ALL"/>
			<form:options items="${jobreqlist}"/>
		</form:select>
	</form:form>
	<table  class="table table-bordered" id="myTable">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Contact No</th>
			<th>On Hold</th>
			<th>Telephone Interview</th>
			<th>Technical 1</th>
			<th>Technical 2</th>
			<th>Managerial</th>
			<th>HR</th>
			<th>Offer Release</th>
			<th>Offer Accepted</th>
			<th>Background Verification</th>
			<th>Join Date</th>
			<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_HR')">
				<th>Update Panel</th>
				<th>Edit</th>
			</security:authorize>
		</tr>
		<c:forEach items="${clist}" var="canlist">
		<tr>
			<td>${canlist.firstName}</td>
			<td>${canlist.lastName}</td>
			<td>${canlist.emailId}</td>
			<td>${canlist.telephone}</td>
			<td>${canlist.onHold}</td>
			<td>${canlist.telStatus}</td>
			<td>${canlist.tech1Status}</td>
			<td>${canlist.tech2Status}</td>
			<td>${canlist.mgrStatus}</td>
			<td>${canlist.hrStatus}</td>
			<td>${canlist.ofrRls}</td>
			<td>${canlist.ofrAccept}</td>
			<td>${canlist.bckgVerify}</td>
			<td>${canlist.joinDate}</td>	
			<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_HR')">
				<td>
					<c:url var="addIntrPanel" value="/candidate/addIntrPanel">
						<c:param name="candId" value="${canlist.candidateId}"></c:param>
					</c:url>
					<a href="${addIntrPanel}">Update</a>
				</td>
				<td>
					<c:url var="updCandidate" value="/candidate/cUpd">
						<c:param name="candId" value="${canlist.candidateId}"></c:param>
					</c:url>
					<a href="${updCandidate}">Edit</a>
				</td>
			</security:authorize>		
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