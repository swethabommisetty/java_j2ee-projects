package com.user.servlet;
import com.user.mail.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.bean.UserBean;
import com.user.dboperations.Dboperations;
import com.user.mail.LoginOtpMail;

/**
 * Servlet implementation class Update2Servlet
 */
@WebServlet("/Update2Servlet")
public class Update2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update2Servlet() {
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
		//Dboperations dbo=new Dboperations();
		String eid=request.getParameter("eid");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String dob=request.getParameter("dob");
		String mob=request.getParameter("mob");
		String mail=request.getParameter("mail");
		String mail1=request.getParameter("mail1");
		String mob1=request.getParameter("mob1");
		String message=request.getParameter("message");
		String message1=request.getParameter("message1");
		String fathersname=request.getParameter("fathersname");
		String occupation=request.getParameter("occupation");
		System.out.print(fathersname);
		UserBean bean=new UserBean();
		bean.setEmpid(eid);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setDob(dob);
		bean.setEmail(mail);
		bean.setMobileno(mob);
		bean.setAlternatemail(mail1);
		bean.setAlternatemob(mob1);
		bean.setPermanentadd(message1);
		bean.setPresentadd(message);
		bean.setFathersname(fathersname);
		bean.setOccupation(occupation);
		
		
		try {
			SendRegMail.sendEmail(bean);
			session.setAttribute("userbean", bean);
			RequestDispatcher ref1=request.getRequestDispatcher("home.jsp");
			 ref1.forward(request, response);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
