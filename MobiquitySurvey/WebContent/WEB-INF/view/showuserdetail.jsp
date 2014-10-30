
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>MFeast</title>

    <!-- Bootstrap Core CSS -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resource/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="resource/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resource/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="resource/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resource/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    
    <!-- jQuery Version 1.11.0 -->
    <script src="resource/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resource/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resource/js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resource/js/sb-admin-2.js"></script>
    <script type="text/javascript">
    $( document ).ready(function(){
    	$("#hidden").hide();
    	$("#changePic").click(function(){
    		$("#hidden").click();
    	});
    	
    });
    
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#imgInp").change(function(){
        readURL(this);
    });
    </script>
   
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    


</head>

<body>

    <div id="wrapper">
		<!--dismisibble alerts  -->

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">MFeast</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
              
                <!-- /.dropdown -->
               
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                	 
   
       
         <a data-toggle="modal" data-target="#myModal" class="thumbnail">
      <img src="${contactDetailEntity.displayPic}" alt="..." >
    </a>
    
  
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Create Survey<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a data-toggle="modal" data-target="#myModal" style="cursor: pointer; cursor: hand;">Feast Poll</a>
                                </li>
                                <li>
                                    <a href="#">FeedBack</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="/createEmployee"><i class="fa fa-table fa-fw"></i> Add Employee</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Previous Results<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">1st survey</a>
                                </li>
                                <li>
                                    <a href="#">2nd survey</a>
                                </li>
                                <li>
                                    <a href="#">3rd survey</a>
                                </li>
                                <li>
                                    <a href="#">4th survey</a>
                                </li>
                                <li>
                                    <a href="#">5th survey</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Calendar Event</a>
                        </li>
                
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
        <h2>Edit Contact Details..</h2>
         <form:form action="profile" role="form" method="post" commandName="contactDetailEntity" enctype="multipart/form-data">
    	<table class="table">
    		<tr>
    			<td><b>Mobile Number:</b></td>
    			<td><form:input type="text" class="form-control"  path="mobileNumber" size="44"></form:input></td>
    		</tr>
    		  <tr>
    			<td><b>Permanent Address:</b></td>
    			<td><form:textarea class="form-control" path="permenantAddress"/></td>
    		</tr>  
    		<tr>
    			<td><b>Temporary Address:</b></td>
    			<td><form:textarea class="form-control" path="temporaryAddress"/></td>
    		</tr>
    		<tr>
    			<td><b>Select Display Pic:</b></td>
    			<td><form:input type="file"  path="displayPic"></form:input></td>
    		</tr>	
    		<tr>
    			<td></td><td>
    			<input type="submit" id="createSurvey" class="btn btn-primary" value="save" ></input></td>
    		</tr>
 		</table>
      
     </form:form>
            <!-- <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> MFeast Results</h1>
                </div>
                /.col-lg-12
            </div> -->
            <!-- /.row -->
            <!-- <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Yes</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>No</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                           
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                
                           
                        </a>
                    </div>
                </div>
            </div> -->
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                
                </div>
             </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


<!--data modal survey for the dp -->

<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">Profile Picture</h4>
      </div>
      <div class="modal-body">
       <form id="form1">
        <p><img src="resource/userICon.png" alt="..." id="blah"></p>
        
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="file" id="hidden">
        <a  class="btn btn-primary"  id="changePic">Change Pic</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



</body>

</html>
