<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Projekt I</title>
<style type="text/css" title="currentStyle">
@import "<%= request.getContextPath() %>/resources/css/jquery.dataTables.css";

@import "<%= request.getContextPath() %>/resources/css/TableTools.css";

@import "<%= request.getContextPath() %>/resources/css/jquery-ui-1.10.0.custom.css";
</style>

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
	src="<%= request.getContextPath() %>/resources/js/dataTables.columnFilter.js"></script>


<script> 

jQuery.fn.dataTableExt.oSort['num-html-asc']  = function(a,b) {
    var x = a.replace( /<.*?>/g, "" );
    var y = b.replace( /<.*?>/g, "" );
    x = parseFloat( x );
    y = parseFloat( y );
    return ((x < y || isNaN(y) ) ? -1 : ((x > y || isNaN(x)) ?  1 : 0));
};
 
jQuery.fn.dataTableExt.oSort['num-html-desc'] = function(a,b) {
    var x = a.replace( /<.*?>/g, "" );
    var y = b.replace( /<.*?>/g, "" );
    x = parseFloat( x );
    y = parseFloat( y );
    return ((x < y || isNaN(x)) ?  1 : ((x > y || isNaN(y) ) ? -1 : 0));
};

	jQuery.fn.dataTableExt.oSort['polski-alfabet-asc']  = function(a,b) {
	    var x = a.toLowerCase();
	    var y = b.toLowerCase();
	    return x.localeCompare(y);
	};
	 
	jQuery.fn.dataTableExt.oSort['polski-alfabet-desc'] = function(a,b) {
	    var x = a.toLowerCase();
	    var y = b.toLowerCase();
	    return y.localeCompare(x);
	};
	
	$(document).ready(function() {
		$('#example').dataTable( {
          		"bJQueryUI": true,
        		"bAutoWidth": false,
	        	"aoColumns": [{"sType": 'num-html'}, {"sType": 'polski-alfabet'}, {"sType": 'num-html'}, {"sType": 'num-html'}, {"sType": 'num-html'}, {"sType": 'polski-alfabet'}, null], 
          		"dom": 'T<"clear">lfrtip',
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
        	        }
        	});
        } );
</script>

</head>
<body>
	<h1 align="center">Lista obiektów</h1>
	<div style="width: 90%; margin-left: 5%">
	<c:if test="${!empty obiekty}">
		<table id="example" class="display" cellspacing="0">
			<thead>
				<tr>
					<th style="display:none;">Id</th>
					<th>Nazwa</th>
					<th>Powierzchnia</th>
					<th>Kubatura</th>
					<th>Użytkownicy</th>
					<th>Całodobowy</th>
					<th>Akcja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${obiekty}" var="obiekt">
					<tr>
						<td style="display:none;"><center>
								<c:out value="${obiekt.id}" />
							</center></td>
						<td><center>
								<c:out value="${obiekt.nazwa}" />
							</center></td>
						<td><center>
								<c:out value="${obiekt.powierzchnia}" />
							</center></td>
						<td><center>
								<c:out value="${obiekt.kubatura}" />
							</center></td>
						<td><center>
								<c:out value="${obiekt.liczbaUzytkownikow}" />
							</center></td>
						<td><center>
									<c:choose>
										<c:when test="${obiekt.czyCalodobowy=='true'}">
											<p>TAK</p>
										</c:when>
										<c:otherwise>
											<p>NIE</p>
										</c:otherwise>
									</c:choose>
								</center></td>
						<td align="center"><a href="delete.html?id=${obiekt.id}"
							style="height: 30px; font-size: 15px; font-style: oblique;">Usuń</a>
							<a href="edit.html?id=${obiekt.id}"
							style="height: 30px; font-size: 15px; font-style: oblique;">Edytuj</a>
							<a href="open.html?id=${obiekt.id}"
							style="height: 30px; font-size: 15px; font-style: oblique;">Otwórz</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
	<br></br>
</body>
</html>