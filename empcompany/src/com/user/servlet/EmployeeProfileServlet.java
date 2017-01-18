package com.user.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.user.dboperations.*;
import com.user.bean.CompanyBean;
import com.user.bean.UserBean;

/**
 * Servlet implementation class EmployeeProfileServlet
 */
@WebServlet("/EmployeeProfileServlet")
public class EmployeeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeProfileServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 response.setContentType("text/html");
	 PrintWriter out=response.getWriter();
	 HttpSession session=request.getSession();
	 
	 String empid=(String)session.getAttribute("empid");
	 
	
	 
	
	 
	 if(empid!=null)
	 {
		 ArrayList<UserBean> emplist=new ArrayList<UserBean>();
		 ArrayList<CompanyBean> emplist1=new ArrayList<CompanyBean>();
		 Dboperations dbo=new Dboperations();
		 emplist=dbo.userprofile(empid);
		 emplist1=dbo.userprofile1(empid);
		 session.setAttribute("employeelist", emplist);
		 session.setAttribute("employeelist1", emplist1);
		 RequestDispatcher ref1=request.getRequestDispatcher("employeeprofileview.jsp");
		 ref1.forward(request, response);
	 }
	 else
	 {
		 RequestDispatcher ref=request.getRequestDispatcher("employeeprofile.jsp");
		 ref.include(request, response);
		 out.print("Wrong");
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}

}
