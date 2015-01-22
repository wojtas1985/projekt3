<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="postgres" driver="org.postgresql.Driver"
	url="jdbc:postgresql://localhost:5432/postgres" user="postgres"
	password="admin" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projekt I</title>

<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/TableTools.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/ZeroClipboard.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/highstock.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/exporting.js"></script>

<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">
<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/demo_table.css"
	rel="stylesheet">
<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/TableTools.css"
	rel="stylesheet">

<script type="text/javascript">
        $(document).ready(function() 
        	    { 
        	        $("#myTable, #myTable2").dataTable({
        	        	"bJQueryUI": true,
                		"bAutoWidth": false,
                  		"sDom": '<"H"lfr>Tt<"F"ip>',
                		 "oTableTools": {
                	            "sSwfPath": "<%= request.getContextPath() %>/resources/swf/copy_csv_xls_pdf.swf"
                	        },
                	     "oLanguage": {
                	    	 	"sSearch": "Szukaj:",
                	            "sLengthMenu": "Wyświetl _MENU_ rekordów na stronie",
                	            "sZeroRecords": "Nic nie znaleziono",
                	            "sInfo": "Pokaż rekordy od _START_ do _END_ ",
                	            "sInfoEmpty": "0 rekordów do wyświetlenia",
                	            "sInfoFiltered": "( z _MAX_ wszystkich rekordów )"
                	        },
                	        "fnFooterCallback": function ( nRow, aaData, iStart, iEnd, aiDisplay ) {
                   			 var iTotal = [0,0,0,0];
                                for ( var i=0 ; i<aaData.length ; i++ )
                                   {
                               	 iTotal[0] += Number(aaData[i][1]);
                               	 iTotal[1] += Number(aaData[i][2]);
                               	 iTotal[2] += Number(aaData[i][3]);
                               	 iTotal[3] += Number(aaData[i][4]);
                                   }
                                
                                var iPage = [0,0,0,0];
                                for ( var i=iStart ; i<iEnd ; i++ )
                    			{
                    				iPage[0] += Number(aaData[ aiDisplay[i] ][1]);
                    				iPage[1] += Number(aaData[ aiDisplay[i] ][2]);
                    				iPage[2] += Number(aaData[ aiDisplay[i] ][3]);
                    				iPage[3] += Number(aaData[ aiDisplay[i] ][4]);
                    			}
                                
                                var iAverage = [0,0,0,0];
                               	 iAverage[0] = Number(iPage[0]/iEnd);
                               	 iAverage[1] = Number(iPage[1]/iEnd);
                               	 iAverage[2] = Number(iPage[2]/iEnd);
                               	 iAverage[3] = Number(iPage[3]/iEnd);

                                var nCells = nRow.getElementsByTagName('th');
                                   nCells[1].innerHTML=iPage[0].toFixed(2);
                                   nCells[2].innerHTML=iPage[1].toFixed(2);
                                   nCells[3].innerHTML=iPage[2].toFixed(2);
                                   nCells[4].innerHTML=iPage[3].toFixed(2);                       
                                   
                                   var secondRow = $(nRow).next()[0];
                                   var nsCells = secondRow.getElementsByTagName('th');
                                   nsCells[1].innerHTML = iAverage[0].toFixed(2);
                                   nsCells[2].innerHTML = iAverage[1].toFixed(2);
                                   nsCells[3].innerHTML = iAverage[2].toFixed(2);
                                   nsCells[4].innerHTML = iAverage[3].toFixed(2);
                   		} 
        	        }); 
        	    } 
        	); 
        </script>

