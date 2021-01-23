<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a task</title>
</head>
<body>
<h1>Welcome, ${user.getUsername()}</h1><br><br>

Make a task:
<form method="post" action="/creation">
<!--UserID: <input type="text" name="userID" value=${user.getUserID()} readonly> <br>-->
Name: <input type="text" name="taskName" value="jake"><br>
Start Date: <input type="date" name="startDate" value="2015-08-31"><br>
End Date: <input type="date" name="endDate" value="2017-08-31"><br>
Description: <input type="text" name="taskdesc" value="blorgia"><br>
Email: <input type="email" name="email" value="joe@html.com"><br>
Severity: <input list="severity" name="severity">
	<datalist  id="severity">
	<option value="High" selected="selected">
	<option value="Medium">
	<option value="Low">
	</datalist>
<input type="submit">
</form>


</body>
</html>