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
						<li><a href="#" id="SurveyReport"><i
										class="glyphicon glyphicon-link"></i> Survey Report</a></li>
								<li><a href="#" id="FeedbackReport"><i
										class="glyphicon glyphicon-link"></i> Feedback Report</a></li>
						</ul>
					</div>
					</div>
					<!-- /.sidebar-collapse -->
				</div>
				<!-- /.navbar-static-side -->
			</nav>



			<div class="row">
				<div class="col-md-9 col-md-offset-3" id="mainContent">
					<div class="page-header">
		<h1>
			Add Employee <small></small>
		</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title"><b>Employee Detail</b></h3>
		</div>
		<div class="panel-body">
			<form:form action="newemployee" role="form" method="post"
				commandName="userEntity" enctype="multipart/form-data">
				<div class="form-group">
					 
					<label><b> First Name</b></label>
					<form:input type="text" placeholder="First Name" class="form-control" path="firstName"></form:input>
					
					
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<form:errors path="firstName"></form:errors>
				</div>
				<div class="form-group ">
					<label><b> Middle Name</b></label>
					<form:input type="text" class="form-control" path="middleName" ></form:input>
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				
				<form:errors  path="middleName"></form:errors>
				</div>
				<div class="form-group">
					<label><b> Last Name</b></label>
					<form:input type="text" class="form-control" path="lastName" ></form:input>
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				
				<form:errors path="lastName"></form:errors>
				</div>
				<div class="form-group">
					<label><b> Birth Date</b></label>
					
					<form:input type="date" class="form-control" path="birthDate" ></form:input>
					
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				
				<form:errors  path="birthDate"></form:errors>
				</div>
				<div class="form-group ">
					<label><b> Email</b></label>
					
					<form:input type="text" class="form-control" path="userName" ></form:input>
					
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				
				<form:errors  path="userName"></form:errors>
				</div>
				<div class="form-group ">
					<label><b> Password</b></label>
					<form:input type="text" class="form-control" path="password" ></form:input>
				</div>
				<div class="form-group alert alert-danger alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				
				<form:errors  path="password"></form:errors>
				</div>
				<div class="form-group">
					<label><b>Select Type</b></label> <select  class="form-control"
						name="role">
						<option value="">please select</option>
						<option value="ADMIN">Admin</option>
						<option value="USER">User</option>
					</select>
				</div>
				

				<div class="form-group">
					<input type="submit" name="cancel" class="btn btn-success"
							value="Save"></input>&nbsp;&nbsp;&nbsp;&nbsp;<button name="cancel" value="cancel" class="btn btn-success" id="cancelButton">Cancel</button>
				</div>
			</form:form>
		</div>
	</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="resource/js/ajax.js"></script>

</body>
</html>