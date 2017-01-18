<%@page import="java.util.Iterator"%>
<%@page import="com.dhatriinfo.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchIdServlet" method="post">

Enter id to search:<input type="text" name="searchElement"/>
<input type="submit" value="Search">
</form>

<div align="center">
<%

Object obj=session.getAttribute("employeeList");

if(obj!=null)
{
	%>
	<table>
<tr>
<th>EmployeeId</th>
<th>EmployeeName</th>
<th>EmployeeSalary</th>
<th>EmployeeLocation</th>
<th>EmployeeExp</th>
</tr>
	<%
	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		%>
		<tr>
<td> <%=employeebean.getEmployeeId() %> </td>	
<td> <%=employeebean.getEmployeeName() %>	</td>
<td> <%=employeebean.getEmployeeSlary() %></td>
<td><%=employeebean.getEmployeeLoc() %></td>
<td><%=employeebean.getEmployeeExp() %></td>
		
		</tr>
		
	<%	
	}
	session.removeAttribute("employeeList");
	
}



else
{
	out.print("No Data");
}

%>
</table>
<form>
<a href="Sample.jsp">go back to home page</a>
</form>
</div>
</body>
</html>