package com.dhatriinfo.controller;
import com.dhatriinfo.bean.*;
import com.dhatriinfo.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		
		String eid=request.getParameter("id");
		String ename=request.getParameter("ename");
		String esal=request.getParameter("sal");
		String eloc=request.getParameter("loc");
		String eexp=request.getParameter("exp");
		String eloan=request.getParameter("loan");
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
		dbo.update(eid, ename, sal, exp, eloc, loan);
		
	}

}
