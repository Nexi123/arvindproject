<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add Employee</title>
</head>
<body>
	<h1>${Ename}Portal</h1>
	<a href="listdetails">View All Employees</a>
	<a href="listdetails">Edit Employee</a>
	<a href="listdetails">Remove Employee</a>
	<a href="addStatus">Add Status</a>
	<a href="editStatus">Edit Status</a>
	<a href="viewStatus">View Status</a>
	<a href="index.jsp">Log Out</a>
	<c:if test="${addedStatus}">
		<script>
			alert("data inserted");
			window.history.replaceState({}, document.title, "/"
					+ "Manager/addEmployee");
		</script>
	</c:if>
	<form:form action="addNewEmployee" method="post"
		modelAttribute="employee">
		<label for="email">Employee Name:</label>
		<form:input path="ename" id="ename" required="required" />
		<br>
		<label for="email">Email</label>
		<form:input path="email" required="required" />
		<br>
		<label for="email">Username</label>
		<form:input path="uname" required="required" />
		<br>
		<label for="email">Password</label>
		<form:input path="pass" required="required" />
		<br>
		<label for="email">Manager Id</label>
		<form:input path="mgr" value="${mgrId}" readonly="true" />
		<br>
		<label for="email">Job Role</label>
		<form:input path="job" />
		<br>
		<label for="email">Salary</label>
		<form:input path="sal" required="required" />
		<br>
		<input type="submit" value="Add Employee">
	</form:form>
</body>
</html>