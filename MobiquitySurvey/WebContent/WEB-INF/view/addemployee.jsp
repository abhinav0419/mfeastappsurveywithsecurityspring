<%@page import="com.mobiquity.snack.model.ContactDetailEntity"%>
<%@page import="com.mobiquity.snack.model.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
	function checkForBlank(){
		var errorMessage = '';
		if(document.getElementById('fname').value == ""){
			document.getElementById('fname').style.borderColor="red";
			errorMessage += 'please enter first name \n';
		}
		if(document.getElementById('mName').value == ""){
			document.getElementById('mName').style.borderColor="red";
			errorMessage += 'please enter middle name \n';
		}
		if(document.getElementById('lName').value == ""){
			document.getElementById('lName').style.borderColor="red";
			errorMessage += 'please enter last name \n';
		}
		if(errorMessage != ""){
			alert(errorMessage);
			return false;
		}
	}
</script> -->

</head>
<body>


	<div class="page-header">
		<h1>
			Add Employee 
		</h1>
			<c:if test="${requestScope.addEmployeeSuccess eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				New employee added successfully..
				
				</div>
				</c:if>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title"><b>Employee Detail</b></h3>
		</div>
		<div class="panel-body">
			<form:form action="newemployee" class="col-md-7" role="form" method="post"
				commandName="userEntity" enctype="multipart/form-data" onsubmit="return checkForBlank();">
				<div class="form-group">
					 
					<label><b> First Name</b></label>
					<form:input type="text" id="fname" class="form-control" path="firstName"></form:input>
					<span id="fnameerror"></span>
					
				</div>
				
				<div class="form-group">
					<form:errors  class="alert alert-danger alert-dismissible" role="alert" id="firstNameError" path="firstName">
					</form:errors>
					
				</div>
					 
			
				
			
				<div class="form-group ">
					<label><b> Middle Name</b></label>
					<form:input id="mName" type="text" class="form-control" path="middleName" ></form:input>
				</div>
				<div class="form-group">
				<form:errors  class="alert alert-danger alert-dismissible " role="alert" path="middleName"></form:errors>
				</div>
				
				<div class="form-group">
					<label><b> Last Name</b></label>
					<form:input id="lName" type="text" class="form-control" path="lastName" ></form:input>
				</div>
				<div class="form-group">
				<form:errors class="alert alert-danger alert-dismissible " role="alert" path="lastName"></form:errors>
				</div>
				<div class="form-group">
					<label><b> Birth Date</b></label>
					
					<input type="date" class="form-control" name="dob" ></input>
					
				</div>
				<div class="form-group">
				<form:errors class="alert alert-danger alert-dismissible " role="alert" path="birthDate"></form:errors>
				</div>
				<div class="form-group ">
					<label><b> Email</b></label>
					
					<form:input type="text" class="form-control" path="userName" ></form:input>
					
				</div>
				<div class="form-group"><form:errors class="alert alert-danger alert-dismissible " role="alert" path="userName"></form:errors>
				</div>
				<div class="form-group ">
					<label><b> Password</b></label>
					<form:input type="password" class="form-control" path="password" ></form:input>
				</div>
				
			<div class="form-group"><form:errors  class="alert alert-danger alert-dismissible " role="alert" path="password"></form:errors>
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
							value="Save"></input>&nbsp;&nbsp;<button name="cancel" value="cancel" class="btn btn-success" id="cancelButton">Cancel</button>
				</div>
			</form:form>
					 
		</div>
	</div>
</body>
</html>