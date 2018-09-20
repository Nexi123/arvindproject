<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
       <title>Your Status</title>
   </head>
   <body>
	    <h2>${Ename} portal</h2>
		<a href="addStatus" >Add Status</a>
		<a href="editStatus" >Edit Status</a>
		<a href="index.jsp">Log Out</a>
					
		<form action="getDetailsByDate" name="myForm" >
			Start Date:	<input name="startDate" type="date"  autocomplete="off"/>
			End Date: <input name="endDate" type="date"  autocomplete="off"/>
			<input type="submit" value="Search" >
		</form>	
		<c:if test="${!empty statusList}">
			<h2>Status</h2>
			<table>
				<tr>
				     <th>Date</th>
					 <th>Status</th>
				</tr>
				<tbody id="myTable">
					<c:forEach items="${statusList}" var="st">
					   <tr>
							<td>${st.date}</td>
							<c:if test="${st.status=='present'}">
							     <td>${st.status}</td>
							</c:if>
							<c:if test="${st.status=='absent'}">
								<td>${st.status}</td>
							</c:if>
					   </tr>
				   </c:forEach>
				</tbody>
			</table>
		</c:if>
    </body>
</html>