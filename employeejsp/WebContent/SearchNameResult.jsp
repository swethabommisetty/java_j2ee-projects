<%@page import="java.util.Iterator"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.dhatriinfo.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dhatriinfo.dao.DAOOperations"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>

<table>
<tr>
<th>Employee Id</th>
<th>EmployeeName</th>
<th>Employee Salary</th>
<th>Employee Location</th>

</tr>



<%
String searchVariable=request.getParameter("searchRes");

if(searchVariable!=null)
{
	
	DAOOperations dao=new DAOOperations();
	ArrayList<EmployeeBean> employeeArray=dao.search1(searchVariable);
	
	if(employeeArray!=null)
	{
		EmployeeBean employeeBean=null;
		Iterator<EmployeeBean> iteratore=employeeArray.iterator();
		 while(iteratore.hasNext())
		 {
			 employeeBean=(EmployeeBean)iteratore.next();
		 }
		 
		if(employeeBean!=null)
		{
			%>
			
			<tr>
			<td><%=employeeBean.getEmployeeId() %></td>
			<td><%=employeeBean.getEmployeeName() %></td>
			<td><%=employeeBean.getEmployeeSlary() %></td>
			<td><%=employeeBean.getEmployeeLoc() %></td>
			
			</tr>
			
			<%
		}
		else
		{
			out.println("Id Not Found");
		}
		
	}
	else
	{
		out.println("No Data Fuond");
	}
	
}

%>
</table>

</div>

</body>
</html>