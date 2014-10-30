<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>MFeast</title>
<link rel="shortcut icon" href="resource/mob.png">
<!-- Bootstrap Core CSS -->
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="resource/css/plugins/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<!-- Timeline CSS -->
<link href="resource/css/plugins/timeline.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resource/css/sb-admin-2.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="resource/css/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="resource/font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- jQuery Version 1.11.0 -->
<script src="resource/js/jquery-1.11.0.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="resource/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="resource/js/plugins/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="resource/js/sb-admin-2.js"></script>
</head>

<body>
	
	<%-- <c:out value="${validatedUser.userId}"></c:out> --%>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">MFeast</a>
				</div>
				<!-- /.navbar-header -->
				<ul class="nav navbar-top-links navbar-right">
					<!-- /.dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i><i
							class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#" id="uploadPicButton"> <i
									class="fa fa-user fa-fw"></i> Upload Profile Image
									
									
							</a></li>
							<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
									Logout</a></li>
						</ul></li>
				</ul>
				<!-- /.navbar-top-links -->
				<div class="navbar-default sidebar" role="navigation">
					<div class="row">
						<div class="col-md-12">
							<a data-toggle="modal" data-toggle="modal" data-target="#myModal" class="thumbnail">
								<img class="image-rounded img-responsive"
								src="showimg/${userId}" alt="...">
							</a>
						</div>
					</div>
					<div class="navbar-default sidebar" role="navigation">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav" id="side-menu">
							<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
									Create Survey<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="#" id="createFeastPoll"><i
											class="glyphicon glyphicon-cutlery"></i> Feast Poll</a></li>
									<li><a href="#" id="createFeedback"><i
											class="glyphicon glyphicon-text-width"></i> FeedBack</a></li>
								</ul> <!-- /.nav-second-level --></li>
								<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
									Survey<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="#" id="snackSurvey"><i
									class="glyphicon glyphicon-glass"></i> Snack </a></li>
							<li><a href="#" id="feedbackSurvey"><i
									class="glyphicon glyphicon-pencil"></i> FeedBack </a></li>
								</ul> <!-- /.nav-second-level --></li>
								
							<li><a href="#" id="addEmployee"><i
									class="glyphicon glyphicon-plus"></i> Add Employee</a></li>
							<li><a href="#" id="surveyHistory"><i
									class="glyphicon glyphicon-th-list"></i> Survey History</a></li>
									<li><a href="#" id="feedbackHistory"><i
									class="glyphicon glyphicon-th-list"></i> Feedback History</a></li>
							<!-- 
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Calendar Event</a>
                        </li> -->

						</ul>
						<ul class="nav" id="side-menu">
							
							<li><a href="#" id="userProfile"><i
									class="glyphicon glyphicon-user"></i> Profile</a></li>
							<li><a href="#" id="ChangePassword"><i
									class="glyphicon glyphicon-link"></i> Change Password</a></li>
						<!-- <li><a href="#" id="SurveyReport"><i
										class="glyphicon glyphicon-link"></i> Survey Report</a></li>
								<li><a href="#" id="FeedbackReport"><i
										class="glyphicon glyphicon-link"></i> Feedback Report</a></li> -->
						</ul>
					</div>
					</div>
					<!-- /.sidebar-collapse -->
				</div>
				<!-- /.navbar-static-side -->
			</nav>



			<div class="row">
				<div class="col-md-9 col-md-offset-3" id="mainContent">
			<%-- 	<c:if test="${requestScope.addEmployeeSuccess eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				New employee added successfully..
				
				</div>
				</c:if> --%>
				<%-- 	<c:if test="${not empty requestScope.selection}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Your selection<b> ${requestScope.selection}</b> is saved successfully.
				
				</div>
				</c:if> --%>
				
			<%-- 	<c:if test="${requestScope.contactDetailUpdated eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Details updated successfully..
				
				</div>
				
				</c:if> --%>
				<%-- <c:if test="${requestScope.showChangePassword eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Password changed successfully..
				</div>
				</c:if> --%>
				<%-- <c:if test="${requestScope.showCreateSurvey eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Snack survey created successfully ..
				
				</div>
				</c:if> --%>
				
				<%-- <c:if test="${requestScope.showCreateFeedback eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Feedback survey created successfully ..
				
				</div>
				</c:if> --%>
				<%-- <c:if test="${requestScope.showFeedSelection}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Your feedback is saved successfully..
				
				</div>
				</c:if> --%>
			<%-- 	<c:if test="${requestScope.picUploaded eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				pic uploaded successfully..
				
				</div>
				</c:if> --%>
				<c:choose >
				<c:when test="${requestScope.showFeedSelection eq true}">
						<jsp:include page="feedbacksurvey.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.picUploaded eq true}">
						<jsp:include page="uploadpic.jsp"></jsp:include>
					</c:when>
						<c:when test="${requestScope.contactDetailUpdated eq true}">
						<jsp:include page="userprofile.jsp"></jsp:include>
					</c:when>
					
						<c:when test="${requestScope.contactDetailNotUpdated eq true}">
						<jsp:include page="userprofile.jsp"></jsp:include>
					</c:when>
				
				
					<c:when test="${requestScope.showChangePassword eq true}">
						<jsp:include page="changepassword.jsp"></jsp:include>
					</c:when>
				
					<c:when test="${requestScope.gobacktosnacksurvey eq true}">
						<jsp:include page="surveyhistory.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.clickOnAddEmployee eq true}">
						<jsp:include page="addemployee.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.showCreateSurvey eq true}">
						<jsp:include page="createfeastpoll.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.showCreateFeedback eq true}">
						<jsp:include page="createfeedback.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.showFeastSelection eq true}">
						<jsp:include page="snacksurvey.jsp"></jsp:include>
					</c:when>
					<c:when test="${requestScope.closeSurveyClick eq true}">
						<jsp:include page="snacksurvey.jsp"></jsp:include>
					</c:when>
				<c:otherwise>
					<div class="jumbotron">
						<h2>Welcome ${userName}, to Mob Survey</h2>
						<p>Mobiquity is a professional services firm trusted by hundreds of companies to be their mobile engagement provider. We simplify mobile. On a global scale, the trends, strategy, users, platforms, technology, development, organizational issues of mobile are complicated. We eliminate the complexity. Our team represents the best talent in business and mobile strategy, user-experience design and technology and will guide you through the process of going mobile.</p>

					</div>
					
				</c:otherwise>
				</c:choose>
									</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="resource/js/ajax.js"></script>


</body>
</html>