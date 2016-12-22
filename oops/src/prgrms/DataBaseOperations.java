package prgrms;
import java.sql.*;


import java.util.*;
import com.mysql.jdbc.Statement;
	public class DataBaseOperations 
	{
		Connection connection;
		java.sql.Statement statementRef;
		PreparedStatement statement;
		ResultSet resultSet;
		
		public DataBaseOperations()
		{
			connection=MyConnection.getInstance().connection;
		}
		
		
		public int insertDataUsingPrepared(Employee employee)
		{
			int result=0;
			
			String query="insert into employee values(?,?,?,?,?,?)";
			
			try {
				statement=connection.prepareStatement(query);
				
				statement.setInt(1, employee.getEmployeeId());
				statement.setString(2, employee.getEmployeeName());
				statement.setInt(3, employee.getEmployeeSlary());
				statement.setString(4, employee.getEmployeeLoc());
				statement.setInt(5, employee.getEmployeeLoan());
				statement.setInt(6, employee.getEmployeeExp());
				result=statement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return result;
			
			
		}
		
		public void delete(int empId)
		{
			
			String query="delete from employee where employeeId=?";
			
			try 
			{
				statement=connection.prepareStatement(query);
				
				statement.setInt(1, empId);
				
				int x=	statement.executeUpdate();
				System.out.println("deleted rows:"+ x);

			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void update(int eid,String empName,int empSal,String empLoc,int empLoan,int empExp)
		{
			String query="update employee set employeeName=?,employeeSlary=?,employeeLoc=?,employeeLoan=?,employeeExp=? where employeeId=?";
			try 
			{
				statement=connection.prepareStatement(query);
				
				statement.setString(1, empName);
				statement.setInt(2, empSal);
				statement.setString(3, empLoc);
				statement.setInt(4, empLoan);
				statement.setInt(5, empExp);
				statement.setInt(6, eid);
				int x=statement.executeUpdate();
				System.out.println("Updated rows="+x);
			}
			
			catch (SQLException e)
			{
					e.printStackTrace();
			}

		}
		
		public ArrayList<Employee> search(int employeeId)
		{
			ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
			
			Employee employeeRef=null;
			
			String query="select * from employee where employeeId=?";
			
			try {
				statement=connection.prepareStatement(query);
				
				statement.setInt(1, employeeId);
				
				resultSet=statement.executeQuery();
				
				while(resultSet.next())
				{
					employeeRef=new Employee();
					employeeRef.setEmployeeId(resultSet.getInt(1));
					employeeRef.setEmployeeName(resultSet.getString(2));
					employeeRef.setEmployeeSlary(resultSet.getInt(3));
					employeeRef.setEmployeeLoc(resultSet.getString(4));
					employeeRef.setEmployeeLoan(resultSet.getInt(5));
					employeeRef.setEmployeeExp(resultSet.getInt(6));
					listOfEmployee.add(employeeRef);
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return listOfEmployee;
		}

		public void loan(int eLoan,int empid) throws Exception
		
		{
			
			ArrayList<Employee> loe=search(empid);
			Iterator<Employee> it=loe.iterator();
			
			while(it.hasNext())
			{
			Employee ee=(Employee)it.next();
			
			if(ee.getEmployeeExp()>2 && ee.getEmployeeExp()<4)
			{
				eLoan=ee.getEmployeeSlary()/2;
				ee.setEmployeeLoan(eLoan);
				System.out.println("loan"+eLoan);
			}
			else
			{
				System.out.println("not eligible for loan");
				
			}
			}
			String query="update employee set employeeLoan=? where employeeId=?";

			statement=connection.prepareStatement(query);
			statement.setInt(1, eLoan);
			statement.setInt(2, empid);
		
			int x=statement.executeUpdate();
			
			System.out.println("Updated rows="+x);	
			
			
		}

}
