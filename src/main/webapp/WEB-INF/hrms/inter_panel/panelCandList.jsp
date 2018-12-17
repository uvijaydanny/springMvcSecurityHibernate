<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/hrms/staticContent/metaInfo.html" %>
<script type="text/javascript">
$(document).on("click", ".open-dialog", function () {
	var strToSplit = $(this).data('book-id');
	var arrayOfSplit = strToSplit.split("-");
	var inId = arrayOfSplit[0];
	
	var intrId = arrayOfSplit[0]+arrayOfSplit[1];
    var cid = 'cid' + intrId;
    var cn = 'cn' + intrId;
    var ir = 'ir' + intrId;
    var ep = 'ep' + intrId;
    var cm = 'cm' + intrId;
    var rt = 'rt' + intrId;
    var is = 'is' + intrId;
    var cid_data = document.getElementById(cid).innerHTML;
    var cn_data = document.getElementById(cn).innerHTML;
    var ir_data = document.getElementById(ir).innerHTML;
    var ep_data = document.getElementById(ep).innerHTML;
    var cm_data = document.getElementById(cm).innerHTML;
    var rt_data = document.getElementById(rt).innerHTML;
    var is_data = document.getElementById(is).innerHTML;
    document.getElementById("td_cId").innerHTML = cid_data;
    document.getElementById("td_cn").innerHTML = cn_data;
    document.getElementById("td_ir").innerHTML = ir_data;
    document.getElementById("td_exp").innerHTML = ep_data;
    $(".modal-body #intrPanelId").val( inId );
    $(".modal-body #candidateId").val(cid_data);
    $(".modal-body #candidateName").val(cn_data);
    $(".modal-body #interviewRound").val(ir_data);
    $(".modal-body #experience").val(ep_data);
    $(".modal-body #comments").val(cm_data);
    $(".modal-body #rating").val(rt_data);
    $(".modal-body #iStatus").val(is_data);
});

