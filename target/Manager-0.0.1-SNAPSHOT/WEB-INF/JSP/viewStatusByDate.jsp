<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>View Status by Date </title>
</head>
<body>
				<h1>${Ename} portal</h1>
					<a href="addEmployee">Add Employee</a>
					<a href="listdetails">Edit Employee</a>
					<a href="addStatus">Add Status</a>
					<a href="viewStatus">View Status</a>
					<a href="index.jsp">Log Out</a>
						<form action="getDetailsByDate" name="myForm">
								<label for="email">Start Date:</label>
								<input name="startDate" type="date"/>
								<label for="email">End Date:</label>
								<input name="endDate" type="date"/>
								<input type="submit" value="Search">
						</form>	
						<c:if test="${!empty statusList}">
						<header>
							<h2>Status</h2>
						</header>
							<table style="background: #dcddde; margin-top: 30px;">
								<tr class="w3-dark-grey">
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