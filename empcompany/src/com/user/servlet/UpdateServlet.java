package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.bean.CompanyBean;
import com.user.bean.UserBean;
import com.user.dboperations.Dboperations;
import com.user.mail.LoginOtpMail;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
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
		
		HttpSession session=request.getSession();
		 String empid=(String)session.getAttribute("empid");
		PrintWriter out=response.getWriter();
		
		if(empid!=null)
		{
			ArrayList<UserBean> emplist=new ArrayList<UserBean>();
			 
			 Dboperations dbo=new Dboperations();
			 emplist=dbo.userprofile(empid);
			 session.setAttribute("employeelist", emplist);
			 RequestDispatcher ref1=request.getRequestDispatcher("Update.jsp");
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
