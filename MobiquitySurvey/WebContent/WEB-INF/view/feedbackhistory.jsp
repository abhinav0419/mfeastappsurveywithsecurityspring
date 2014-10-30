<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page-header">
  <h1>Feedback History</h1>
</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><b>Feedback Detail</b></h3>
            
        </div>
        <div class="panel-body">
        <div class="table-responsive">
           <table class="table table-hover">
  				<tr>
  				<td><b>Survey Id</b></td>
  					<td><b>Survey Name</b></td>
  					<!-- <td><b>Survey Type</b></td> -->
  					
  					<td><b>Survey Description</b></td>
  					<td><b>Created Date</b></td>
  					<td><b>Survey Status</b></td>
  					<td><b>Edit</b></td>
  					<td><b>Report</b></td>
  				</tr>
  				<c:forEach var="list" items="${allFeedbackList}">
  				<tr>
  				<td>${list.surveyId}</td>
  					<td>${list.surveyName}</td>
  					<%-- <td>${list.surveyType}</td> --%>
  					
  					<td>${list.surveyDescription}</td>
  					<td>${list.createdDate}</td>
  					
  					<td>
  					
				<c:if test="${list.openSurveyFlag eq false}">
				<span class="label label-danger">Closed</span>
  							
  				</c:if>
  					<c:if test="${list.openSurveyFlag eq true}">
  					
  					<span class="label label-success">Open</span>
  							
  					</c:if>
				 
  					<%-- </form> --%>
				</td>
					<td>
				
				 <a  id="${list.surveyId}" class="btn btn-primary editButton">Edit</a>
  				
  				</td>
  				<td>
				
				 <a  id="${list.surveyId}" class="btn btn-primary reportButton">Report</a>
  				
  				</td>
  				</tr>	
  				</c:forEach>
			</table>
			</div>
        </div>
    </div>
     <script type="text/javascript">
    $(".editButton").click(function() {
		
		var id = $(this).attr('id');
		$("#mainContent").load("editfeedbacksurvey/?surveyId="+id);
	});
    
$(".reportButton").click(function() {
		
		var id = $(this).attr('id');
		$("#mainContent").load("feedbackreport/?surveyId="+id);
	});
    </script>
</body>
</html>