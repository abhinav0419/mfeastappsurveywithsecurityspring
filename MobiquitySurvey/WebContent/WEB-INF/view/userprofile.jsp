<%@page import="com.mobiquity.snack.model.ContactDetailEntity"%>
<%@page import="com.mobiquity.snack.model.UserEntity"%>
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
  <h1>Profile</h1>
  	<c:if test="${requestScope.contactDetailUpdated eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Details updated successfully..
				
				</div>
				
				</c:if>
</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><b>Contact Detail</b></h3>
            
        </div>
        <div class="panel-body">
            <form:form action="profile" role="form" commandName="contactDetailEntity"  method="post">
                <div class="form-group">
                    <label><b>Mobile Number </b></label>
                    <form:input type="text" class="form-control" path="mobileNumber"/>
                </div>
                 <div class="form-group">
				<form:errors class="alert alert-danger alert-dismissible " role="alert" path="mobileNumber"/>
				</div> 
                <div class="form-group">
                    <b>Permanent Address </b>
                    <form:textarea class="form-control" rows="3" path="permenantAddress"/> 
                   
                </div>
                <div class="form-group">
                    <b>Temporary Address </b>
                    <form:textarea class="form-control" rows="3"   path="temporaryAddress"/>
                </div> 
              <!--   <div class="form-group">
                    <b>Upload Profile Image </b>
                    <input type="file"  name="displayPic"/>
                </div> -->
                <div class="form-group">
                    <input type="submit" class="btn btn-success" name="can" value="Save" ></input>&nbsp;&nbsp;<button class="btn btn-success" name="can" value="cancel">Cancel</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>