$(function() {
    $('#interviewRound').change(function() {
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
    td = tr[i].getElementsByTagName("td")[1];
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
<%@ include file="/WEB-INF/hrms/staticContent/staticHeader.html" %>  
<div class="row">
	<div class="col-md-2">
	</div>
	<div class="col-md-10 animated fadeIn"  style="overflow-x:auto;">
	<form>
	Find Candidate Names: <br><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
	<br><br>
		Interview Round:<br>
			<security:authentication property="principal.username" var="panel"/>
			<form:form action="${pageContext.request.contextPath}/intrPanel/candList" 
						method="GET" modelAttribute="j_panel">
				<form:select path="interviewRound">
					<form:option value="ALL"/>
					<form:option value="Telephone"/>
					<form:option value="Technical1"/>
					<form:option value="Technical2"/>
					<form:option value="Managerial"/>
					<form:option value="HR"/>
				</form:select>
				<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_HR')" var="isAdmin" />
				<c:choose>
					<c:when test="${isAdmin}">
					<form:hidden path="panel" value="ALL"/>
					</c:when>
					<c:otherwise>
					<form:hidden path="panel" value="${panel}"/>
					</c:otherwise>
				</c:choose>
			</form:form>
			<br>
		</form>
	<table id="myTable">
	<tr>
		<th>Candidate Id</th>
		<th>Candidate Name</th>
		<th>Interview Round</th>
		<th>Experience</th>
		<th>Rating</th>
		<th>Status</th>
		<th>Add Review</th>
	</tr>
	<c:forEach items="${j_panelList}" var="panelList">
	<tr>
				<td id="cid${panelList.intrPanelId}${panelList.interviewRound}">${panelList.candidateId}</td>
				<td id="cn${panelList.intrPanelId}${panelList.interviewRound}">${panelList.candidateName}</td>
				<td id="ir${panelList.intrPanelId}${panelList.interviewRound}">${panelList.interviewRound}</td>
				<td id="ep${panelList.intrPanelId}${panelList.interviewRound}">${panelList.experience}</td>		
				<td id="cm${panelList.intrPanelId}${panelList.interviewRound}" hidden="true">${panelList.comments}</td>
				<td id="rt${panelList.intrPanelId}${panelList.interviewRound}">${panelList.rating}</td>
				<c:if test="${panelList.iStatus == 'Pass'}">
				<td style="color:green;" id="is${panelList.intrPanelId}${panelList.interviewRound}">${panelList.iStatus}</td>
				</c:if>
				<c:if test="${panelList.iStatus != 'Pass'}">
				<td id="is${panelList.intrPanelId}${panelList.interviewRound}">${panelList.iStatus}</td>
				</c:if>
				<c:choose>
					<c:when test="${panelList.interviewRound == 'Telephone'}">
						<td><a href="#myModal" data-toggle="modal" data-book-id="${panelList.intrPanelId}-${panelList.interviewRound}" class="open-dialog">Review</a></td>	
					</c:when>
					<c:when test="${panelList.interviewRound == 'Technical1' && panelList.prvStatus > 0}">
						<td><a href="#myModal" data-toggle="modal" data-book-id="${panelList.intrPanelId}-${panelList.interviewRound}" class="open-dialog">Review</a></td>	
					</c:when>
					<c:when test="${panelList.interviewRound == 'Technical2' && panelList.prvStatus > 0}">
						<td><a href="#myModal" data-toggle="modal" data-book-id="${panelList.intrPanelId}-${panelList.interviewRound}" class="open-dialog">Review</a></td>	
					</c:when>
					<c:when test="${panelList.interviewRound == 'Managerial' && panelList.prvStatus > 0}">
						<td><a href="#myModal" data-toggle="modal" data-book-id="${panelList.intrPanelId}-${panelList.interviewRound}" class="open-dialog">Review</a></td>	
					</c:when>
					<c:when test="${panelList.interviewRound == 'HR' && panelList.prvStatus > 0}">
						<td><a href="#myModal" data-toggle="modal" data-book-id="${panelList.intrPanelId}-${panelList.interviewRound}" class="open-dialog">Review</a></td>	
					</c:when>
					<c:otherwise>
						<td style="color:orange;">Pending Previous Review</td>
					</c:otherwise>
				</c:choose>
				
				
				</tr>
		</c:forEach>
	</table>
	</div>
	<!-- Trigger the modal with a button -->
  

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:red;"><span class="glyphicon glyphicon-screenshot"></span> Review</h4>
        </div>
        <div class="modal-body">
          <form:form action="${pageContext.request.contextPath}/intrPanel/addReview" modelAttribute="j_panel">
          	<form:hidden path="intrPanelId" id="intrPanelId"/>
          	<form:hidden path="panel" value="${panel}"/>
          	<form:hidden path="candidateId" id="candidateId"/>
          	<form:hidden path="candidateName" id="candidateName"/>
          	<form:hidden path="interviewRound" id="interviewRound" />
          	<form:hidden path="experience" id="experience" />
          	<table>
          <tr>
          <td>Candidate ID</td>
          <td id="td_cId">
          </td>
          <td>Candidate Name</td>
          <td id="td_cn"></td>
          </tr>
          <tr>
          <td>Interview Round</td>
          <td id="td_ir"></td>
          <td>Experience</td>
          <td id="td_exp"></td>
          </tr>
          </table>
          <table>
          <tr>
          <td>Comments</td>
          <td><form:textarea rows="5" cols="50" path="comments" id="comments" required="true"/></td></tr>
          <tr>
          <td>Rating</td>
          <td>
          <form:select path="rating" required="true">
          	<form:option value="1"/>
          	<form:option value="2"/>
          	<form:option value="3"/>
          	<form:option value="4"/>
          	<form:option value="5"/>
          </form:select>
          </td>
          </tr>
          <tr>
          <td>Status</td>
          <td>
          <form:select path="iStatus" required="true">
          	<form:option value="Pass"/>
          	<form:option value="Fail"/>
          </form:select>
          </td>
          </tr>
          <tr>
          <td colspan="2">
            <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Submit</button>
           </td></tr>
            </table>
          </form:form>
        </div>
        <div class="modal-footer">
        </div>
      </div>
    </div>
  </div> 
</div>
</div>
</body>
</html>