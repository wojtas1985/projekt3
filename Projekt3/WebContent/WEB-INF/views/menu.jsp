<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="<%= request.getContextPath() %>/resources/js/ddaccordion.js"></script>
<link type="text/css"
	href="<%= request.getContextPath() %>/resources/css/jquery-ui-1.10.0.custom.css"
	rel="stylesheet">

	<script>
$(function() {
	$( "input[type=submit], a, button" )
	.button();
	});
</script>

	<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='resources/img/plus.gif' class='statusicon' />", "<img src='resources/img/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
});


</script>


	<style type="text/css">
.glossymenu {
	margin: 5px 0;
	padding: 0;
	width: 170px; /*width of menu*/
	border-bottom-width: 0;
}

.glossymenu a.menuitem {
	background:
		url("<%= request.getContextPath() %>/resources/img/tymo.png") repeat-x
		bottom left;
	font: bold 16px "Lucida Grande", "Trebuchet MS", Verdana, Helvetica,
		sans-serif;
	color: white;
	display: block;
	position: relative;
	/*To help in the anchoring of the ".statusicon" icon image*/
	width: auto;
	padding: 4px 0;
	padding-left: 10px;
	text-decoration: none;
}

.glossymenu a.menuitem:visited,.glossymenu .menuitem:active {
	color: white;
}

.glossymenu a.menuitem .statusicon {
	/*CSS for icon image that gets dynamically added to headers*/
	position: absolute;
	top: 5px;
	right: 5px;
	border: none;
}

.glossymenu a.menuitem:hover {
	background-image:
		url("<%= request.getContextPath() %>/resources/img/tymo2.png");
}

.glossymenu div.submenu { /*DIV that contains each sub menu*/
	
}

.glossymenu div.submenu ul { /*UL of each sub menu*/
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.glossymenu div.submenu ul li {
	border-bottom: 1px solid blue;
}

.glossymenu div.submenu ul li a {
	display: block;
	font: normal 13px "Lucida Grande", "Trebuchet MS", Verdana, Helvetica,
		sans-serif;
	color: white;
	text-decoration: none;
	padding: 2px 0;
	padding-left: 10px;
}

.glossymenu div.submenu ul li a:hover {
	background: #DFDCCB;
	color: black;
}
</style>
</head>

<body>

	<div class="glossymenu">
		<a class="menuitem submenuheader">OBIEKTY</a>
		<div class="submenu">
			<ul>
				<li><a href="obiekt.html">Dodaj obiekt</a></li>
				<li><a href="obiekty.html">Lista obiektów</a></li>
			</ul>
		</div>
		<a class="menuitem submenuheader">ZARZĄDCY</a>
		<div class="submenu">
			<ul>
				<li><a href="zarzadca.html">Dodaj zarządcę obiektu</a></li>
			</ul>
		</div>
		<a class="menuitem submenuheader">ODCZYTY</a>
		<div class="submenu">
			<ul>
				<li><a href="odczyt.html">Dodaj odczyt</a></li>
				<li><a href="odczyty.html">Lista odczytów</a></li>
				<li><a href="odczytyPLN.html">Lista odczytów PLN</a></li>
			</ul>
		</div>
		<a class="menuitem submenuheader">WYDATKI</a>
		<div class="submenu">
			<ul>
				<li><a href="internet.html">Dodaj wydatek na internet</a></li>
				<li><a href="calkowiteWydatkiInternet.html">Wydatki na internet</a></li>
				<li><a href="telefon.html">Dodaj wydatek na telefon</a></li>
				<li><a href="calkowiteWydatkiTelefon.html">Wydatki na telefon</a></li>
			</ul>
		</div>
		<a class="menuitem submenuheader">STATYSTYKI</a>
		<div class="submenu">
			<ul>
				<li><a href="calkowiteZuzycie.html">Całkowite zużycie</a></li>
				<li><a href="jednostkoweZuzycie.html">Zużycie na m2</a></li>
				<li><a href="calkowiteKoszty.html">Całkowite koszty</a></li>
				<li><a href="jednostkoweKoszty.html">Jednostkowe koszty</a></li>
			</ul>
		</div>
		<a class="menuitem submenuheader">UŻYTKOWNICY</a>
		<div class="submenu">
			<ul>
				<li><a href="addUser.html">Dodaj użytkownika</a></li>
			</ul>
		</div>
		<a class="menuitem" href="j_spring_security_logout">WYLOGUJ</a>
	</div>

</body>
</html>