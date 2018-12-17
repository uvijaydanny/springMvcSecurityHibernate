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
</head>
<body>
<div class="container-fluid">
<%@ include file="staticContent/staticHeader.html" %>  
<h3 style="text-align:center;">Candidate Form</h3>
<div class="row">
	<div class="col-md-3">
	</div>
	<div class="col-md-6" class="animated fadeIn">
<form:form action="${pageContext.request.contextPath}/candidate/addCandidate" method="POST" modelAttribute="cdata" autocomplete="off">
<form:hidden path="candidateId"/>
<table>
	<tr>
		<td>
	Job Name ID:
	</td>
	<td> 
	<form:input path="jobreqid" readonly="true" autocomplete="off"/>
	<form:errors path="jobreqid" cssClass="error"/>
	</td>
	</tr>
	<tr>
	<td>
	First Name*:
	</td> 
	<td><form:input path="firstName"  autocomplete="off"/>
	<form:errors path="firstName" cssClass="error"/>
	</td>
	</tr>
	<tr>
	<td>
	Last Name:
	</td>
	<td> 
	<form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" autocomplete="off"/>
	</td>
	</tr>
	<tr>
	<td>
	Email Id:
	</td>
	<td> 
	<form:input path="emailId"  autocomplete="off"/>
	<form:errors path="emailId" cssClass="error"/>
	</td>
	</tr>
	<tr>
	<td>
	Mobile:
	</td>
	<td> 
	<form:input path="telephone"  autocomplete="off"/>
	<form:errors path="telephone" cssClass="error"/>
	</td>
	</tr>
	<tr>
	<td>
	Candidate on Hold:
	</td>
	<td> 
	<form:select path="onHold">
		<form:option value=""></form:option>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="onHold" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Telephone Interview Status:
	</td>
	<td> 
	<form:select path="telStatus">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="telStatus" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Technical_1 Status:
	</td>
	<td> 
	<form:select path="tech1Status">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="tech1Status" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Technical_2 Status:
	</td>
	<td> 
	<form:select path="tech2Status">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="tech2Status" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Managerial Status:
	</td>
	<td> 
	<form:select path="mgrStatus">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="mgrStatus" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	HR Status:
	</td>
	<td> 
	<form:select path="hrStatus">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="hrStatus" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Offer Released:
	</td>
	<td> 
	<form:select path="ofrRls">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="ofrRls" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Offer Accepted:
	</td>
	<td> 
	<form:select path="ofrAccept">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="ofrAccept" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Background Verification:
	</td>
	<td> 
	<form:select path="bckgVerify">
		<form:option value=""/>
		<form:options items="${cdata.yesno}"/>
	</form:select>
	<form:errors path="bckgVerify" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
	<td>
	Join Date:
	</td>
	<td> 
	<form:input path="joinDate" id="idDateField"/>
	<form:errors path="joinDate" cssClass="error"/>
	</td>
	</tr>
	
	<tr>
		<td></td><td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form:form>
	</div>
	<div class="col-md-3"></div>
</div>
</div>
</body>
</html>