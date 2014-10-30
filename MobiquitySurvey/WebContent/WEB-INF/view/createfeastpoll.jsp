<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="img/favicon.ico"
	type="image/vnd.microsoft.icon" />
<title>Survey | Msurvey</title>
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

	<div class="page-header">
		<h1>
			Create Feast Survey 
		</h1>
		<c:if test="${requestScope.showCreateSurvey eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Snack survey created successfully ..
				
				</div>
				</c:if>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<b>Survey Detail</b>
			</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-12">
				
					<form:form action="submitsurvey" role="form" method="post"
						commandName="surveyEntity">
						
						<div class="form-group">
							<label for="sn">Survey Name</label>
							<form:input id="sn" type="text" class="form-control" path="surveyName"></form:input>
							<p class="help-block">Example : Friday Feast, Birthday Treat</p>
						</div>
						<div class="form-group">
							<label for="de">Description</label>
							<form:textarea id="de" class="form-control" path="surveyDescription" />
						</div>
						<div class="form-group">
							<label>Jain Option</label>
							<button  type="button" id="toggleButton" name="jainOption"
								class="btn btn-warning btn-xs" data-toggle="button">Not
								Available</button>
						</div>


						<div class="form-group">
							<label for="ro">Regular Option</label>
							<form:input id="ro" type="text" class="form-control"  path="vegOption"></form:input>
						</div>


						<div class="form-group">
							<label for="ja">Jain Option</label>
							<form:input id="ja" type="text" class="jainoption form-control" 
								 path="jainOption"></form:input>
						</div>



						<input type="submit" name="cancel" id="createSurvey" class="btn btn-success"
							value="Save"></input>&nbsp;&nbsp;&nbsp;&nbsp;<button name="cancel" value="cancel" class="btn btn-success" id="cancelButton">Cancel</button>
							<%-- </c:if> --%>
					</form:form>
				</div>
			</div>
			<!-- /.row (nested) -->
		</div>
		<!-- /.panel-body -->
	</div>

	<!-- /#wrapper -->
	<!-- jQuery Version 1.11.0 -->
	<script src="resource/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resource/js/bootstrap.min.js"></script>

	<script type="text/javascript">
    var button = $('#toggleButton');
	$(".jainoption").attr("disabled", true);
	button.on('click', function () {
	//alert($("#toggleButton").html());
  		//$(this).toggleClass('active');
  	if($("#toggleButton").html()=="Not Available")
  	{
  //	alert("sssa");
  	$("#toggleButton").html("Available");
  	$("#toggleButton").attr('class', 'btn btn-info btn-xs');
  	$("#divjainoption").show();
  	$(".jainoption").attr("disabled", false);
  	}
  	else
  	{
  //	alert("lol");
  		$("#toggleButton").html("Not Available");
  		$("#toggleButton").attr('class', 'btn btn-warning btn-xs');
  		$("#divjainoption").hide();
  		$(".jainoption").val('');
  		$(".jainoption").attr("disabled", true);
  	}
	});
    </script>



</body>

</html>
