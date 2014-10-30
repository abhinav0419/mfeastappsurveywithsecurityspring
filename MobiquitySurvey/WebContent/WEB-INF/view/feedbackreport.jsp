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
			Feedback Report <small>selected surveys..</small>
		</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Feedback Details</h3>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-hover">
					<tr>
						<td><b>Sr. No</b></td>
						<td><b>Survey Name</b></td>
						<td><b>Employee Name</b></td>
						<td><b>Feedback</b></td>
					</tr>
					<c:forEach var="list" items="${surveyInfoUIList}"
						varStatus="loopCounter">
						<tr>
							<td><c:out value="${loopCounter.count}" /></td>
							<td>${list.surveyName}</td>
							<td>${list.firstName} ${list.lastName}</td>
							<td>${list.feedback}</td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>