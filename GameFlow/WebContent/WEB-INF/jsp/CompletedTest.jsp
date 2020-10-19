<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () { 
	
	$.ajax({
	    type:'POST',	
	    url:'${pageContext.request.contextPath}/questionController/viewData',
	   success:function(data) 
	   {
		   
		   alert(data.result)
		   
		   
	   }
	   });
	
});

</script>
</head>
<body>
<h1>Test Completed Successfully...</h1>

</body>
</html>