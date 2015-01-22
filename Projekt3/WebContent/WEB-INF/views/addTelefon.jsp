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
	src="<%=request.getContextPath()%>/resources/js/dataTables.columnFilter.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/TableTools.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/ZeroClipboard.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/messages_pl.js"></script>

<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath()%>/resources/css/demo_table.css";

@import "<%=request.getContextPath()%>/resources/css/TableTools.css";

@import
	"<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.0.custom.css"
	;
</style>

<script type="text/javascript">
	$(function() {
		$("#myTable").dataTable({
    		"bAutoWidth": false,
      		"bJQueryUI": true,
      		"sDom": '<"H"lfr>Tt<"F"ip>',
    		 "oTableTools": {
    	            "sSwfPath": "<%=request.getContextPath()%>/resources/swf/copy_csv_xls_pdf.swf"
							},

							"oLanguage" : {
								"sSearch" : "Szukaj:",
								"sLengthMenu" : "Wyświetl _MENU_ rekordów na stronie",
								"sZeroRecords" : "Nic nie znaleziono",
								"sInfo" : "Pokaż rekordy od _START_ do _END_ ",
								"sInfoEmpty" : "0 rekordów do wyświetlenia",
								"sInfoFiltered" : "( z _MAX_ wszystkich rekordów )"
							},

							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iTotal = [ 0 ];
								for (var i = 0; i < aaData.length; i++) {
									iTotal[0] += Number(aaData[i][4]);
								}

								var iPage = [ 0 ];
								for (var i = iStart; i < iEnd; i++) {
									iPage[0] += Number(aaData[aiDisplay[i]][4]);
								}

								var iAverage = [ 0 ];
								iAverage[0] = Number(iPage[0] / iEnd);

								var secondRow = $(nRow).next()[0];
								var nCells = secondRow
										.getElementsByTagName('th');
								nCells[4].innerHTML = iPage[0].toFixed(2);

								var thirdRow = $(secondRow).next()[0];
								var nsCells = thirdRow
										.getElementsByTagName('th');
								nsCells[4].innerHTML = iAverage[0].toFixed(2);
							}
						}).columnFilter();
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

	<h2 align="center">Dodaj wydatek na telefon</h2>
	<form method="POST" commandName="addTelefon"
		action="/Projekt3/saveTelefon.html" id="formularz" name="form">
		<table align="center">
			<tr>
				<td align="left">Nazwa obiektu:</td>
				<td align="left"><select name="obiektNazwa" id="obiektNazwa"
					onclick="run()" style="width: 200px; font-size: 18px">
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
					 value="${telefon.obiektId}"></td>
			</tr>
			<tr>
				<td>Data wystawienia:</td>
				<td><input name="telefonDataWystawienia" id="datepicker"
					value="${telefon.telefonDataWystawienia}" class="required"></td>
			<tr>
				<td>Okres od:</td>
				<td><input name="telefonOkresPoczatek" id="from"
					value="${telefon.telefonOkresPoczatek}" class="required"></td>
			</tr>
			<tr>
				<td>Okres do:</td>
				<td><input name="telefonOkresKoniec" id="to"
					value="${telefon.telefonOkresKoniec}" class="required"></td>
			</tr>
			<tr>
				<td align="left">Kwota:</td>
				<td align="left"><input name="telefonPLN"
					value="${telefon.telefonPLN}" class="required number"></td>
			<tr />
		</table>
		<center>
			<input type="submit" value="Dodaj" onclick="run()"/>
		</center>
	</form>
	<br></br>

	<h2 align="center">Wydatki na telefon</h2>

	<sql:query var="telefon" dataSource="${postgres}">
select nazwa, telefonid, telefondata, okresod, okresdo, kwotatelefon, obiektid
from obiekt 
inner join telefon using (obiektid)
</sql:query>
	<div style="width: 90%; margin-left: 5%">
		<table align="left" border="1" id="myTable" cellspacing="0px"
			width="100%">
			<thead>
				<tr>
					<th style="display: none;">ID</th>
					<th>Data wystawienia</th>
					<th>Okres od</th>
					<th>do</th>
					<th>Kwota</th>
					<th>Nazwa obiektu</th>
					<th>Akcja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${telefon.rows}">
					<tr>
						<td align="center" style="display: none;"><c:out
								value="${row.telefonid}" /></td>
						<td align="center"><c:out value="${row.telefondata}" /></td>
						<td align="center"><c:out value="${row.okresod}" /></td>
						<td align="center"><c:out value="${row.okresdo}" /></td>
						<td align="center"><c:out value="${row.kwotatelefon}" /></td>
						<td align="center"><c:out value="${row.nazwa}" /></td>
						<td align="center"><a
							href="deleteTelefon.html?id=${row.telefonid}"
							style="height: 30px; font-size: 15px; font-style: oblique;">Usuń</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th style="display: none;">Id</th>
					<th>Data</th>
					<th>Okres od</th>
					<th>do</th>
					<th>Kwota</th>
					<th>Nazwa obiektu</th>
				</tr>
				<tr>
					<th>SUMA:</th>
					<th style="display: none;"></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>ŚREDNIA:</th>
					<th style="display: none;"></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>
		</table>
	</div>
	<br></br>

</body>
</html>