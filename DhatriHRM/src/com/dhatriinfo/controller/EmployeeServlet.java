package com.dhatriinfo.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dhatriinfo.bean.EmployeeBean;
import com.dhatriinfo.dao.*;

/**
 * Servlet implementation class EmployeeServlet
 */
//@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		EmployeeBean emp=new EmployeeBean();
		PrintWriter out=response.getWriter();
		String employeeId=request.getParameter("employeeId");
		String employeeName=request.getParameter("employeeName");
		String employeeSalary=request.getParameter("employeeSalary");
		String employeeLocation=request.getParameter("employeeLocation");
		
		String employeeExp=request.getParameter("employeeExp");
		int salary;
		int exp;
		try
		{
		 salary=Integer.parseInt(employeeSalary);
		 exp=Integer.parseInt(employeeExp);
		
		}
		catch(Exception e)
		{
			salary=0;
			exp=0;
		}
		
		emp.setEmployeeId(employeeId);
		emp.setEmployeeName(employeeName);
		emp.setEmployeeSalary(salary);
		emp.setEmployeeLoc(employeeLocation);
		
		emp.setEmployeeExp(exp);
		DAOOperations dao=new DAOOperations();
		dao.insertData(emp);
		
		out.print("data inserted");
		
		
		
		
		
	}

}
