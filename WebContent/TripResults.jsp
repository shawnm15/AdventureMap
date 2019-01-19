<html>
<head>

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:700italic' rel='stylesheet' type='text/css'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<%@ page import="com.gg.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%

String startCity = request.getParameter("start city"); 
String budgetStr = request.getParameter("budget");
String fuelEconomyStr = request.getParameter("fuel economy");

Result r = TripPlanner.getTrip(Integer.parseInt(budgetStr), Integer.parseInt(fuelEconomyStr), startCity);

Stack<DirectedEdge> path = r.path;
WeightedGraph<City> highways = r.highways;

for (DirectedEdge d : path) {
	City c = highways.atIndex(d.from());
	City k = highways.atIndex(d.to());
	
	out.print(c.getName() + " -> " + k.getName()); %> </br> <%
}

%>

<!--  And with this data we calculate the actual path and print it onto the screen -->
</body>
</html>