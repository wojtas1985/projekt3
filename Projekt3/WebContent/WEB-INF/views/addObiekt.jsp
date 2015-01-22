
<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Projekt I</title>

<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/messages_pl.js"></script>

<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">

<script>
$(function() {
$( "#tabs" ).tabs();
});
</script>

<script>
$(function() {
	$( "input[type=button], a, button" )
	.button();
	});
</script>

<script>
$(function() {
$( "#accordion" ).accordion();
});
</script>

<script type="text/javascript">
function check(value){ 
xmlHttp=GetXmlHttpObject();
var url="checkObiekt.html";
url=url+"?name="+value;
xmlHttp.onreadystatechange=stateChanged; 
xmlHttp.open("POST", url, true);
xmlHttp.send(null);
}
function stateChanged(){ 
if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 
    var showdata = xmlHttp.responseText; 
    document.getElementById("mydiv").innerHTML = showdata;
}
}
function GetXmlHttpObject(){
var xmlHttp=null;
try{
  xmlHttp=new XMLHttpRequest();
 }
catch (e) {
 try {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e){
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}
</script>

<script type="text/javascript">
$(function() {
    $('#wyslij').click(function(){
    	var x = document.getElementById('mydiv').innerHTML;
    	x=x.replace(/^\s*|\s*$/g,"");
		$("#formularz").validate({
			rules: {
	            AccordionField: {
	                required: true
	            }
	        },
	        ignore: []
			});
	if(($('#formularz').valid())&&(x=="")){
		var formularz = document.getElementById('formularz');
		formularz.submit();
		};
    });
});
	</script>

<style type="text/css">
		em, .error {
			color: red;
			font-size: 14px;
			font-style: oblique;
		}
	</style>

</head>
<body>
	<h1 align="center">Dodaj obiekt</h1>

	<form:form method="POST" action="/Projekt3/saveObiekt.html"
		id="formularz">
		<center>
			<div id="accordion" style="width: 80%;">
				<h3>Dane podstawowe (Wymagane)</h3>
				<div>
					<table align="center">
						<tr>
							<td align="left" style="display:none;"><form:label path="id">ID:</form:label></td>
							<td align="left" style="display:none;"><form:input path="id" value="${obiekt.id}"
									readonly="true" /></td>
						</tr>
						<tr>
						<td></td>
						<td align="left"><font
								style="color: red; font-size: 12px; font-style: oblique;"><div id="mydiv"></div></font></td>
						</tr>
						<tr>
							<td align="left"><form:label path="nazwa">Nazwa:</form:label></td>
							<td align="left"><form:input path="nazwa" value="${obiekt.nazwa}"
									onkeyup="check(value)" class="required" minlength="3"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="powierzchnia">Powierzchnia:</form:label></td>
							<td align="left"><form:input path="powierzchnia" id="powierzchnia"
									value="${obiekt.powierzchnia}" class="required number"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="kubatura">Kubatura:</form:label></td>
							<td align="left"><form:input path="kubatura" id="kubatura"
									value="${obiekt.kubatura}" class="required number"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="liczbaUzytkownikow">Liczba Użytkownikow:</form:label></td>
							<td align="left"><form:input path="liczbaUzytkownikow"
									id="liczbaUzytkownikow" value="${obiekt.liczbaUzytkownikow}" class="required digits"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="czyCalodobowy">Całodobowy:</form:label></td>
							<td align="left"><form:checkbox path="czyCalodobowy"
									value="${obiekt.czyCalodobowy}" /></td>
						</tr>
					</table>
				</div>
				<h3>Dane adresowe (Opcjonalne)</h3>
				<div>
					<table align="center">
						<tr>
							<td align="left"><form:label path="miejscowosc">Miejscowość:</form:label></td>
							<td align="left"><form:input path="miejscowosc"
									id="miejscowosc" value="${obiektAdres.miejscowosc}" minlength="3"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="kodPocztowy">Kod Pocztowy:</form:label></td>
							<td align="left"><form:input path="kodPocztowy"
									id="kodPocztowy" value="${obiektAdres.kodPocztowy}" class="digits" minlength="5" maxlength="5"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="ulica">Ulica:</form:label></td>
							<td align="left"><form:input path="ulica" id="ulica"
									value="${obiektAdres.ulica}" minlength="3" /></td>
						</tr>
						<tr>
							<td align="left"><form:label path="numerDomu">Numer domu:</form:label></td>
							<td align="left"><form:input path="numerDomu"
									id="numerDomu" value="${obiektAdres.numerDomu}" /></td>
						</tr>
					</table>
				</div>
				<h3>Dane kontaktowe (Opcjonalne)</h3>
				<div>
					<table align="center">
						<tr>
							<td align="left"><form:label path="telefon">Numer telefonu:</form:label></td>
							<td align="left"><form:input path="telefon"
									id="telefon" value="${obiektKontakt.telefon}" class="digits" minlength="7"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="fax">Fax:</form:label></td>
							<td align="left"><form:input path="fax" id="fax" value="${obiektKontakt.fax}" class="digits" minlength="7"/></td>
						</tr>
						<tr>
							<td align="left"><form:label path="email">Email:</form:label></td>
							<td align="left"><form:input path="email" id="email" value="${obiektKontakt.email}" class="email"/></td>
						</tr>
					</table>
				</div>
			</div>
		</center>
		<center>
			<input type="button" id="wyslij" value="Dodaj" />
		</center>
	</form:form>
</body>
</html>