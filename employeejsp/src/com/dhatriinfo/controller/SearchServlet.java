package com.dhatriinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		String searchElement=request.getParameter("dropdwn");
		
		if(searchElement.equals("id"))
		{
			RequestDispatcher requestDis=request.getRequestDispatcher("Search2.jsp");
			
			requestDis.forward(request, response);
		
		}
		
		else if(searchElement.equals("name"))
		 
		{
			
			RequestDispatcher requestDis=request.getRequestDispatcher("Search.jsp");
			requestDis.forward(request, response);
			
		}
		else if(searchElement.equals("sal"))
			 
		{
			RequestDispatcher requestDis=request.getRequestDispatcher("Search3.jsp");
			
			requestDis.forward(request, response);
		}
		
	}

}
