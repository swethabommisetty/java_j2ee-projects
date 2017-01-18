<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EmployeeLoginServlet" method="post">
<table>
<tr>
<td>Enter EmployeeId:</td>
<th><input type="text" name="employeeid"/></th>
</tr>


<tr>
<td>Enter Employee DOB:</td>
<th><input type="text" name="employeedob"/></th>
</tr>

</table>
<input type="submit" value="Login" />
</form>

</body>
</html>