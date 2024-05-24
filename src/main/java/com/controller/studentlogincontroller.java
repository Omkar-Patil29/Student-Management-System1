package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Addstudent;
import com.dao.StudentDao;

/**
 * Servlet implementation class studentlogincontroller
 */
@WebServlet("/studentlogincontroller")
public class studentlogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentlogincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String stream=request.getParameter("stream");
		String clgname=request.getParameter("clgname");
		String DOB=request.getParameter("DOB");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		int  zip=Integer.parseInt(request.getParameter("zip"));
		
		Addstudent as=new Addstudent(sname, email, phone, stream, clgname, DOB, city, state, country, zip);
		
		int status=StudentDao.addStud(as);
		
		if(status>0)
		{
			pw.print("<script>alert('Students data is added successfully')</script>");
			RequestDispatcher qw=request.getRequestDispatcher("dashboard.html");
			qw.include(request, response);
			
		}
		else
		{
			pw.print("Something went Wrong Please try again");
			RequestDispatcher qw=request.getRequestDispatcher("dashboard.html");
			qw.include(request, response);
		}
		
	}

}
