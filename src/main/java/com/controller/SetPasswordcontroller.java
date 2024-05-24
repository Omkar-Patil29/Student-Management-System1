package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Student;
import com.dao.StudentDao;

/**
 * Servlet implementation class SetPasswordcontroller
 */
@WebServlet("/SetPasswordcontroller")
public class SetPasswordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPasswordcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("username");
		String password=request.getParameter("forgetpwd");
		int userid=Integer.parseInt(request.getParameter("userid"));
		Student ob=new Student(email,userid, password);
		int status=StudentDao.setPassword(ob);
		if(status>0)
		{
			pw.print("<script>alert('Password successfully updated')</script>");
			RequestDispatcher rq=request.getRequestDispatcher("login.html");
			rq.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Something went wrong')</script>");
			RequestDispatcher rq=request.getRequestDispatcher("login.html");
			rq.include(request, response);
		}
		}
		catch(Exception e)
		{		
			e.printStackTrace();
		}
	}

}
