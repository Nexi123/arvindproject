<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Edit Employee</title>
</head>
<body>
	<h1>${Ename} Portal</h1>
	<!-- <a href="listdetails">View All Employees</a>
				<a href="addEmployee" >Add Employee</a>
				 <a href="listdetails" >Remove Employee</a>
                <a href="addStatus" >Add Status</a>
                <a href="viewStatus" >View Status</a>
                <a href="editStatus">Edit Status</a>
				<a href="index.jsp">Log Out</a> -->
				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<form:form action="${contextPath}/upadteEditEmpDetails" method="post"
								modelAttribute="employee" id="editForm">
							Employee Id:<form:input path="empId" value="${emp.empId}" /><br>
							Employee Name:<form:input path="ename" value="${emp.ename}" /><br>
							Email:<form:input path="email" value="${emp.email}" /><br>
							Username:<form:input path="uname" value="${emp.uname}" /><br>
							Password:<form:input path="pass" value="${emp.pass}" /><br>
								ManagerId:<form:input path="mgr"  value="${emp.mgr}" /><br>
								Job Role:<form:input path="job" value="${emp.job}"/><br>
								Salary:<form:input path="sal"  value="${emp.sal}" /><br>
								<input type="submit" value="Save" />
						</form:form>
				</body>
</html>