<script type="text/javascript">
$(function () {
    $(document).ready(function() {
        Highcharts.visualize = function(table, options) {
            // the categories
            options.xAxis.categories = [];
            $('tbody th', table).each( function(i) {
                options.xAxis.categories.push(this.innerHTML);
            });
    
            // the data series
            options.series = [];
            $('tbody tr, thead tr', table).each( function(i) {
                var tr = this;
                $('th, td', tr).each( function(j) {
                    if (j > 0) { // skip first column
                        if (i == 0) { // get the name and init the series
                            options.series[j - 1] = {
                                name: this.innerHTML,
                                data: []
                            };
                        } else { // add values
                            options.series[j - 1].data.push(parseFloat(this.innerHTML));
                        }
                    }
                });
            });
    
            var chart = new Highcharts.Chart(options);
        }
    
        var table = document.getElementById('myTable'),
        options = {
            chart: {
                renderTo: 'container',
                type: 'line'
            },
            title: {
                text: 'Odczyty'
            },
            
            xAxis: {
            	max:11
            },
            
            scrollbar: {
            	enabled: true
		    },
			
            yAxis: {
                title: {
                    text: 'Jednostki'
                }
            },
            
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.y +' '+ this.x.toLowerCase();
                }
            }
        };
    
        Highcharts.visualize(table, options);
    });
    
});
        </script>

<script type="text/javascript">
$(function () {
    $(document).ready(function() {
        Highcharts.visualize = function(table, options) {
            // the categories
            options.xAxis.categories = [];
            $('tbody th', table).each( function(i) {
                options.xAxis.categories.push(this.innerHTML);
            });
    
            // the data series
            options.series = [];
            $('tbody tr, thead tr', table).each( function(i) {
                var tr = this;
                $('th, td', tr).each( function(j) {
                    if (j > 0) { // skip first column
                        if (i == 0) { // get the name and init the series
                            options.series[j - 1] = {
                                name: this.innerHTML,
                                data: []
                            };
                        } else { // add values
                            options.series[j - 1].data.push(parseFloat(this.innerHTML));
                        }
                    }
                });
            });
    
            var chart = new Highcharts.Chart(options);
        }
    
        var table = document.getElementById('myTable2'),
        options = {
            chart: {
                renderTo: 'container2',
                type: 'line'
            },
            title: {
                text: 'Odczyty'
            },
            
            xAxis: {
            	max:11
            },
            
            scrollbar: {
            	enabled: true
		    },
			
            yAxis: {
                title: {
                    text: 'Jednostki'
                }
            },
            
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.y +' '+ this.x.toLowerCase();
                }
            }
        };
    
        Highcharts.visualize(table, options);
    });
    
});
        </script>
        
<script>
$(function() {
$( "#tabs" ).tabs();
});
</script>

<script>
$(function() {
$( "input[type=submit], a, button" )
.button();

});
</script>
</head>
<body>
	<h1 align="center">
		<form:form method="POST">${obiekt.nazwa}</form:form>
	</h1>

	<form:form method="POST">
		<center>
			<div id="tabs" style="width: 60%;">
				<ul>
					<li><a href="#tabs-1">Dane główne</a></li>
					<li><a href="#tabs-2">Adres</a></li>
					<li><a href="#tabs-3">Kontakt</a></li>
				</ul>
				<div id="tabs-1">
					<table cellpadding="5">
						<tr>
							<td><form:label path="id">ID:</form:label></td>
							<td><form:label path="id">${obiekt.id}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="powierzchnia">Powierzchnia:</form:label></td>
							<td><form:label path="powierzchnia">${obiekt.powierzchnia}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="kubatura">Kubatura:</form:label></td>
							<td><form:label path="kubatura">${obiekt.kubatura}</form:label></td>
						</tr>

						<tr>
							<td><form:label path="liczbaUzytkownikow">Liczba użytkowników:</form:label></td>
							<td><form:label path="liczbaUzytkownikow">${obiekt.liczbaUzytkownikow}</form:label></td>
						</tr>
					</table>
				</div>
				<div id="tabs-2">
					<table cellpadding="5">
						<tr>
							<td><form:label path="miejscowosc">Miejscowość:</form:label></td>
							<td><form:label path="miejscowosc">${obiektAdres.miejscowosc}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="kodPocztowy">Kod pocztowy:</form:label></td>
							<td><form:label path="kodPocztowy">${obiektAdres.kodPocztowy}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="ulica">Ulica:</form:label></td>
							<td><form:label path="ulica">${obiektAdres.ulica}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="numerDomu">Nr domu:</form:label></td>
							<td><form:label path="numerDomu">${obiektAdres.numerDomu}</form:label></td>
						</tr>
					</table>
				</div>
				<div id="tabs-3">
					<table cellpadding="5">
						<tr>
							<td><form:label path="telefon">Telefon:</form:label></td>
							<td><form:label path="telefon">${obiektKontakt.telefon}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="fax">Fax:</form:label></td>
							<td><form:label path="fax">${obiektKontakt.fax}</form:label></td>
						</tr>
						<tr>
							<td><form:label path="email">Email:</form:label></td>
							<td><form:label path="email">${obiektKontakt.email}</form:label></td>
						</tr>
					</table>
				</div>
				<div id="tabs-4">
				</div>
			</div>
		</center>
	</form:form>
	<br></br>
	
	<h2 align="center">Statystyki</h2>
	<sql:query var="obiekt" dataSource="${postgres}">
