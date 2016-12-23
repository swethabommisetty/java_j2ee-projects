package com.dhatriinfo.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhatriinfo.bean.EmployeeBean;
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
		EmployeeBean e=new EmployeeBean();
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String esal=request.getParameter("esal");
		String eloc=request.getParameter("eloc");
		String eexp=request.getParameter("eexp");
		int sal=Integer.parseInt(esal);
		int exp=Integer.parseInt(eexp);
		e.setEmployeeId(eid);
		e.setEmployeeName(ename);
		e.setEmployeeSlary(sal);
		e.setEmployeeLoc(eloc);
		e.setEmployeeExp(exp);
		DAOOperations dbo=new DAOOperations();
		int res=dbo.update(e);
RequestDispatcher requestDispact=request.getRequestDispatcher("Success.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("employeeId", eid);
		if(res>0)
		{
		requestDispact.forward(request, response);
		}
	}

}
