<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">
function registerUser() {
	var username=document.getElementById("userName").value;
    var password=document.getElementById("password").value;
    if(username=="" || password==""){
  	  alert("Register the new username and password");
    }
   else{
	   var obj={};
		obj.username=username;
	    obj.password=password;
	    
	    $.ajax({
			contentType : 'application/json; charset=utf-8',
			type : 'post',	
		    data:JSON.stringify(obj),
		    url:'${pageContext.request.contextPath}/adminController/register',
		   success:function(data) 
		   {
window.location.href = "${pageContext.request.contextPath}/adminController/success";
		   }
		});
    }
	         
	
}
</script>
</head>
<body>
<form>
<div align="center">
<h1>Register New User</h1>
<p>
<label for="userName">User Name : </label>
     <input type="text" id="userName" />
</p>

<p>
<label for="password">Password :  </label>
 <input type="password" id="password" />
</p>

    <input type="button" value="Register" onclick="registerUser()">
</div>
</form>
</body>
</html>