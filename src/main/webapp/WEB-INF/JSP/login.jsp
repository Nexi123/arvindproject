<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
      	<title>Welcome</title>
	<head>
	<body>
		<%String jobRole=(String)session.getAttribute("jobRole");%>
	
				<h1>Welcome ${Ename}</h1>
				<h3>You are ${jobRole}</h3>
				
			    <c:choose>
                    <c:when test="${jobRole.equals('Manager')}">
                    	<h1>Welcome to Employee Management System!!!!</h1>
                    	<a href="listdetails">View All Employees</a>
                    	<a href="addEmployee">Add Employee</a>
						<a href="listdetails" >Edit Employee</a>
					    <a href="listdetails" >Remove Employee</a>
						<a href="viewStatus">View Status</a>
						<a href="addStatus">Add Status</a>
						<a href="editStatus">Edit Status</a>
  						<a href="index.jsp">Log Out</a>
                    </c:when>
                    
                    <c:when test="${jobRole.equals('Employee')}">
						<a href="empViewStatus">View Status</a>
						<a href="addStatus">Add Status</a>
						<a href="editStatus">Edit Status</a>
						<a href="index.jsp">Log Out</a>
    				</c:when>
				</c:choose>
	</body>
</html>