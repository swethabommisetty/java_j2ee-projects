package com.dhatriinfo.controller;
import com.dhatriinfo.bean.*;
import com.dhatriinfo.dao.*;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoanServlet
 */
@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanServlet() {
        super();
        
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
		DAOOperations dao=new DAOOperations();
		int eLoan=0;
		try {
			dao.loan(eLoan,eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
