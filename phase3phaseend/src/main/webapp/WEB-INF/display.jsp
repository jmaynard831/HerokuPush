<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All the Tasks</title>
<style type="text/css">
td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Task Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Description</th>
				<th>Email</th>
				<th>Severity</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td>${task.getTaskName()}</td>
					<td><fmt:formatDate value="${task.getStartDate()}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${task.getEndDate()}"
							pattern="dd/MM/yyyy" /></td>
					<td>${task.getTaskdesc()}</td>
					<td>${task.getEmail()}</td>
					<td>${task.getSeverity()}</td>
					<td><a type="button" class="btn btn-warning"
						href="/delete?taskID=${task.getTaskID()}">Delete</a></td>
					<td><a type="button" class="btn btn-success"
						href="/update?taskID=${task.getTaskID()}">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>