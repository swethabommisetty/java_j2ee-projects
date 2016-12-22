package com.dhatriinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhatriinfo.dao.DAOOperations;

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
		DAOOperations dao=new DAOOperations();
		int eLoan=0,result=0;
		try {
			 result=dao.loan(eLoan,eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
RequestDispatcher requestDispact=request.getRequestDispatcher("Suceed.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("Eid", eid);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
		}
	}

}
