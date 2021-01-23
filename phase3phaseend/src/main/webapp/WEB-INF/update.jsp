<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update task</title>
</head>
<body>
${task.getStartDate().toString().substring(0, 10)}
<form method="post" action="/update">
TaskID: <input type="text" name="TaskID" value="${task.getTaskID()}" readonly> <br>
Name: <input type="text" name="taskName" value="${task.getTaskName()}"><br>
Start Date: <input type="date" name="startDate" value="${task.getStartDate().toString().substring(0, 10)}"><br>
End Date: <input type="date" name="endDate" value="${task.getEndDate().toString().substring(0, 10)}"><br>
Description: <input type="text" name="taskdesc" value="${task.getTaskdesc()}"><br>
Email: <input type="email" name="email" value="${task.getEmail()}"><br>
Severity: <input list="severity" name="severity" value="${task.getSeverity()}" >
	<datalist  id="severity">
	<option value="High" selected="selected">
	<option value="Medium">
	<option value="Low">
	</datalist>
<input type="submit">
</form>

</body>
</html>