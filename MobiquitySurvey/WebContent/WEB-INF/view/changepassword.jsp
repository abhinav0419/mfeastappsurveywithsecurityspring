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
  <h1>Change Password</h1>
  <c:if test="${requestScope.showChangePassword eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				Password changed successfully..
				</div>
				</c:if>
</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><b>Password</b></h3>
        </div>
        <div class="panel-body">
            <form:form action="newpassword" role="form" method="post">
                <div class="form-group">
                    <label for="op"><b>Current Password</b></label>
                    <input id="op" type="password" class="form-control"  name="oldPassword"></input>
                </div>
                 <div class="form-group">
                    <label for="np"><b>New Password</b></label>
                    <input id="np" type="password" class="form-control"  name="newPassword"></input>
                </div>
                 <div class="form-group">
                    <label for="cnp"><b>Confirm Password</b></label>
                    <input id="cnp" type="password" class="form-control"  ></input>
                </div>
                 <div class="form-group">
                    <input type="submit" id="createSurvey" name="cancel" class="btn btn-success" value="Change Password" ></input>&nbsp;&nbsp;<input type="submit" class="btn btn-success" name="cancel" value="cancel"/>                </div>
            </form:form>
        </div>
    </div>
</body>
</html>