<html>
<head>

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:700italic' rel='stylesheet' type='text/css'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

<%@ page import="com.gg.Model"%>

<div class="centered text-center" style="font-family:veranda;font-size:20px">
Select which cities you want to visit
<form method="post" action="TripResults.jsp">
	
	</br></br>
	Choose a start-point
	
	<select name="start city" id="startCitySelect">

	<%
		String [] cityNames = Model.getCityNames();
		%>
		<% for (String name : cityNames) { %>
			<option> <%= name %> </option>
	<% } %>
	</select>
    <input type="hidden" name="fuel economy" id="fuel economy" value="<%= request.getParameter("mpg") %>" />
    
    </br></br>
    
    Choose your budget: $
    
    <select name="budget" id="budgetSelect">
	    <option>50</option>
		<option>100</option>
		<option>150</option>
		<option>200</option>
		<option>250</option>
		<option>300</option>
		<option>350</option>
		<option>400</option>
		<option>450</option>
		<option>500</option>
		<option>550</option>
		<option>600</option>
		<option>650</option>
		<option>700</option>
		<option>750</option>
		<option>800</option>
		<option>850</option>
		<option>900</option>
		<option>950</option>
		<option>1000</option>
    </select>
    </br></br>
    <input type="submit" name="submitButton" value="Go!" />
</form>
</div>

</body>
</html>