<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script src="Validation.js"> 

</script>
</head>

<body style="background-color:Moccasin">
<div align="center">
<h1>Employee Info</h1>

<form action="EmployeeServlet" method="post">

 <table>
    <tr>
      <td>Enter Employee Id:<sup id="star">*</sup></td>
     <td><input type="text" name="employeeId" id="employeeid" onkeypress="return clearField()"/></td>
    <td> <span id="error"></span></td>
    </tr>
    

    <tr>
      <td>Enter Employee Name:<sup id="star">*</sup></td>
      <td><input type="text" name="employeeName" id="employeename" onkeypress="return clearField()"/></td>
     <td> <span id="error"></span></td>
    </tr>

    <tr>
      <td>Enter Salary:<sup id="star">*</sup></td>
      <td><input type="text" name="employeeSalary" id="employeesalary" onkeypress="return clearField()" /></td>
    <td> <span id="error"></span></td>
    </tr>
     <tr>
      <td>Enter Location:</td>
      <td><input type="text" name="employeeLocation" /></td>
   
    </tr>
    <tr>
      <td>Enter Experience:</td>
      <td><input type="text" name="employeeExp"/></td>
    
    </tr>
    
</table>

<input type="submit" value="Submit" onclick="return validation()"/>
</form>
<form>
<a href="Sample.jsp">go back to home page</a>
</form>
</div>

</body>

</html>