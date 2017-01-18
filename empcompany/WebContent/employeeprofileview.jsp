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
<title>View Employee Details</title>
</head>
<body align="center">

<div align="center">
<h2>View </h2>
</div>

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
<td><input type="text" value="<%= employeebean.getFirstname()%>" name="ename" /></td>
</tr>

<tr>
<td>Employee Last Name:</td>
<td><input type="text" value="<%= employeebean.getLastname()%>" name="esal"/></td>
</tr>

<tr>
<td>Employee dob:</td>
<td><input type="text" value="<%= employeebean.getDob()%>" name="eexp" /></td>
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

<%
Object obj1=session.getAttribute("employeelist1");

if(obj1!=null)
{

	ArrayList<CompanyBean> cmployeeList=(ArrayList)obj1;
	Iterator iterator=cmployeeList.iterator();
	CompanyBean cmployeebean=null;
	while(iterator.hasNext())
	{
		cmployeebean=(CompanyBean)iterator.next();
		%>
		
<table align="center">

<tr>
<td>Employee Yearsofexp:</td>
<td><input type="text" value="<%= cmployeebean.getYearsofexp()%>" name="exp" /></td>
</tr>

<tr>
<td>Employee Pastcompany Name:</td>
<td><input type="text" value="<%= cmployeebean.getPastcompanyname()%>" name="name"/></td>
</tr>

<tr>
<td>Employee Pastcompany:</td>
<td><input type="text" value="<%= cmployeebean.getPastcompanyperiod()%>" name="period" /></td>
</tr>

<tr>
<td>Employee date of joining:</td>
<td><input type="text" value="<%= cmployeebean.getDateofjoining()%>" name="doj" /></td>
</tr>


<tr>
<td>Employee current ctc:</td>
<td><input type="text" value="<%= cmployeebean.getCurrentctc()%>" name="cctc" /></td>
</tr>

<tr>
<td>Employee advance sal:</td>
<td><input type="text" value="<%= cmployeebean.getAdvancesal()%>" name="ads" /></td>
</tr>

<tr>
<td>Employee adv sal date:</td>
<td><input type="text" value="<%= cmployeebean.getAdvancesaldate()%>" name="adsd" /></td>
</tr>


<tr>
<td>Employee adv sal terms:</td>
<td><input type="text" value="<%= cmployeebean.getAdvancesalterms()%>" name="adst" /></td>
</tr>

<tr>
<td>Employee designation:</td>
<td><input type="text" value="<%= cmployeebean.getDesignation()%>" name="designation" /></td>
</tr>

<tr>
<td>Employee Technology:</td>
<td><input type="text" value="<%= cmployeebean.getTechnology()%>" name="technology" /></td>
</tr>

<tr>
<td>Employee past ctc:</td>
<td><input type="text" value="<%= cmployeebean.getPastctc()%>" name="pctc" /></td>
</tr>

<tr>
<td>Employee past hike details:</td>
<td><input type="text" value="<%= cmployeebean.getPasthikedetails()%>" name="phd" /></td>
</tr>
		</table>
		
	<%	
	}
	session.removeAttribute("employeeList1");
	
}
else
	
{
	out.print("No Data");
}
%>
</body>
</html>