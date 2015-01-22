<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="postgres" driver="org.postgresql.Driver"
	url="jdbc:postgresql://localhost:5432/postgres" user="postgres"
	password="admin" scope="session" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Projekt I</title>

<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath()%>/resources/css/demo_table.css";

@import "<%=request.getContextPath()%>/resources/css/TableTools.css";

@import
	"<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.0.custom.css"
	;
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/dataTables.columnFilter.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/TableTools.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/ZeroClipboard.js"></script>

<script>
        $(document).ready(function() {
        	$('#example').dataTable({
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

											"fnFooterCallback" : function(nRow,
													aaData, iStart, iEnd,
													aiDisplay) {
												var iTotal = [ 0, 0, 0, 0 ];
												for (var i = 0; i < aaData.length; i++) {
													iTotal[0] += Number(aaData[i][4]);
													iTotal[1] += Number(aaData[i][5]);
													iTotal[2] += Number(aaData[i][6]);
													iTotal[3] += Number(aaData[i][7]);
												}

												var iPage = [ 0, 0, 0, 0 ];
												for (var i = iStart; i < iEnd; i++) {
													iPage[0] += Number(aaData[aiDisplay[i]][4]);
													iPage[1] += Number(aaData[aiDisplay[i]][5]);
													iPage[2] += Number(aaData[aiDisplay[i]][6]);
													iPage[3] += Number(aaData[aiDisplay[i]][7]);
												}

												var iAverage = [ 0, 0, 0, 0 ];
												iAverage[0] = Number(iPage[0]
														/ iEnd);
												iAverage[1] = Number(iPage[1]
														/ iEnd);
												iAverage[2] = Number(iPage[2]
														/ iEnd);
												iAverage[3] = Number(iPage[3]
														/ iEnd);

												var secondRow = $(nRow).next()[0];
												var nCells = secondRow
														.getElementsByTagName('th');
												nCells[4].innerHTML = iPage[0]
														.toFixed(2);
												nCells[5].innerHTML = iPage[1]
														.toFixed(2);
												nCells[6].innerHTML = iPage[2]
														.toFixed(2);
												nCells[7].innerHTML = iPage[3]
														.toFixed(2);

												var thirdRow = $(secondRow)
														.next()[0];
												var nsCells = thirdRow
														.getElementsByTagName('th');
												nsCells[4].innerHTML = iAverage[0]
														.toFixed(2);
												nsCells[5].innerHTML = iAverage[1]
														.toFixed(2);
												nsCells[6].innerHTML = iAverage[2]
														.toFixed(2);
												nsCells[7].innerHTML = iAverage[3]
														.toFixed(2);
											}
										}).columnFilter();
					});
</script>

</head>
<body>
		<h1 align="center">Lista odczytów</h1>
	
<sql:query var="obiekt2" dataSource="${postgres}">
select nazwa, obiektid, odczytid, odczytdata, okresod, okresdo, 
cieplogj, cieplopln,
energiakwh, energiapln,
gaznm3, gazpln,
wodam3, wodapln
from obiekt
inner join odczyt using (obiektid)
inner join cieplo using (odczytid)
inner join energia using (odczytid)
inner join gaz using (odczytid)
inner join woda using (odczytid)
</sql:query>


	
	<div style="width: 90%; margin-left: 5%">
	<table align="left" border="1" id="example" cellspacing="0px"
		width="100%">
		<thead>
			<tr>
				<th style="display:none;">ID</th>
				<th>Data odczytu</th>
				<th>Okres od</th>
				<th>Okres do</th>
				<th>Ciepło [GJ]</th>
				<th>Energia [kWh]</th>
				<th>Gaz [Nm3]</th>
				<th>Woda [m3]</th>
				<th>Nazwa obiektu</th>
				<th>Akcja</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${obiekt2.rows}">
				<tr>
					<td align="center" style="display:none;"><c:out value="${row.odczytid}" /></td>
					<td align="center"><c:out value="${row.odczytdata}" /></td>
					<td align="center"><c:out value="${row.okresod}" /></td>
					<td align="center"><c:out value="${row.okresdo}" /></td>
					<td align="center"><c:out value="${row.cieplogj}" /></td>
					<td align="center"><c:out value="${row.energiakwh}" /></td>
					<td align="center"><c:out value="${row.gaznm3}" /></td>
					<td align="center"><c:out value="${row.wodam3}" /></td>
					<td align="center"><c:out value="${row.nazwa}" /></td>
					<td align="center"><a
								href="deleteOdczyt.html?id=${row.odczytid}"
								style="height: 30px; font-size: 15px; font-style: oblique;">Usuń</a>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
					<tr>
						<th style="display:none;">Id</th>
						<th>Data</th>
						<th>Okres od</th>
						<th>do</th>
						<th>Ciepło GJ</th>
						<th>Energia kWh</th>
						<th>Gaz Nm3</th>
						<th>Woda m3</th>
						<th>Nazwa obiektu</th>
					</tr>
					<tr>
						<th>SUMA:</th>
						<th style="display:none;"></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<th>ŚREDNIA:</th>
						<th style="display:none;"></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
	</table>
	</div>	
	<br></br>

	<sql:query var="obiekt" dataSource="${postgres}">
select nazwa, powierzchnia, 
sum(cieplogj) as "resultcieplo", sum(energiakwh) as "resultenergia", sum(gaznm3) as "resultgaz", sum(wodam3) as "resultwoda", 
round(cast(sum(cieplogj)/powierzchnia as numeric), 2) as "wskaznikcieplo", round(cast(sum(energiakwh)/powierzchnia as numeric), 2) as "wskaznikenergia",
round(cast(sum(gaznm3)/powierzchnia as numeric), 2) as "wskaznikgaz", round(cast(sum(wodam3)/powierzchnia as numeric), 2) as "wskaznikwoda"
from obiekt
inner join odczyt using (obiektid)
inner join cieplo using (odczytid)
inner join energia using (odczytid)
inner join gaz using (odczytid)
inner join woda using (odczytid)
group by nazwa, powierzchnia
</sql:query>

</body>
</html>