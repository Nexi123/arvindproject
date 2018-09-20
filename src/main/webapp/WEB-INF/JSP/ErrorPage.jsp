<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR</title>
</head>
<body>
<h1>${errorPage}</h1>
<form action="/Manager/login" id="loginform" method="post">
		<table align="center">
			  <tr>
				  <td>UserName:<input id="login-username" type="text" name="username"></td>
			  </tr>
			  <tr>
			      <td>Password:<input id="login-password" type="password" name="password"></td>
			  </tr>
			  <tr>
			       <td colspan="2"><input type="submit" value="login"/></td>
			  </tr>
		</table>
	 </form>
</body>
</body>
</html>