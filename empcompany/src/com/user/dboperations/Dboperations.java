package com.user.dboperations;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.user.bean.*;

public class Dboperations
{
	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet resultSet=null;
	public Dboperations()
	{
		connection=MyConnection.getInstance().connection;
	}
	
	
	public int registration(UserBean ub)
	{
		int result=0;
		
		String query="insert into empdetails values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			pst=connection.prepareStatement(query);
			pst.setString(1, ub.getEmpid());
			pst.setString(2, ub.getFirstname());
			pst.setString(3, ub.getLastname());
			pst.setString(4, ub.getDob());
			pst.setString(5, ub.getMobileno());
			pst.setString(6, ub.getEmail());
			pst.setString(7, ub.getAlternatemail());
			pst.setString(8, ub.getAlternatemob());
			pst.setString(9, ub.getPresentadd());
			pst.setString(10, ub.getPermanentadd());
			pst.setString(11, ub.getFathersname());
			pst.setString(12, ub.getOccupation());
			result=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	public int registration1(CompanyBean cb)
	{
		int result=0;
		
		String query="insert into cmpdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			pst=connection.prepareStatement(query);
			pst.setString(1, cb.getEmpid());
			pst.setString(2, cb.getYearsofexp());
			pst.setString(3, cb.getPastcompanyname());
			pst.setInt(4, cb.getPastcompanyperiod());
			pst.setString(5, cb.getDateofjoining());
			pst.setDouble(6, cb.getCurrentctc());
			pst.setDouble(7, cb.getAdvancesal());
			pst.setString(8, cb.getAdvancesaldate());
			pst.setString(9, cb.getAdvancesalterms());
			pst.setString(10, cb.getDesignation());
			pst.setString(11, cb.getTechnology());
			pst.setDouble(12, cb.getPastctc());
			pst.setString(13, cb.getPasthikedetails());
			result=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<UserBean> loginsearch(String employeeid)
	{
		
		ArrayList<UserBean> empref=new ArrayList<UserBean>();
		
String query="select empid,dob,email from empdetails where empid=?";
		
		try {
			pst=connection.prepareStatement(query);
			pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			
			UserBean empBean=null;
			while(resultSet.next())
			{
				empBean=new UserBean();
				empBean.setEmpid(resultSet.getString(1));
				empBean.setDob(resultSet.getString(2));
				empBean.setEmail(resultSet.getString(3));
				
			
				empref.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empref;
		
	}
	public ArrayList<UserBean> userprofile(String employeeid)
	{
		
		ArrayList<UserBean> empref=new ArrayList<UserBean>();
		
		
		String query="select * from empdetails where empid=?";
		
		try {
			pst=connection.prepareStatement(query);
			
			pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			
			UserBean empBean=null;
			
			while(resultSet.next())
			{
				empBean=new UserBean();
				
				empBean.setEmpid(resultSet.getString(1));
				empBean.setFirstname(resultSet.getString(2));
				empBean.setLastname(resultSet.getString(3));
				empBean.setDob(resultSet.getString(4));
				empBean.setMobileno(resultSet.getString(5));
				empBean.setEmail(resultSet.getString(6));
				empBean.setAlternatemail(resultSet.getString(7));
				empBean.setAlternatemob(resultSet.getString(8));
				empBean.setPresentadd(resultSet.getString(9));
				empBean.setPermanentadd(resultSet.getString(10));
				empBean.setFathersname(resultSet.getString(11));
				empBean.setOccupation(resultSet.getString(12));
				
				empref.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empref;
		
		
	}
	
	public ArrayList<CompanyBean> userprofile1(String employeeid)
	{
		ArrayList<CompanyBean> empref1=new ArrayList<CompanyBean>();
		String query="select * from cmpdetails where empid=?";
		try {
			pst=connection.prepareStatement(query);
            pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			CompanyBean cmpBean=null;
			while(resultSet.next())
			{
				cmpBean=new CompanyBean();
				cmpBean.setEmpid(resultSet.getString(1));
				cmpBean.setYearsofexp(resultSet.getString(2));
				cmpBean.setPastcompanyname(resultSet.getString(3));
				cmpBean.setPastcompanyperiod(resultSet.getInt(4));
				cmpBean.setDateofjoining(resultSet.getString(5));
				cmpBean.setCurrentctc(resultSet.getDouble(6));
				cmpBean.setAdvancesal(resultSet.getDouble(7));
				cmpBean.setAdvancesaldate(resultSet.getString(8));
				cmpBean.setAdvancesalterms(resultSet.getString(9));
				cmpBean.setDesignation(resultSet.getString(10));
				cmpBean.setTechnology(resultSet.getString(11));
				cmpBean.setPastctc(resultSet.getDouble(12));
				cmpBean.setPasthikedetails(resultSet.getString(13));
				empref1.add(cmpBean);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empref1;
	}

	public int update(UserBean emp)
	{
		int x=0;
		String query="update empdetails set firstname=?,lastname=?,dob=?,mobileno=?,email=?,alternatemail=?,alternatemob=?,presentadd=?,permanentadd=?,fathersname=?,occupation=? where empid=?";
	try
	{
		pst=connection.prepareStatement(query);
		
		pst.setString(1,emp.getFirstname());
		pst.setString(2,emp.getLastname());
		pst.setString(3,emp.getDob());
		pst.setString(4,emp.getMobileno());
		pst.setString(5,emp.getEmail());
		pst.setString(6,emp.getAlternatemail());
		pst.setString(7,emp.getAlternatemob());
		pst.setString(8,emp.getPresentadd());
		pst.setString(9,emp.getPermanentadd());
		pst.setString(10,emp.getFathersname());
		pst.setString(11,emp.getOccupation());
		pst.setString(12,emp.getEmpid());
		
		x=	pst.executeUpdate();
		
    System.out.println("updated rows:"+ x);
		
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
return x;
	}	
}
