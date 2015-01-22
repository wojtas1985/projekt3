<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/ddaccordion.js"></script>
<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">

	<script>
$(function() {
	$( "input[type=submit], a, button" )
	.button();
	});
</script>
</head>
<body bgcolor="#COD9D9">
	<br></br>
	<br></br>
	<br></br>
	<h1 align="center"><font color="red">Nie masz wymaganych uprawnień!!!</font></h1>	
	<center><a href="welcome.html">Powrót</a></center>
</body>
</html>