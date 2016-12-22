<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Validation.js">

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>


<body style="background-color:Moccasin">
<div align="center">
<h1>Employee Info</h1>

<form action="EmployeeServlet" method="post">

 <table>
    <tr>
      <td>Enter Employee Id:</td>
      <td><input type="text" name="employeeId" /></td>
    </tr>

    <tr>
      <td>Enter Employee Name:</td>
      <td><input type="text" name="employeeName" /></td>
    </tr>

    <tr>
      <td>Enter Salary:</td>
      <td><input type="text" name="employeeSalary" /></td>
    </tr>
     <tr>
      <td>Enter Location:</td>
      <td><input type="text" name="employeeLocation" /></td>
    </tr>
    <tr>
      <td>Enter Experience:</td>
      <td><input type="text" name="employeeExp" /></td>
    </tr>
    
</table>

<input type="submit" value="Submit" onclick="return validation()">
</form>

</div>

</body>

</html>