<%@page import="java.util.Iterator"%>
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
<form action="UpdateServlet" method="post">
<table>
<tr>
<th>Employee Id</th>
<th>EmployeeName</th>
<th>Employee Salary</th>
<th>Employee Location</th>
<th>Employee Exp </th>
</tr>



<%
String updateVariable=request.getParameter("updateRes");

if(updateVariable!=null)
{
	DAOOperations dbo=new DAOOperations();
	
	
	ArrayList<EmployeeBean> empList=dbo.search(updateVariable);
	

	if(empList!=null)
	{
	%>

		<% 
		
		Iterator iterator=empList.iterator();
		EmployeeBean employeebean=null;
		while(iterator.hasNext())
		{
			employeebean=(EmployeeBean)iterator.next();
		%>
			<tr>
			
	<td>Employee Id:<br><input type="text" value="<%= employeebean.getEmployeeId() %>" name="eid" readonly/></td>
	<td>Employee Name:<input type="text" value="<%= employeebean.getEmployeeName()  %>" name="ename"/></td>
	<td>Employee Salary:<input type="text" value="<%= employeebean.getEmployeeSlary() %>" name="esal"/></td>
	<td>Employee loc:<input type="text" value="<%= employeebean.getEmployeeLoc() %>" name="eloc"/></td>
	<td>Employee exp:<input type="text" value="<%= employeebean.getEmployeeExp() %>" name="eexp"/></td>


			</tr>
			
		<%
		}
		
		
	}
	else
		
	{
		out.print("No Data");
	}

	
}
%>
</table>  
    
     <input type="submit" value="update"/>
    
 </form>
</div>

</body>
</html>