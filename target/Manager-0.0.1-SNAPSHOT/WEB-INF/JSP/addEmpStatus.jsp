<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
         <title>Add Your Status</title>
    </head>
    <body>
		  <h1>${Ename} portal</h1>
		  <a href="empViewStatus" >View Status</a>		  
		  <a href="editStatus" >Edit Status</a>
		  <a href="index.jsp">Log Out</a>
		         <br>
		         <br>
		         <br>
		         <br>
		  <form action="EmployeeStatusInserted" method="post" modelAttribute="employee" >
		       Employee Id:<input path="empId" value="${emp.empId}" />
			   Employee Name:<input path="ename" value="${emp.ename}" />
			   Status:	<input path="status" type="text"/>
			   <input type="submit" value="Add My Status" >
		  </form>
    </body>
</html>