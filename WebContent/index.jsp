<!--
   Homepage of website, contains form to select make/year of car 
-->

<html>
<head>

<link rel="stylesheet" type="txt/css" href="styles.css">

<meta charset="UTF-8">

<title>Trip Maker</title>

<%@ page import="com.gg.Model"%>

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:700italic' rel='stylesheet' type='text/css'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
<body>
<div class="centered text-center">
	<font size="6" face="verdana" color="green">Trip Maker</font>
</div>
<form method="post" action="SubmitForm.jsp">
<div class="centered text-center">
	<br>Year <select name="year" id="year" required onchange="newone()">
		<option selected disabled hidden style='display: none' value=''></option> <!-- Populate 'years' dropdown with year values -->
		<%
			String[] years = Model.getYears();
			for (int i = 0; i < years.length; i++) {
		%>
		
		<option> <%= years[i] %> </option>
		
		<% } %>
	</select>
	
	 <br>Make<select name="make" id="make" style="width:266px;margin-top:15px;font-size:17px" required disabled > <!-- Populate 'make' dropdown with car brands -->
		<option selected disabled hidden style='display: none' value=''></option>
		<%
			String[] make = Model.getMakes();
			for (int i = 0; i < make.length; i++) {
		%>
		
		<option> <%= make[i] %> </option>
		
		<% } %>
	</select>
	 <script>
	 
	function newone() {if(document.getElementById('year') != ''){
		document.getElementById('make').disabled = false;
	}}
	</script>
	</br>
	<input type="submit" name="searchButton" id="searchButton" value="Select Car" class="btn btn-default" style="margin-top:15px">
	</input>
</div>
</form>
</body>

</html>