select odczytdata , cieplogj, cieplopln, energiakwh, energiapln, 
gaznm3, gazpln, wodam3, wodapln
from obiekt
inner join odczyt using (obiektid)
inner join cieplo using (odczytid)
inner join energia using (odczytid)
inner join gaz using (odczytid)
inner join woda using (odczytid)
where obiektid=${obiekt.id}
</sql:query>

<div style="width: 90%; margin-left: 5%">
	<table align="left" id="myTable" cellspacing="0px" width="100%">
		<thead>
			<tr>
				<th>Data</th>
				<th>Ciepło [GJ]</th>
				<th>Energia [kWh]</th>
				<th>Gaz [Nm3]</th>
				<th>Woda [m3]</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${obiekt.rows}">
				<tr>
					<th align="center"><c:out value="${row.odczytdata}" /></th>
					<td align="center"><c:out value="${row.cieplogj}" /></td>
					<td align="center"><c:out value="${row.energiakwh}" /></td>
					<td align="center"><c:out value="${row.gaznm3}" /></td>
					<td align="center"><c:out value="${row.wodam3}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		<tr>
		<th>SUMA:</th><th></th><th></th><th></th><th></th>
		</tr>
		<tr>
		<th>ŚREDNIA:</th><th></th><th></th><th></th><th></th>
		</tr>
		</tfoot>
	</table>
	</div>
	<br></br>
	<div id="container" style="width: 90%; height: 400px; margin: 0 auto"></div>
	<br></br>
	
	<div style="width: 90%; margin-left: 5%">
	<table align="left" id="myTable2" cellspacing="0px" width="100%">
		<thead>
			<tr>
				<th>Data</th>
				<th>Ciepło [PLN]</th>
				<th>Energia [PLN]</th>
				<th>Gaz [PLN]</th>
				<th>Woda [PLN]</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${obiekt.rows}">
				<tr>
					<th align="center"><c:out value="${row.odczytdata}" /></th>
					<td align="center"><c:out value="${row.cieplopln}" /></td>
					<td align="center"><c:out value="${row.energiapln}" /></td>
					<td align="center"><c:out value="${row.gazpln}" /></td>
					<td align="center"><c:out value="${row.wodapln}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		<tr>
		<th>SUMA:</th><th></th><th></th><th></th><th></th>
		</tr>
		<tr>
		<th>ŚREDNIA:</th><th></th><th></th><th></th><th></th>
		</tr>
		</tfoot>
	</table>
	</div>
	<br></br>
	
	<div id="container2" style="width: 90%; height: 400px; margin: 0 auto"></div>
	<br></br>
	
</body>
</html>