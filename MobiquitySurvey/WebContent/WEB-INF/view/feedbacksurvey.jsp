
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page-header">
  <h1>Feedback </h1>
 
				<c:if test="${requestScope.showFeedSelection}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Your feedback is saved successfully..
				
				</div>
				</c:if>
</div>
	
		<c:choose>
			<c:when test="${not empty openFeedbackSurveyList}">
					<c:forEach var="op" items="${openFeedbackSurveyList}">
			<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title"><b><c:out value="${op.surveyName }" default="survey name" ></c:out></b></h3>
		</div>
		<div class="panel-body">
				<form action="savefeedbackselection" method="post">
					<ul class="list-group">
						
						<li class="list-group-item "><b>Description &nbsp;&nbsp;</b>
							${op.surveyDescription }</li>
						
					</ul>


					<input type="hidden" name="saveId" value="${op.surveyId}">
					<div class="form-group">

						<textarea rows="10" class="form-control"  name="suggestion" placeholder="suggestion"></textarea>

					</div>
					<div class="form-group">

						<input class="btn btn-success" name ="cancel" type="submit" value="save">
						<input class="btn btn-success" name ="cancel" type="submit" value="cancel">
							<c:if test="${appUserRole eq 'ADMIN'}">
						
							<a  id="${op.surveyId}" class="btn btn-primary closeSurveyButton">Close Survey</a>
							
					
					</c:if>
				
						
					</div>
				</form>

				
				
					</div>
	</div>
			</c:forEach>
			</c:when>
			<c:otherwise>
					<div class="panel panel-default">
  <div class="panel-heading"><strong>No Survey Open Right Now</strong></div>
  <div class="panel-body">
   
  </div>
</div>

				
			</c:otherwise>
		</c:choose>
			 <script type="text/javascript">
    $(".closeSurveyButton").click(function() {
		
		var id = $(this).attr('id');
		$("#mainContent").load("closefeedsurvey/?saveId="+id);
	});
    </script>
	
</body>
</html>