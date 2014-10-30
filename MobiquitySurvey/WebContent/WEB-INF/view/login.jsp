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
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta http-equiv="cache-control"
	content="no-cache, no-store, must-revalidate">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>SB Admin 2 - Bootstrap Admin Theme</title>

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


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">
		<div class="row">
			

			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">${errorMessage}</div>
						</c:if>
						<form action="j_spring_security_check" role="form-control" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" name="j_username" placeholder="E-mail" type="email"></input>
								</div>
								<div class="form-group">
									<input class="form-control" name="j_password" placeholder="Password" type="password"></input>
								</div>
								<div class="checkbox">
									<label> 
										<input name="_spring_security_remember_me" type="checkbox" value="Remember Me">Remember Me
									</label>
								</div>
								
								<input type="submit" class="btn btn-lg btn-success btn-block" value="login">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>

</html>
