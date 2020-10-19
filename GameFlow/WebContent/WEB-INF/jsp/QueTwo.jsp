<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">

(function () {
    var timeoutSession;
    document.addEventListener('mousemove', function (e) {
        clearTimeout(timeoutSession);
        timeoutSession = setTimeout(function () {
        	window.location = '${pageContext.request.contextPath}/questionController/queThree';
            //call a script here to server...
        }, 1600); //3s
    }, true);
})();

function displayRadioValue() { 
    var ele = document.getElementsByName('gender'); 
    var count =0;
    var answer;
   // alert(ele.length);
    for(i = 0; i < ele.length; i++) { 
        if(ele[i].checked) {
       
        count =count+1;
        answer=ele[i].value;
        }    
    } 
    if(count==0){
    	alert("please select one answer");
    }
    
    var obj={};
	obj.answer=answer;
    
    $.ajax({
		contentType : 'application/json; charset=utf-8',
		type : 'post',	
	    data:JSON.stringify(obj),
	    url:'${pageContext.request.contextPath}/questionController/ansTwo',
	   success:function(data) 
	   {
		window.location = '${pageContext.request.contextPath}/questionController/queThree'; 
	   }
	});
    
    //alert(answer);
}
</script>
</head>
<body>
  
     <div align="center">
    <h2>Is Hashmap thread-safe? : </h2>
    </br>
    <input type="radio" name="gender" value="Yes">Yes 
    <input type="radio" name="gender" value="No">No 
    
      
    <br> <br> <br> <br> 
      
    <button type="button" onclick="displayRadioValue()"> 
        Submit 
    </button> 
      
    <br> 
      </div>
</body>
</html>