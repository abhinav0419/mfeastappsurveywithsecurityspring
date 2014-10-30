
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
		<h1>
			Snack Poll 
		</h1>
	</div>
		<c:if test="${not empty requestScope.selection}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Your selection<b> ${requestScope.selection}</b> is saved successfully.
				
				</div>
				</c:if>


	<c:choose>
		<c:when test="${not empty openSurveyList}">
		<c:forEach var="op" items="${openSurveyList}">
				<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<b>${op.surveyName } </b>
			</h3>
		</div>
		<div class="panel-body">
		
				<form action="saveselection">
					<input type="hidden" name="saveId" value="${op.surveyId}" />
					<table class="table table-bordered table-responsive table-hover">
					
			<tr>
				<td><b>Description </b></td><td><c:out value="${op.surveyDescription}" default=" - "></c:out></td></tr>
				<tr><td><b>Jain Option </b></td><td><c:out value="${op.jainOption }" default=" - "></c:out></td></tr>
				<tr><td><b>Regular Option </b></td><td><c:out value="${op.vegOption }" default=" - "></c:out></td></tr>
				<tr><td><b> Choose Option </b></td><td><select name="selection" style="width:150px;">
							<option value = "none">None</option>
							<option value = "veg">Regular</option>
							<option value = "jain">Jain</option>
						</select></td></tr>
						<tr><td colspan="2"><input type="submit" name="cancel" class="btn btn-success"
							value="Save"></input>
							<button name="cancel" value="cancel" class="btn btn-success" id="cancelButton">Cancel</button>
							<c:if test="${appUserRole eq 'ADMIN'}">
						
							
							<a  id="${op.surveyId}" class="btn btn-primary closeSurveyButton">Close Survey</a>
							
					
					</c:if>
							</td>	
						</tr>
						</table>
						</form>

				<div class="form-group">
					
				</div>
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
		$("#mainContent").load("closesurvey/?saveId="+id);
	});
    </script>
</body>
</html>