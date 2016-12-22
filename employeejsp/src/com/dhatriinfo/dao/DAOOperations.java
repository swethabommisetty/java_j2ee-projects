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
				
				empBean.setEmployeeSlary(resultSet.getInt(3));
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
	public ArrayList<EmployeeBean> search1(String searchname)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan from employee where employeeName=?";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, searchname);
			
			resultSet=preparedStatement.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				
				empBean.setEmployeeSlary(resultSet.getInt(3));
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
	public ArrayList<EmployeeBean> search2(int searchsal)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan from employee where employeeSlary=?";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, searchsal);
			
			resultSet=preparedStatement.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				
				empBean.setEmployeeSlary(resultSet.getInt(3));
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
	
	public int update(String eId,String empName,int empSalary,int empExp,String empLoc,int empLoan )
	{
		int x=0;
		String query="update employee set employeeName=?,employeeSlary=?,employeeLoc=?,employeeLoan=?,employeeExp=? where employeeId=?";
	try
	{
		preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setString(1,empName);
		preparedStatement.setInt(2,empSalary);
		preparedStatement.setString(3,empLoc);
		preparedStatement.setInt(4,empLoan);
		preparedStatement.setInt(5,empExp);
		
		preparedStatement.setString(6,eId);
		
		x=	preparedStatement.executeUpdate();
		
    System.out.println("updated rows:"+ x);
		
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
return x;
	}	
	
	public int delete(String empId)
	{
		int x=0;
		String query="delete from employee where employeeId=?";
		
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, empId);
			
			x=	preparedStatement.executeUpdate();
			System.out.println("deleted rows:"+ x);

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}	
	public int loan(int eLoan,String Id) throws Exception
	
	{
		int x=0;
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
			
			System.out.println("not eligible for loan");
			
		}
	}
		String query="update employee set employeeLoan=? where employeeId=?";

		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, eLoan);
		preparedStatement.setString(2, Id);
	     x=preparedStatement.executeUpdate();
		
		System.out.println("Updated rows="+x);		
		return x;
	}
	
}
