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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try
		{
	   int id=Integer.parseInt(request.getParameter("id"));	
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
	
		Addstudent rs=new Addstudent(id,sname, email, phone, stream, clgname, DOB, city, state, country, zip);
		int status=StudentDao.updateStudent(rs);
		
		if(status>0)
		{
			pw.print("<script>alert('your data has been updated')</script>");
		RequestDispatcher rd=request.getRequestDispatcher("AllStudentController");
		rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Something Went Wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllStudentController");
			rd.include(request, response);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
