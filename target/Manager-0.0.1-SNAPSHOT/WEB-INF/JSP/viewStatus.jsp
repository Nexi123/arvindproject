<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>View your Status</title>
</head>
<body>
				<h1>${Ename} portal</h1>
                    	<a href="listdetails">View All Employees</a>				
         <a href="addEmployee" >Add Employee</a>
					<a href="listdetails">Edit Employee</a>
					    <a href="listdetails" >Remove Employee</a>
					<a href="addStatus">Add Status</a>
						<a href="editStatus">Edit Status</a>					
					<a href="index.jsp">Log Out</a>
		<c:if test="${!empty employeeList}">
			<table  style="background: #dcddde; margin-top: 30px;">
				<tr class="w3-dark-grey">
					<th >Employee ID</th>
					<th >Name</th>
					
					<th width="120">Manager</th>
					<th width="120">Status</th>
					
					<th width="60">Edit</th>
					<th width="60">View</th>
				</tr>
				<tbody id="myTable">
				<c:forEach items="${employeeList}" var="emp">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.ename}</td>
					
						<td>${emp.mgr}</td>
						<td>${emp.job}</td>
						
						<td><a href="<c:url value='editStatus${emp.empId}' />">
								<button type="button">Edit</button>
							</a>
						</td>
						<td><a href="<c:url value='viewStatusByDate${emp.empId}' />">
								<button type="button">View</button>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
				<!-- Edit employee details Modal -->
				
			
				<c:if test="${!empty status}">
							<h2>Edit Employee Details</h2>
							<form:form action="" method="post" modelAttribute="employee">
									<label for="email">Employee Id:</label>
										<form:input path="empId" readonly="true" value="${emp.empId}" />
									<label for="email">Employee Name:</label>
										<form:input path="ename" value="${emp.ename}" />
									<label for="email">Manager Id</label>
										<form:input path="mgr" value="${emp.mgr}" />
									<label for="email">Status</label>
										<form:input path="job"/>
										 <select name="jobRole" required="true">
											<option value="" disabled="true" selected="selected">---
												Select ---</option>
												<c:if test="${emp.job=='Manager'}">
													<option value="Manager" selected="selected">Manager</option>
													<option value="Employee">Employee</option>
												</c:if>
												<c:if test="${emp.job=='Employee'}">
													<option value="Manager" >Manager</option>
													<option value="Employee" selected="selected">Employee</option>
												</c:if>
										</select>
									<label for="email">Date</label>
										<form:input path="mgr" value="${emp.mgr}" />
							</form:form>
				</c:if>
</body>
</html>