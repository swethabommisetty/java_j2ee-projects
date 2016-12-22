package com.dhatriinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String searchElement=request.getParameter("id");
		
		DAOOperations dao=new DAOOperations();
		PrintWriter out=response.getWriter();
		ArrayList<EmployeeBean> empList=dao.search(searchElement);
		HttpSession session=request.getSession();
		session.setAttribute("employeeList", empList);
		Object obj=session.getAttribute("employeeList");
		if(obj!=null)
		{
			out.print("EmployeeId \t EmployeeName \t EmployeeSalary \t EmployeeLoc \t EmployeeExp \t EmployeeLoan");
			ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
			Iterator iterator=employeeList.iterator();
			EmployeeBean employeebean;
			while(iterator.hasNext())
			{
				employeebean=(EmployeeBean)iterator.next();
				out.println(employeebean.getEmployeeId()+"\t"+employeebean.getEmployeeName()+"\t"+employeebean.getEmployeeSlary()+"\t"+employeebean.getEmployeeLoc()+"\t"+employeebean.getEmployeeExp()+"\t"+employeebean.getEmployeeLoan());
		}
		}
	}

}
