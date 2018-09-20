<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
      <title>edit your status</title>
  </head>
  <body>
	 <h1>${Ename} Portal</h1>
	 <a href="empViewStatus" >View Status</a>		  
		  <a href="editStatus" >Edit Status</a>
			<a href="index.jsp">Log Out</a>
		 <form action="findStatus" method="post" modelAttribute="status" >
								Employee Id:<input value="${empId}" name="id" />
								Date:<input type="date" id="date" name="date" value="${status.date}"/>
								<c:if test="${emptyStatus}">
									<script>
										alert("Status not found for the given Date");
										var date=document.getElementById("date");
										date.value="";
										date.focus();
			
									</script>
								</c:if>
								</form>
								<c:if test="${!empty status1 }">
								<script>
									document.getElementById("date").readOnly=true;
								</script>
								<form action="submitEditStatus" modelAttribute="status" >
									Emp Id:<input value="${status1.empId}" path="empId" />
									Date:<input value="${status1.date}" path="date" />
					                Status:										
									<select name="statusValue"  required="true">
									   <option value="" disabled="true" selected="selected">--- Select ---</option> 
										<c:if test="${status1.status=='present'}">
											<option value="present" selected="true">Present</option>
									  		<option value="absent">Absent</option>
										</c:if>
										<c:if test="${status1.status=='absent' }">
										   <option value="present">Present</option>
										   <option value="absent" selected="true">Absent</option>
										</c:if>
									</select> 
									<input type="submit" value="Edit Status">
								</form>
								</c:if>
</body>
</html>