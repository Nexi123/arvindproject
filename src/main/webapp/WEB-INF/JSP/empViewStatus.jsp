<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Employee View Status</title>
</head>
<body>
         <h2>${Ename} Portal</h2>
				<a href="addStatus">Add Status</a>
				<a href="editStatus">Edit Status</a>
			<!-- -	 <c:choose>
                    <c:when test="${jobRole.equals('manager')}">
			<a href="viewStatus" >View Status</a>  	
			                    </c:when>
							</c:choose>    --->
						
				<a href="index.jsp">Log Out</a>
				   <br>
				   <br>
				   <br>
				   <br>
			<table border="1">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Job Role</th>
					<th>View My Status</th>
				</tr>
				<tbody id="myTable">
		
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td><a href="<c:url value='viewByDate' />">
								<button type="button">View</button>
							</a>
						</td>
				</tr>
				</tbody>
			</table>
</body>
</html>