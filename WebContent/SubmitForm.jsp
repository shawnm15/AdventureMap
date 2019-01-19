<!--
   Allows the user to select a specific make of car
-->

<html>
<head>

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:700italic' rel='stylesheet' type='text/css'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>

<body>

<%@ page import="com.gg.Model"%>

<div class="centered text-center">
	<font size="6" face="verdana" color="green">Select Your Model</font>

<form method="post" action="NextPage.jsp">
	<select name="model" id="modelSelect" style="margin-top:15px">
	
		<%
		String [] models = Model.searchModels(request.getParameter("make"), request.getParameter("year"));
		%>
		<%for (int i = 0; i < models.length; i++) {%>
			<option><%= models[i] %></option>
		<%}%>
		
	</select>
	
	<input type="hidden" name="make" id="makeSelect" value="<%out.print(request.getParameter("make"));%>" />
	<input type="hidden" name="year" id="yearSelect" value="<%out.print(request.getParameter("year"));%>" /> </br>
	<input type="submit" name="submitButton" id="submitButton" class="btn btn-default" style="margin-top:15px"></button>
</form>
</div>

</body>
</html>