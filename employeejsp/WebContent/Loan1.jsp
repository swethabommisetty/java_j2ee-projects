<%@page import="java.util.Iterator"%>
<%@page import="com.dhatriinfo.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dhatriinfo.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully Applied For Loan</title>
</head>
<body style="background-color: pink">
<div align="center">
<%

Object obj=session.getAttribute("employeelist");
DAOOperations dbo=new DAOOperations();
//String empid=(String)session.getAttribute("tempid");
//out.print("Applied Employee Id for loan" );
EmployeeBean emp=null;

if(obj!=null)
{
	%>
	<table>
	<tr>
	<th>Employee Id |</th>
	<th>Employee Loan |</th>
	<th>Employee EMI</th>
	</tr>
	<%
	ArrayList<EmployeeBean> empList=(ArrayList)obj;
	Iterator it=empList.iterator();
	//EmployeeBean emp=null;
	while(it.hasNext())
	{
		emp=(EmployeeBean)it.next();
		
	%>
		<tr>
		<td><%=emp.getEmployeeId() %></td>
		<td><%=emp.getEmployeeLoan() %></td>
		<td><%=emp.getEmployeeEmi() %></td>
		</tr>
		<%
	}
	session.removeAttribute("empList");
}
else			
{
	out.print("no data");
}
%>



	
</table>
<br>
<br>

	<form action="LoanServlet1" method="post">
	
	<input type="text" value="<%=emp.getEmployeeId() %>" name="tempid" readonly />
	<input type="submit" value="proceed">
	
	</form>
<form>
<a href="Sample.jsp">go back to home page</a>
</form>
	


</div>
</body>
</html>
