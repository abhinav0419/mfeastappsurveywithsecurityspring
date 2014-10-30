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

<script type="text/javascript">
/* $("#cancelButton").click(function(){
	
	$("#fileUpload").removeAttr('src');
	$("#imgPreview").removeAttr('src');
}); */

$(document).ready(function(){
	$("#imgPreview").hide();
	$("#fileUpload").change(function(){
		$("#imgPreview").show();
	});
	
	
	
});
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imgPreview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#fileUpload").change(function(){
    readURL(this);
});
</script>
</head>
<body>
<div class="page-header">
  <h1>Profile</h1>
  	<c:if test="${requestScope.picUploaded eq true}">
				
					<div class="form-group alert alert-success alert-dismissible " role="alert" >
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				pic uploaded successfully..
				
				</div>
				</c:if>
</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><b>Contact Detail</b></h3>
        </div>
        <div class="panel-body">
            <form action="profilepic" role="form" method="post" enctype="multipart/form-data">
                
                <div class="form-group">
                    <b>Upload Profile Image </b>
                    <input type="file"  id="fileUpload" name="displayPic" onchange="readURL(this)"/>
                </div>
                <div class="form-group">
                   
                   <img id="imgPreview"  alt="your image" style="width:300px;height:300px;"/>
                </div>
                
                <div class="form-group">
                    <input type="submit" name="cancel" class="btn btn-success" value="Save" ></input>
                     <input type="submit" name="cancel" class="btn btn-success" value="Cancel" ></input>
                </div>
                
            </form>
            
        </div>
    </div>
</body>
</html>