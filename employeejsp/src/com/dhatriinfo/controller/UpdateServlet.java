package com.dhatriinfo.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhatriinfo.dao.DAOOperations;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
        response.setContentType("text/html");  
		
		String eid=request.getParameter("employeeId");
		String ename=request.getParameter("employeeName");
		String esal=request.getParameter("employeeSalary");
		String eloc=request.getParameter("employeeLocation");
		String eexp=request.getParameter("employeeExp");
		String eloan=request.getParameter("employeeLoan");
		int sal;
		int exp,loan;
		try
		{
			sal=Integer.parseInt(esal);
			exp=Integer.parseInt(eexp);
			loan=Integer.parseInt(eloan);
		}
		catch(Exception m)
		{
			sal=0;
			exp=0;loan=0;
		}
		DAOOperations dbo=new DAOOperations();
		int res=dbo.update(eid, ename, sal, exp, eloc, loan);
RequestDispatcher requestDispact=request.getRequestDispatcher("Success.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("employeeId", eid);
		if(res>0)
		{
		requestDispact.forward(request, response);
		}
	}

}
