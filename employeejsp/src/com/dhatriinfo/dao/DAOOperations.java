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
		String query = "insert into employee values(?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employeeBean.getEmployeeId());
			preparedStatement.setString(2, employeeBean.getEmployeeName());
			preparedStatement.setInt(3, employeeBean.getEmployeeSlary());
			preparedStatement.setString(4, employeeBean.getEmployeeLoc());
			preparedStatement.setInt(5, employeeBean.getEmployeeLoan());
			preparedStatement.setInt(6, employeeBean.getEmployeeExp());
			preparedStatement.setInt(7, employeeBean.getEmployeeExp());

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
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan,employeeEmi from employee where employeeId=?";
		
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
				empBean.setEmployeeEmi(resultSet.getInt(6));
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
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan,employeeEmi from employee where employeeName=?";
		
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
				empBean.setEmployeeEmi(resultSet.getInt(6));
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
		
		String query="select employeeId,employeeName,employeeSlary,employeeLoc,employeeExp,employeeLoan,employeeEmi from employee where employeeSlary=?";
		
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
				empBean.setEmployeeEmi(resultSet.getInt(6));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return employeeList;
	}
	
	public int update(EmployeeBean emp)
	{
		int x=0;
		String query="update employee set employeeName=?,employeeSlary=?,employeeLoc=?,employeeLoan=?,employeeExp=? where employeeId=?";
	try
	{
		preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setString(1,emp.getEmployeeName());
		preparedStatement.setInt(2,emp.getEmployeeSlary());
		preparedStatement.setString(3,emp.getEmployeeLoc());
		preparedStatement.setInt(4,emp.getEmployeeLoan());
		preparedStatement.setInt(5,emp.getEmployeeExp());
		
		preparedStatement.setString(6,emp.getEmployeeId());
		
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
	public ArrayList<EmployeeBean> loan(String Id)
	
	{
		
		int eLoan;
		int emi;
		ArrayList<EmployeeBean> loe=search(Id);
		Iterator<EmployeeBean> itt=loe.iterator();
		EmployeeBean ee=null;
		while(itt.hasNext())
		{
		ee=(EmployeeBean)itt.next();
		
		if(ee.getEmployeeExp()>=2 && ee.getEmployeeExp()<4)
		{
			eLoan=ee.getEmployeeSlary()/2;
			ee.setEmployeeLoan(eLoan);
			emi=(ee.getEmployeeLoan())*14/900;
			ee.setEmployeeEmi(emi);
		}
		else
		{
			
			System.out.println("not eligible for loan");
			
		}
	}
		return loe;
	}
		
	public ArrayList<EmployeeBean> loanUpdate(String tempid)
		{
			ArrayList<EmployeeBean> employeeList=loan(tempid);
			
			EmployeeBean empBean=null;
		
			String query="update employee set employeeLoan=?,employeeEmi=? where employeeId=?";
		

			try {
				
				Iterator it=employeeList.iterator();
				while(it.hasNext())
				{
					empBean=(EmployeeBean)it.next();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, empBean.getEmployeeLoan());
				preparedStatement.setInt(2, empBean.getEmployeeEmi());
				preparedStatement.setString(3, tempid);
				
				preparedStatement.executeUpdate();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return employeeList;
		}
}

