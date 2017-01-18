<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validation()
{
var fs=document.getElementById("firstname").value;
if(fs==""||fs==null)
{
	document.getElementById("error").innerHTML="please enter name";
	return false;
}
else
	return true;
}
</script>
</head>
<body bgcolor="pink">
<h2 align="center">Registration</h2>
<font color="blue">
<form action="RegistrationServlet" method="post">
<table align="center">

<tr>
<td>Firstname:<sup id="star">*</sup></td>
<th><input type="text" name="firstname" id="firstname" onkeypress="return clearField()"/></th> 
<td> <span id="error"></span></td> 
</tr>

<tr>
<td>Lastname:</td>
<th><input type="text" name="lastname"/></th>
</tr>

<tr>
<td>fathersname:</td>
<th><input type="text" name="fathersname"/></th>
</tr>

<tr>
<td>dateofbirth:</td>
<th><input type="text" name="dob"/></th>
</tr>

<tr>
<td>mobile no:</td>
<th><input type="text" name="mobileno"/></th>
</tr>

<tr>
<td>alternate mobileno:</td>
<th><input type="text" name="mobileno1"/></th>
</tr>

<tr>
<td>mail-id:</td>
<th><input type="text" name="mail"/></th>             
</tr>

<tr>
<td>alternate mailid:</td>
<th><input type="text" name="mail1"/></th>
</tr>

<tr>
<td>present address:</td>
<th><textarea name="message" rows="10" cols="30"></textarea></th>
</tr>

<tr>
<td>permanent address:</td>
<th><textarea name="message1" rows="10" cols="30"></textarea></th>
 </tr>
 
<tr>
<td>Occupation:</td>
<th><input type="text" name="occupation"/></th>
</tr>



<tr>
<td>yearsofexp:</td>
<th><input type="text" name="exp"/></th>
</tr>

<tr>
<td>past companyname:</td>
<th><input type="text" name="name"/></th>
</tr>

<tr>
<td>pastcompanyperiod:</td>
<th><input type="text" name="period"/></th>
</tr>

<tr>
<td>dateofjoining:</td>
<th><input type="text" name="doj"/></th>         
</tr>

<tr>
<td>currentctc:</td>
<th><input type="text" name="currentctc"/></th>
</tr>

<tr>
<td>advance salary:</td>
<th><input type="text" name="ads"/></th>        
</tr>

<tr>
<td>advance salary date:</td>
<th><input type="text" name="adsd"/></th>
</tr>

<tr>
<td>advance salary terms:</td>
<th><input type="text" name="adst"/></th>
</tr>

<tr>
<td>designation:</td>
<th><select name="designation">
<option value="trainee">trainee</option>
<option value="developer">developer</option>
<option value="senior developer">senior developer</option>
<option value="software engineer">software engineer</option>
<option value="senior software engineer">senior software engineer</option>
</select></th>
</tr>

<tr>
<td>technology:</td>
<th><select name="technology">
<option value="java">java</option>
<option value="dotnet">dot net</option>
</select></th>
</tr>

<tr>
<td>past ctc:</td>
<th><input type="text" name="pastctc"/></th>
</tr>

<tr>
<td>past hike details:</td>
<th><input type="text" name="phd"/></th>
</tr>
</font>
</table>
<div align="center">
<input type="submit" name="register" onclick="return validation()"/>
</div>
</form>


</body>
</html>