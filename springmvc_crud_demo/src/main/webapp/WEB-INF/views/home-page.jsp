<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
</head>
<body>

<h2>Add New Task!</h2>

<form action="addTask" method="post">
<label for="taskId">Task Id :</label>
<input name="taskId" type="text" />
<label for="taskName">Task Name :</label>
<input name="taskName" type="text" />
<label for="status" > Status :</label>
<input name="status" type="text" />
<br />

<input type="submit" value="Add Task">


</form>
<br/>
<hr/>

<table border="2">

<tr>
	<th>TaskId </th>
	<th>Task Name </th>
	<th>Status </th>
	<th>Update</th>
	<th>Delete</th>
</tr>

<c:forEach var="task" items="${taskList}">
  <tr>
  	<td>${task.taskid}</td>
  	<td>${task.taskName}</td>
  	<td>${task.status}</td>
  	<td><a href="update/${task.taskid}"><button>Update</button></a></td>
  	<td><a href="delete/${task.taskid}"><button>Delete</button></a></td>
  </tr>	
</c:forEach>

	

</table>

</body>
</html>