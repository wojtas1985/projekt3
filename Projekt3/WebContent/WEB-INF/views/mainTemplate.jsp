<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-UTF-8" />

<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>

<style type="text/css">
html, body {
    height: 100%;
}
</style>

</head>
<body>
	<table style="width: 100%; height: 100%" cellpadding="2"  cellspacing="2">
		<tr>
			<td style="height: 10%;" colspan="2" align="center"
				background="<%= request.getContextPath() %>/resources/img/tymo.png"><tiles:insertAttribute
					name="header"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td style="width: 170px; height: 85%;" valign="top"
				background="<%= request.getContextPath() %>/resources/img/tymo.png"><tiles:insertAttribute
					name="menu"></tiles:insertAttribute></td>
			<td style="width:100%; height: 85%;" bgcolor="#COD9D9"><tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td style="height: 1%;" colspan="2" align="center"
				background="<%= request.getContextPath() %>/resources/img/tymo.png"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>
</html>