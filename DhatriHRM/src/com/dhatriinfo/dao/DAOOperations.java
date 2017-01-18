package com.dhatriinfo.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.dhatriinfo.bean.EmployeeBean;

public class DAOOperations {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public DAOOperations() {
		connection = MyConnection.getInstance().connec;
	}

	public int insertData(EmployeeBean employeeBean) {
		int result = 0;
		String query = "insert into employee values(?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employeeBean.getEmployeeId());
			preparedStatement.setString(2, employeeBean.getEmployeeName());
			preparedStatement.setInt(3, employeeBean.getEmployeeSlary());
			preparedStatement.setString(4, employeeBean.getEmployeeLoc());
			preparedStatement.setInt(5, employeeBean.getEmployeeLoan());
			preparedStatement.setInt(6, employeeBean.getEmployeeExp());

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	
	public ArrayList<EmployeeBean> search()
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select * from employee ";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			//preparedStatement.setString(1, searchElement);
			
			resultSet=preparedStatement.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				empBean.setEmployeeSalary(resultSet.getInt(3));
				empBean.setEmployeeLoc(resultSet.getString(4));
				empBean.setEmployeeExp(resultSet.getInt(5));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return employeeList;
	}
	public ArrayList<EmployeeBean> search(String searchElement)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan from employee where employeeId=?";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, searchElement);
			
			resultSet=preparedStatement.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				empBean.setEmployeeSalary(resultSet.getInt(3));
				empBean.setEmployeeLoc(resultSet.getString(4));
				empBean.setEmployeeExp(resultSet.getInt(5));
				empBean.setEmployeeLoan(resultSet.getInt(6));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return employeeList;
	}
	
	public void update(String eId,String empName,int empSalary,int empExp,String empLoc,int empLoan )
	{
		
		String query="update employee set employeeName=?,employeeSlary=?,employeeExp=?,employeeLoc=?,employeeLoan=? where employeeId=?";
	try
	{
		preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setString(1,empName);
		preparedStatement.setInt(2,empSalary);
		preparedStatement.setInt(3,empExp);
		preparedStatement.setString(4,empLoc);
		preparedStatement.setInt(5,empLoan);
		
		preparedStatement.setString(6,eId);
		
		int x=	preparedStatement.executeUpdate();
		
    System.out.println("updated rows:"+ x);
		
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}	
	
	public void delete(String empId)
	{
		
		String query="delete from employee where employeeId=?";
		
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, empId);
			
			int x=	preparedStatement.executeUpdate();
			System.out.println("deleted rows:"+ x);

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void loan(int eLoan,String Id) throws Exception
	
	{
		
		ArrayList<EmployeeBean> loe=search(Id);
		Iterator<EmployeeBean> itt=loe.iterator();
		EmployeeBean ee=null;
		while(itt.hasNext())
		{
		ee=(EmployeeBean)itt.next();
		
		if(ee.getEmployeeExp()>2 && ee.getEmployeeExp()<4)
		{
			eLoan=ee.getEmployeeSlary()/2;
			ee.setEmployeeLoan(eLoan);
			System.out.println("loan=" +eLoan);
			
		}
		else
		{
			eLoan=ee.getEmployeeSlary()+100;
			ee.setEmployeeLoan(eLoan);
			System.out.println("not eligible for loan");
			
		}
	}
		String query="update employee set employeeLoan=? where employeeId=?";

		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, eLoan);
		preparedStatement.setString(2, Id);
		int x=preparedStatement.executeUpdate();
		
		System.out.println("Updated rows="+x);		

	}
}
