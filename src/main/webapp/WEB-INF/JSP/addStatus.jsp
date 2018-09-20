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
		 <table  border="1">
			<tr>
				<th>Employee ID</th>
				<th>Name</th>
				<th>Job Role</th>
				<th>Add My Status</th>
			</tr>
			<tbody id="myTable">
			<tr>
				<td>${emp.empId}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<c:if test="${statusExists}">
				   <td><a href="<c:url value='addStatus${emp.empId}' />">
								<button type="button" >Add</button>
							</a></td>
				 </c:if>
				 <c:if test="${!statusExists}">
					 <td><a href="<c:url value='addStatus${emp.empId}' />">
									<button type="button">Add</button>
								</a></td>
				  </c:if>
			 </tr>
			 </tbody>
		 </table>
    </body>
</html>