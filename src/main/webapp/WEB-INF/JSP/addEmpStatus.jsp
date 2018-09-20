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
		         <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<form action="${contextPath}/EmployeeStatusInserted" method="post"
								modelAttribute="employee"  id="statusForm">
		       Employee Id:<input  value="${emp.empId}" name="empId" id="statusForm"  />
			   Employee Name:<input value="${emp.ename}" />
			    Status:<input  type="text" name="status" id="statusForm"/> 
			   <input type="submit" value="Add My Status" >
		  </form>
		   
    </body>
</html>