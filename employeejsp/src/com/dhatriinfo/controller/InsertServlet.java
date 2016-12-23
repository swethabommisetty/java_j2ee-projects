package com.dhatriinfo.controller;
import com.dhatriinfo.bean.*;
import com.dhatriinfo.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmployeeId(employeeId);
		employeeBean.setEmployeeName(employeeName);
		employeeBean.setEmployeeSlary(salary);
		employeeBean.setEmployeeExp(exp);
		employeeBean.setEmployeeLoc(employeeLocation);
		out.print(employeeId);
		DAOOperations dao=new DAOOperations();
		int result=dao.insertData(employeeBean);
		
		RequestDispatcher requestDispact=request.getRequestDispatcher("Sucess.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("Eid", employeeId);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
		}
		
		
		
	}

}
