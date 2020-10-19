<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	response.addHeader("X-FRAME-OPTIONS", "SAMEORIGIN");
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	response.setHeader("Cache-Control", "no-store");
%>
<html>
<head>
<title>RA AT Tracker</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=9;IE=10;IE=Edge,chrome=1"/> 
<meta name="GENERATOR" content="Rational Application Developer">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">

<style type="text/css">

.errorMsgDiv{
  width : 50%;
  height:200px;
  margin-left:auto;
  margin-right:auto;
  margin-top:100px;
  border:1px solid red;
  color : red;
}

.btn{
  color : grey;
}

.home {
    display: inline-flex;
    width: 162px;
    margin-left: 20%;
    margin-right: auto;
}

</style>

</head>

	
<body>

	 <div class="errorMsgDiv">
		<div style="display: visible" id="messageDiv">
		<br>
		<center>
			<font color="red" size="5"><h4>Sorry!! Your session has expired.</h4> </font>
		</center>
		<br>
		<br>
		




	</div>
	</div>			
</body>
</html>