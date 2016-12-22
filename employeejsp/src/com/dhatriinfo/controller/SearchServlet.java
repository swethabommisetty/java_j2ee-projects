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
		
		String searchElement=request.getParameter("searchElement");
		String name=searchElement;
		DAOOperations dao=new DAOOperations();
		EmployeeBean empbean=new EmployeeBean();
		PrintWriter out=response.getWriter();
		
		empbean.setEmployeeId(searchElement);
		if(empbean.getEmployeeId()==searchElement)
		{
			ArrayList<EmployeeBean> empList=dao.search(searchElement);
			HttpSession session=request.getSession();
			session.setAttribute("employeeList", empList);
			RequestDispatcher requestDis=request.getRequestDispatcher("Search.jsp");
			
			requestDis.forward(request, response);
		
		}
		
		empbean.setEmployeeName(name);
		
		 if(empbean.getEmployeeName()==name)
		{
			ArrayList<EmployeeBean> empList=dao.search1(name);
			
			HttpSession session=request.getSession();
			session.setAttribute("employeeList", empList);
			Object obj=session.getAttribute("employeeList");

			if(obj!=null)
			{
				out.print("EmployeeId \t Employeename \t Employeesal \t Employeeloc \t Employeeexp \t Employeeloan");
			
				Iterator it=empList.iterator();
				EmployeeBean empBean=null;
				while(it.hasNext())
				{
					empBean=(EmployeeBean)it.next();
					out.println(empBean.getEmployeeId()+"\t"+empBean.getEmployeeName()+"\t"+empBean.getEmployeeSlary()+"\t"+empBean.getEmployeeLoc()+"\t"+empBean.getEmployeeExp()+"\t"+empBean.getEmployeeLoan());
			}
		
		}
		 
		}
		 
		
		
	}

}
