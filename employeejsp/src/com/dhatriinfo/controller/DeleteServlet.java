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

import com.dhatriinfo.bean.EmployeeBean;
import com.dhatriinfo.dao.DAOOperations;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		EmployeeBean e=new EmployeeBean();
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("id");
		DAOOperations dbo=new DAOOperations();
		int res=dbo.delete(eid);
		
		out.print("id is deleted");
RequestDispatcher requestDispact=request.getRequestDispatcher("Succes.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("Id", eid);
		if(res>0)
		{
		requestDispact.forward(request, response);
	}
	}
}
