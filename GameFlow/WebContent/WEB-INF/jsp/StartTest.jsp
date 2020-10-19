<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
function startGame() {
	window.location.href = "${pageContext.request.contextPath}/questionController/queOne";
}
</script>
</head>
<body>
<div align="center" style="margin-top: 300px;">
<input type="button"  style="background-color:grey;color:white; font-size: 24px;"
 value="Click here to start the Game" onclick="startGame()">
 </div>
</body>
</html>