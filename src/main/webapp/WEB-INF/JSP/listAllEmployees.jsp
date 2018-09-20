<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
       <title>All Employees</title>
    </head>
    <body>
        <h1> ${Ename} portal</h1>
				<a href="addEmployee" >Add Employee</a>
				<a href="listdetails">Edit Employee</a>
				<a href="listdetails" >Remove Employee</a>
					<a href="viewStatus" >View Status</a>
					<a href="addStatus">Add Status</a>
				   <a href="editStatus">Edit Status</a>
				<a href="index.jsp">Log Out</a>
     		<c:if test="${!empty employeeList}">
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
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<tbody id="myTable">
				<c:forEach items="${employeeList}" var="emp">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.ename}</td>
						<td>${emp.email}</td>
						<td>${emp.uname}</td>
						<td>${emp.pass}</td>
						<td>${emp.mgr}</td>
						<td>${emp.job}</td>
						<td>${emp.sal}</td>
						<td><a href="<c:url value='/edit/${emp.empId}'/>">
								<button type="button" class="btn btn-info" >Edit</button>
							</a>
						</td>
						<td><a href="<c:url value='/remove/${emp.empId}' />">
								<button type="button" class="btn btn-danger">Delete</button>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
</body>
</html>