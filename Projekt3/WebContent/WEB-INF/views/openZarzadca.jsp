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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projekt I</title>

<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath()%>/resources/css/demo_table.css";
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.tablesorter.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/highstock.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/exporting.js"></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/blue/style.css"
	rel="stylesheet">

<script type="text/javascript">
	$.extend($.tablesorter.characterEquivalents, {
		"a" : "\u0105", // ą
		"A" : "\u0104", // Ą
		"c" : "\u0107", // ć
		"C" : "\u0106", // Ć
		"e" : "\u0119", // ę
		"E" : "\u0118", // Ę
		"l" : "\u0142", // ł
		"L" : "\u0141", // Ł
		"n" : "\u0144", // ń
		"N" : "\u0143", // Ń
		"o" : "\u00f3", // ó
		"O" : "\u00d3", // Ó
		"s" : "\u015b", // ś
		"S" : "\u015a", // Ś
		"z" : "\u017a\u017c", // źż
		"Z" : "\u0179\u017b" // ŹŻ
	});

	$(document).ready(function() {
		$("#tableZarzadca").tablesorter({
			widgets : [ "zebra", "columns" ],
			sortLocaleCompare : true
		});
	});
</script>

</head>

<body>

	<form:form>
	<div style="width: 70%; margin-left: 20%">
		<table id="tableZarzadca" class="tablesorter">
			<thead></thead>
			<tbody>
				<tr>
					<td><font size="4"><form:label path="imie">Imię:</form:label></font></td>
					<td><font size="4"><form:label path="imie">${zarzadca.imie}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="nazwisko">Nazwisko:</form:label></font></td>
					<td><font size="4"><form:label path="nazwisko">${zarzadca.nazwisko}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="dataUrodzenia">Data urodzenia:</form:label></font></td>
					<td><font size="4"><form:label path="dataUrodzenia">${zarzadca.dataUrodzenia}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="telefon">Numer telefonu:</form:label></font></td>
					<td><font size="4"><form:label path="telefon">${zarzadca.telefon}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="email">Email:</form:label></font></td>
					<td><font size="4"><form:label path="email">${zarzadca.email}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="miejscowosc">Miejscowość:</form:label></font></td>
					<td><font size="4"><form:label path="miejscowosc">${zarzadcaAdres.miejscowosc}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="kodPocztowy">Kod pocztowy:</form:label></font></td>
					<td><font size="4"><form:label path="kodPocztowy">${zarzadcaAdres.kodPocztowy}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="ulica">Ulica:</form:label></font></td>
					<td><font size="4"><form:label path="ulica">${zarzadcaAdres.ulica}</form:label></font></td>
				</tr>
				<tr>
					<td><font size="4"><form:label path="numerDomu">Numer domu:</form:label></font></td>
					<td><font size="4"><form:label path="numerDomu">${zarzadcaAdres.numerDomu}</form:label></font></td>
				</tr>
			</tbody>
		</table>
		</div>
	</form:form>

</body>
</html>