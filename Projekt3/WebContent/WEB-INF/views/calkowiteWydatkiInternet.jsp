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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Projekt I</title>

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
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/demo_table.css"
	rel="stylesheet">

<script type="text/javascript">
	jQuery.fn.dataTableExt.oSort['polski-alfabet-asc'] = function(a, b) {
		var x = a.toLowerCase();
		var y = b.toLowerCase();
		return x.localeCompare(y);
	};

	jQuery.fn.dataTableExt.oSort['polski-alfabet-desc'] = function(a, b) {
		var x = a.toLowerCase();
		var y = b.toLowerCase();
		return y.localeCompare(x);
	};

	$(document).ready(function() {
		$("#myTable").dataTable({
			"bJQueryUI" : true,
			"oLanguage" : {
				"sSearch" : "Szukaj:",
				"sLengthMenu" : "Wyświetl _MENU_ rekordów na stronie",
				"sZeroRecords" : "Nic nie znaleziono",
				"sInfo" : "Pokaż rekordy od _START_ do _END_ ",
				"sInfoEmpty" : "0 rekordów do wyświetlenia",
				"sInfoFiltered" : "( z _MAX_ wszystkich rekordów )"
			},
			"aoColumns" : [ {
				"sType" : 'polski-alfabet'
			}, null ]
		});
	});
</script>

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
		$("#tableTelefon, #tableInternet").tablesorter({
			theme : 'blue',
			widgets : [ "zebra", "columns" ],
			sortLocaleCompare : true
		});
	});
</script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>

<script type="text/javascript">
	$(function() {
		$(document)
				.ready(
						function() {
							Highcharts.visualize = function(table, options) {
								// the categories
								options.xAxis.categories = [];

								$('tbody th', table).each(
										function(i) {
											options.xAxis.categories
													.push(this.innerHTML);
										});

								// the data series
								options.series = [];
								$('tr', table)
										.each(
												function(i) {
													var tr = this;
													$('th, td', tr)
															.each(
																	function(j) {
																		if (j > 0) { // skip first column
																			if (i == 0) { // get the name and init the series
																				options.series[j - 1] = {
																					name : this.innerHTML,
																					data : []
																				};
																			} else { // add values
																				options.series[j - 1].data
																						.push(parseFloat(this.innerHTML));
																			}
																		}
																	});
												});

								var chart = new Highcharts.Chart(options);
							}

							var table = document.getElementById('myTable'), options = {
								chart : {
									renderTo : 'container',
									type : 'column'
								},
								title : {
									text : 'Wydatki na internet'
								},
								xAxis : {
									max : 3
								},

								scrollbar : {
									enabled : true
								},

								yAxis : {
									title : {
										text : 'Jednostki'
									}
								},

								tooltip : {
									formatter : function() {
										return '<b>' + this.series.name
												+ '</b><br/>' + this.y + ' '
												+ this.x.toLowerCase();
									}
								}
							};

							Highcharts.visualize(table, options);
						});

	});
</script>

<script type="text/javascript">
	$(function() {
		// On document ready, call visualize on the datatable.
		$(document).ready(
				function() {
					Highcharts.visualize = function(table, options) {
						// the categories
						var sliceNames = [];
						$('tbody th', table).each(function(i) {
							sliceNames.push(this.innerHTML);
						});

						// the data series
						options.series = [];
						$('tr', table).each(function(i) {
							var tr = this;
							$('th, td', tr).each(function(j) {
								if (j > 0) { // skip first column
									if (i == 0) { // get the name and init the series
										options.series[j - 1] = {
											name : this.innerHTML,
											data : []
										};
									} else { // add values
										options.series[j - 1].data.push({
											name : sliceNames[i - 1],
											y : parseFloat(this.innerHTML)
										});
									}
								}
							});
						});

						var chart = new Highcharts.Chart(options);
					}

					var table = document.getElementById('myTable'), options = {
						chart : {
							renderTo : 'container1',
							type : 'pie'
						},
						title : {
							text : 'Wydatki na internet'
						},
						xAxis : {},
						yAxis : {
							title : {
								text : 'Jednostki'
							}
						},
						tooltip : {
							formatter : function() {
								return '<b>' + this.series.name + '</b><br/>'
										+ (this.y).toFixed(2) + ' '
										+ this.point.name;
							}
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name
												+ '</b>: '
												+ (this.percentage).toFixed(2)
												+ ' %';
									}
								}
							}
						}
					};

					Highcharts.visualize(table, options);
				});

	});
</script>

</head>
<body>

	<h2 align="center">Wydatki na internet</h2>
	<sql:query var="obiekt" dataSource="${postgres}">
select nazwa,
sum(kwotainternet) as "resultinternet"
from obiekt
inner join internet using (obiektid)
group by nazwa
</sql:query>

	<div style="width: 90%; margin-left: 5%">
		<table align="center" border="0" id="myTable" cellspacing="0px"
			width="100%">
			<thead>
				<tr>
					<th>Nazwa</th>
					<th>Internet [PLN]</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${obiekt.rows}">
					<tr>
						<th align="center"><c:out value="${row.nazwa}" /></th>
						<td align="center"><c:out value="${row.resultinternet}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br></br>

	<div>
		<div id="container" style="width: 90%; margin-left: 5%"></div>
	</div>

	<div>
		<br></br>
		<div id="container1" style="width: 90%; margin-left: 5%"></div>
		<br></br>
	</div>
</body>
</html>
