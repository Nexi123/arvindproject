<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Edit Employee</title>
</head>
<body>
	<h1>${Ename} Portal</h1>
	
				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<form:form action="${contextPath}/deleteEmpDetails" method="post"
								modelAttribute="emp" id="deleteForm">
							<table border="1" style="background: #dcddde; margin-top: 30px;">
				<tr class="w3-dark-grey">
					<th width="80">Employee ID</th>
					<th width="120">Name</th>
					<th width="120">Email</th>
					<th width="120">UserName</th>
					<th width="120">Password</th>
					<th width="120">Manager</th>
					<th width="120">Job</th>
					<th width="120">Salary</th>
					
				</tr>
				
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.ename}</td>
						<td>${emp.email}</td>
						<td>${emp.uname}</td>
						<td>${emp.pass}</td>
						<td>${emp.mgr}</td>
						<td>${emp.job}</td>
						<td>${emp.sal}</td>
						</tr>
						<tr>
						<td>
						<input type="submit" value="delete" />
						</td>
						</tr>
							</table>
					
									</form:form>
				</body>
</html>