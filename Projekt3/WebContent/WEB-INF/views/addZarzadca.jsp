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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projekt I</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/messages_pl.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.ui.datepicker-pl.js"></script>
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

<script type="text/javascript">
	$(document).ready(function() {
		$("#formularz").validate({
			rules : {
				AccordionField : {
					required : true
				}
			},
			ignore : []
		});
	});
</script>

<style type="text/css">
em,.error {
	color: red;
	font-size: 14px;
	font-style: oblique;
}
</style>

<script>
	$(function() {
		$.datepicker.setDefaults($.datepicker.regional['pl']);
		$("#datepicker").datepicker({});
	});
</script>
<script type="text/javascript">
	function run() {
		document.getElementById("srt1").value = document
				.getElementById("obiektNazwa").value.match(/\(([^)]+)\)/)[1];
	}
</script>

</head>
<body>

	<sql:query var="obiekt" dataSource="${postgres}">
select nazwa, obiektid from obiekt
</sql:query>

	<h2 align="center">Dodaj zarządcę do obiektu</h2>
	<form method="POST" commandName="addZarzadca"
		action="/Projekt3/saveZarzadca.html" id="formularz" name="form">
		<table align="center">
			<tr>
				<td align="left">Nazwa obiektu:</td>
				<td align="left"><select name="obiektNazwa" id="obiektNazwa"
					 style="width: 200px; font-size: 18px">
						<c:forEach var="row" items="${obiekt.rows}">
							<option>
								<c:out value="${row.nazwa}" />
								<c:out value="(${row.obiektid})" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td style="display:none;">Obiekt Id:</td>
				<td style="display:none;"><input name="obiektId" id="srt1"
					value="${zarzadca.obiektId}"></td>
			</tr>
			<tr>
				<td>Imię:</td>
				<td><input name="zarzadcaImie" value="${zarzadca.zarzadcaImie}"
					class="required"></td>
			</tr>
			<tr>
				<td>Nazwisko:</td>
				<td><input name="zarzadcaNazwisko"
					value="${zarzadca.zarzadcaNazwisko}" class="required"></td>
			</tr>
			<tr>
				<td>Data urodzenia:</td>
				<td><input name="zarzadcaDataUrodzenia" id="datepicker"
					value="${zarzadca.zarzadcaDataUrodzenia}" class="required"></td>
			</tr>
			<tr>
				<td>Telefon:</td>
				<td><input name="zarzadcaTelefon"
					value="${zarzadca.zarzadcaTelefon}" class="digits" minlength="7"></td>
			<tr />
			<tr>
				<td>Email:</td>
				<td><input name="zarzadcaEmail"
					value="${zarzadca.zarzadcaEmail}" class="email"></td>
			<tr />
			<tr>
				<td>Miejscowość:</td>
				<td><input name="zarzadcaMiejscowosc"
					value="${zarzadcaAdres.zarzadcaMiejscowos}" class="required"></td>
			<tr />
			<tr>
				<td>Kod pocztowy:</td>
				<td><input name="zarzadcaKodPocztowy"
					value="${zarzadcaAdres.zarzadcaKodPocztowy}" class="digits"
					minlength="5" maxlength="5"></td>
			<tr />
			<tr>
				<td>Ulica:</td>
				<td><input name="zarzadcaUlica"
					value="${zarzadcaAdres.zarzadcaUlica}" minlength="3"></td>
			<tr />
			<tr>
				<td>Numer domu:</td>
				<td><input name="zarzadcaNumerDomu"
					value="${zarzadcaAdres.zarzadcaNumerDomu}"></td>
			<tr />
		</table>
		<center>
			<input type="submit" value="Dodaj" onclick="run()"/>
		</center>
	</form>
	<br></br>

	<h2 align="center">Zarządcy obiektów</h2>
	
<sql:query var="obiekt2" dataSource="${postgres}">
select nazwa, zarzadcaid, imie, nazwisko, dataurodzenia, email, telefon
from obiekt
inner join zarzadca using (obiektid)
</sql:query>

<div style="width: 90%; margin-left: 5%">
	<table align="center" border="0" id="myTable" cellspacing="0px"
		width="100%">
		<thead>
			<tr>
				<th style="display:none;">ID</th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Data urodzenia</th>
				<th>Email</th>
				<th>Telefon</th>
				<th>Nazwa obiektu</th>
				<th>Akcja</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${obiekt2.rows}">
				<tr>
					<td align="center" style="display:none;"><c:out value="${row.zarzadcaid}" /></td>
					<td align="center"><c:out value="${row.imie}" /></td>
					<td align="center"><c:out value="${row.nazwisko}" /></td>
					<td align="center"><c:out value="${row.dataurodzenia}" /></td>
					<td align="center"><c:out value="${row.email}" /></td>
					<td align="center"><c:out value="${row.telefon}" /></td>
					<td align="center"><c:out value="${row.nazwa}" /></td>
					<td align="center"><a
								href="deleteZarzadca.html?id=${row.zarzadcaid}"
								style="height: 30px; font-size: 15px; font-style: oblique;">Usuń</a>
								<a href="openZarzadca.html?id=${row.zarzadcaid}"
								style="height: 30px; font-size: 15px; font-style: oblique;">Otwórz</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>	
	
	
	<br></br>

</body>
</html>