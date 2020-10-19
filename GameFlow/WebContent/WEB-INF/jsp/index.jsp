<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">
function validateUsername() {
	
	          var username=document.getElementById("userName").value;
	          var password=document.getElementById("password").value;
	          if(username=="" || password==""){
	        	  alert("Please enter the username and password");
	          }
	          else if(username=="admin" && password=="admin"){
	    window.location.href = "${pageContext.request.contextPath}/adminController/showPage";
	          }else{
	        	  alert("Only admin can login")
	          }
	
}

function verifyUser() {
	var user=document.getElementById("user").value;
    var pwd=document.getElementById("pwd").value;
    if(user=="" || pwd==""){
  	  alert("Please enter the username and password");
    }
    else if(user!="" && pwd!=""){
    	var obj={};
		obj.user=user;
	    obj.pwd=pwd;
	    
	    $.ajax({
			contentType : 'application/json; charset=utf-8',
			type : 'post',	
		    data:JSON.stringify(obj),
		    url:'${pageContext.request.contextPath}/adminController/verifyUser',
		   success:function(data) 
		   {
			   console.log(data.sbErrorMessages);
			   if ( data.sbErrorMessages== 'success') {
		window.location.href = "${pageContext.request.contextPath}/adminController/startTest";
			   }else{
				   alert("Only registeres users can login")
			   }
		   }
		});
    }
}
</script>
</head>
<body>
<form>
<div align="center" style="margin-left: -900px;
    margin-top: 200px;" >
    <h1 style="background-color:red;">Admin Login only</h1>
<p>
<label for="userName">User Name : </label>
     <input type="text" id="userName" />
</p>

<p>
<label for="password">Password : </label>
 <input type="password" id="password" />
</p>

    <input type="button" style="background-color:blue;color:white;" value="LOGIN" onclick="validateUsername()">
</div>

<div align="right" style="margin-top: -175px;margin-right: 90px;">
<h1>Registered users Login only</h1>
<p>
<label for="user">User : </label>
     <input type="text" id="user" />
</p>
<p>
<label for="pwd">Password : </label>
 <input type="password" id="pwd" />
</p>

    <input type="button"
     style="background-color:blue;color:white;" value="LOGIN" onclick="verifyUser()">
</div>


</form>
</body>
</html>