<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<sql:setDataSource var="postgres" driver="org.postgresql.Driver"
	url="jdbc:postgresql://localhost:5432/postgres" user="postgres"
	password="admin" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Projekt I</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/messages_pl.js"></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">

<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/demo_table.css"
	rel="stylesheet">

<script type="text/javascript">
	$(function() {
		$("#myTable").dataTable({
			"bJQueryUI" : true,
			"oLanguage" : {
				"sSearch" : "Szukaj:",
				"sLengthMenu" : "Wyświetl _MENU_ rekordów na stronie",
				"sZeroRecords" : "Nic nie znaleziono",
				"sInfo" : "Pokaż rekordy od _START_ do _END_ ",
				"sInfoEmpty" : "0 rekordów do wyświetlenia",
				"sInfoFiltered" : "( z _MAX_ wszystkich rekordów )"
			}
		});
	});
</script>

<script>
	$(function() {
		$("input[type=button], a, button").button();
	});
</script>

<script>
	$(document).ready(function() {
		$('#btn').click(function() {
			$('#chk').is(':checked');
		});
	});
</script>

<script type="text/javascript">
	function check(value) {
		xmlHttp = GetXmlHttpObject();
		var url = "checkUser.html";
		url = url + "?name=" + value;
		xmlHttp.onreadystatechange = stateChanged;
		xmlHttp.open("POST", url, true);
		xmlHttp.send(null);
	}
	function stateChanged() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			var showdata = xmlHttp.responseText;
			document.getElementById("mydiv").innerHTML = showdata;
		}
	}
	function GetXmlHttpObject() {
		var xmlHttp = null;
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}
</script>

<script type="text/javascript">
	function validateForm() {
		var x = document.getElementById("mydiv").innerHTML;
		x = x.replace(/^\s*|\s*$/g, "");
		var validLogin = document.getElementById("name").value;
		var validHaslo = document.getElementById("haslo").value;

		if (x != "") {

		} else if (validLogin.length < 5) {
			var alertLogin = "Błąd! Login musi składać się z conajmniej 5 znaków!";
			document.getElementById("mydiv").innerHTML = alertLogin;
		} else if (validHaslo.length < 5) {
			var alertHaslo = "Błąd! Hasło musi składać się z conajmniej 5 znaków!";
			document.getElementById("mydiv2").innerHTML = alertHaslo;
		} else {
			var formularz = document.getElementById("formularz");
			formularz.submit();
		}
	}
</script>
</head>
<body>
	<h2 align="center">Dodaj użytkownika</h2>
	<form method="POST" commandName="addUser"
		action="/Projekt3/saveUser.html" id="formularz" name="form">
		<table align="center">
			<tr>
				<td>Login:</td>
				<td><input name="login" id="name" value="${uzytkownik.login}"
					onkeyup="check(value)"></td>
				<td><font
					style="color: red; font-size: 14px; font-style: oblique;"><div
							id="mydiv"></div></font></td>
			<tr>
				<td>Hasło:</td>
				<td><input name="haslo" id="haslo" value="${uzytkownik.haslo}"></td>
				<td><font
					style="color: red; font-size: 14px; font-style: oblique;"><div
							id="mydiv2"></div></font></td>
			</tr>
			<tr>
				<td>Uprawnienia:</td>
				<td><input type="radio" name="rola" value="ROLE_ADMIN">Admin
					<input type="radio" name="rola" value="ROLE_ZARZADCA">Zarządca
					<input type="radio" name="rola" value="ROLE_USER" checked="yes">Użytkownik</td>
			</tr>
			<tr>
				<td>Aktywny:</td>
				<td><input type="checkbox" name="enabled" id="chk"
					checked="yes" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Dodaj"
					class="button" id="btn" onclick="validateForm();" /></td>
			</tr>
		</table>
	</form>

	<h2 align="center">Użytkownicy</h2>

	<sql:query var="uzytkownik" dataSource="${postgres}">
select uzytkownikid, login, haslo, enabled, rola
from uzytkownik
inner join uzytkownikrole using (uzytkownikid)
</sql:query>
	<div style="width: 90%; margin-left: 5%">
		<table align="center" border="1" id="myTable" cellspacing="0px"
			width="100%">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th>Login</th>
					<th>Hasło</th>
					<th>Rola</th>
					<th>Akcja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${uzytkownik.rows}">
					<tr>
						<th align="center" style="display: none;"><c:out
								value="${row.uzytkownikid}" /></th>
						<td align="center"><c:out value="${row.login}" /></td>
						<td align="center"><c:out value="${row.haslo}" /></td>
						<td align="center"><c:choose>
								<c:when test="${row.rola=='ROLE_ADMIN'}">
									<p>Admin</p>
								</c:when>
								<c:when test="${row.rola=='ROLE_ZARZADCA'}">
									<p>Zarządca</p>
								</c:when>
								<c:otherwise>
									<p>Użytkownik</p>
								</c:otherwise>
							</c:choose></td>
						<td align="center"><a
							href="deleteUser.html?id=${row.uzytkownikid}"
							style="height: 30px; font-size: 15px; font-style: oblique;">Usuń</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br></br>

</body>
</html>