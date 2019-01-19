<!--
   Webpage to show fuel efficiency of the selected car, and ask the user to confirm their choice
-->

<html>
<head>

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:700italic' rel='stylesheet' type='text/css'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<!-- Pull make/year data from HTTP request and create a Java object -->
<%@ page import="com.gg.Model"%>
<%@ page import="com.gg.Car" %>

<%
Car car = Model.getResult(request.getParameter("make"), request.getParameter("year"), request.getParameter("model"));
boolean gasGuzzler = car.isGasGuzzler();
%>

<link rel="stylesheet" type="txt/css" href="styles.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>

<body style="background-color: 
<%
if (gasGuzzler) out.print("red");
else out.print("green");
%>
;">

<div class="centered text-center">
<p style="font-family:consolas; font-size:20px">

<font size="5" font="veranda">You Selected:</br> <!-- Print out selected items from previous form -->
<%= car.getYear() %>
<%= car.getMake() %>
<%= car.getModel() %>

<br><br>Would you like to select this car?
</font>
</br>

<form method="post" action="TripPlanner.jsp">
		<%
		//Get the fuel efficiency based on the car object
		int highway = car.getFuel();
		%>
	<input type="hidden" name="mpg" id="mpgSelect" value="<%= highway %>" />
	<input type="submit" name="submitButton" id="submitButton" value="Yes" class="btn btn-default"></button>
	
</form>
<input type="button" onclick="location.href='index.jsp';" value="No" class="btn btn-default" />

</p>
</div>

</body>
</html>