package com.employee;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class First
 */
//@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
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
	     PrintWriter out=response.getWriter();
	     String eid=request.getParameter("id");
	     String ename=request.getParameter("name");
	     String esal=request.getParameter("salary");
	     String eloc=request.getParameter("location");
	     String eloan=request.getParameter("loan");
	     String eexp=request.getParameter("experience");
			HttpSession session=request.getSession();
			session.setAttribute("id", eid);
			session.setAttribute("name", ename);
			session.setAttribute("salary", esal);
			session.setAttribute("location", eloc);
			session.setAttribute("loan", eloan);
			session.setAttribute("experience", eexp);
			out.print("id="+eid);
			out.print("name="+ename);
			out.print("sal="+esal);
			out.print("locatn="+eloc);
			out.print("loan="+eloan);
			out.print("exp="+eexp); 
	}

}
