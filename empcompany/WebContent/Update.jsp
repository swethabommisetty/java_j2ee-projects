<%@page import="java.util.Iterator"%>
<%@page import="com.user.bean.UserBean"%>
<%@page import="com.user.bean.CompanyBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<div align="center">
<h2>View </h2>
</div>
<form action="Update2Servlet" method="post">
<%
Object obj=session.getAttribute("employeelist");

if(obj!=null)
{
	


	
	ArrayList<UserBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	UserBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(UserBean)iterator.next();
		%>
		
<table align="center">

<tr>
<td>Employee Id:</td>
<td><input type="text" value="<%= employeebean.getEmpid() %>" name="eid" readonly/></td>
</tr>

<tr>
<td>Employee FirstName:</td>
<td><input type="text" value="<%= employeebean.getFirstname()%>" name="firstname" /></td>
</tr>

<tr>
<td>Employee Last Name:</td>
<td><input type="text" value="<%= employeebean.getLastname()%>" name="lastname"/></td>
</tr>

<tr>
<td>Employee dob:</td>
<td><input type="text" value="<%= employeebean.getDob()%>" name="dob" /></td>
</tr>

<tr>
<td>Employee mobile no :</td>
<td><input type="text" value="<%= employeebean.getMobileno()%>" name="mob" /></td>
</tr>

<tr>
<td>Employee email:</td>
<td><input type="text" value="<%= employeebean.getEmail()%>" name="mail" /></td>
</tr>

<tr>
<td>Employee alternate email:</td>
<td><input type="text" value="<%= employeebean.getAlternatemail()%>" name="mail1" /></td>
</tr>

<tr>
<td>Employee alternate mobile no :</td>
<td><input type="text" value="<%= employeebean.getAlternatemob()%>" name="mob1" /></td>
</tr>

<tr>
<td>Employee present add :</td>
<td><input type="text" value="<%= employeebean.getPresentadd()%>" name="message" /></td>
</tr>

<tr>
<td>Employee permanent add :</td>
<td><input type="text" value="<%= employeebean.getPermanentadd()%>" name="message1" /></td>
</tr>

<tr>
<td>Employee fathers name :</td>
<td><input type="text" value="<%= employeebean.getFathersname()%>" name="fathersname" /></td>
</tr>

<tr>
<td>Employee occupation :</td>
<td><input type="text" value="<%= employeebean.getOccupation()%>" name="occupation" /></td>
</tr>
		</table>
		
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	out.print("No Data");
}
%>

<input type="submit" value="update"/>
</form>
</body>
</html>