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

<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">

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

<script>
	$(function() {
		$("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 3,
			onClose : function(selectedDate) {
				$("#to").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 3,
			onClose : function(selectedDate) {
				$("#from").datepicker("option", "maxDate", selectedDate);
			}
		});
	});
</script>

<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>

<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>

<script>
	$(function() {
		$("input[type=button], a, button").button();
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

	<h1 align="center">
		Dodaj odczyt
		</h1>

		<form:form method="POST" action="/Projekt3/saveOdczyt.html" 
			id="formularz">
			<center>
				<div id="accordion" style="width: 80%;">
					<h3>Data i okres odczytu (Wymagane)</h3>
					<div>
						<table align="center">
							<tr>
								<td align="left">Nazwa obiektu:</td>
								<td align="left"><select name="obiektNazwa"
									id="obiektNazwa"
									style="width: 300px; font-size: 18px;">
										<c:forEach var="row" items="${obiekt.rows}">
											<option>
												<c:out value="${row.nazwa}" />
												<c:out value="(${row.obiektid})" />
											</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td style="display: none;">Obiekt Id:</td>
								<td style="display: none;"><input name="obiektId" id="srt1"
									value="${odczyt.obiektId}"></td>
							</tr>
							<tr>
								<td align="left">DATA:</td>
								<td align="left"><input type="text" name="odczytData"
									id="datepicker" value="${odczyt.odczytData}" class="required"></td>
							<tr />
							<tr>
								<td align="left">OKRES OD:</td>
								<td align="left"><input type="text"
									name="odczytOkresPoczatek" id="from"
									value="${odczyt.odczytOkresPoczatek}" class="required"></td>
							</tr>
							<tr>
								<td align="left">DO:</td>
								<td align="left"><input type="text"
									name="odczytOkresKoniec" id="to"
									value="${odczyt.odczytOkresKoniec}" class="required"></td>
							<tr />
						</table>
					</div>
					<h3>Ciepło (Opcjonalne)</h3>
					<div>
						<table align="center">
							<tr>
								<td align="left">CIEPŁO GJ:</td>
								<td align="left"><input name="cieploGJ" id="cieploGJ"
									value="${cieplo.cieploGJ}" class="number"></td>
							<tr />
							<tr>
								<td align="left">PLN:</td>
								<td align="left"><input name="cieploPLN" id="cieploPLN"
									value="${cieplo.cieploPLN}" class="number"></td>
							</tr>
						</table>
					</div>
					<h3>Energia (Wymagane)</h3>
					<div>
						<table align="center">
							<tr>
								<td align="left">ENERGIA kWh:</td>
								<td align="left"><input name="energiaKWH" id="energiaKWH"
									value="${energia.energiaKWH}" class="required number"></td>
							</tr>
							<tr>
								<td align="left">PLN:</td>
								<td align="left"><input name="energiaPLN" id="energiaPLN"
									value="${energia.energiaPLN}" class="required number"></td>
							</tr>
						</table>
					</div>
					<h3>Gaz (Opcjonalne)</h3>
					<div>
						<table align="center">
							<tr>
								<td align="left">GAZ Nm3:</td>
								<td align="left"><input name="gazNM3" id="gazNM3"
									value="${gaz.gazNM3}" class="number"></td>
							<tr />
							<tr>
								<td align="left">PLN:</td>
								<td align="left"><input name="gazPLN" id="gazPLN"
									value="${gaz.gazPLN}" class="number"></td>
							<tr />
						</table>
					</div>
					<h3>Woda (Wymagane)</h3>
					<div>
						<table align="center">
							<tr>
								<td align="left">WODA m3:</td>
								<td align="left"><input name="wodaM3" id="wodaM3"
									value="${woda.wodaM3}" class="required number"></td>
							<tr />
							<tr>
								<td align="left">PLN:</td>
								<td align="left"><input name="wodaPLN" id="wodaPLN"
									value="${woda.wodaPLN}" class="required number"></td>
							<tr />
						</table>
					</div>
				</div>
			</center>
			<center>
				<input type="submit" value="Dodaj" onclick="run()"/>
			</center>
		</form:form>
</body>
</html>