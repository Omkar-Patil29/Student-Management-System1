package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class DeleteStudentInfo
 */
@WebServlet("/DeleteStudentInfo")
public class DeleteStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		int status=StudentDao.deleteStudents(id);
		
		if(status>0)
		{
			pw.print("<script>alert('your data has been Deleted Successfully')</script>");
           
		}
		else
		{
			pw.print("<script>alert('Something Went Wrong')</script>");
		RequestDispatcher rd=request.getRequestDispatcher("AllStudentController");
		rd.include(request, response);
		}
		pw.print("<a href ='dashboard.html'>Dashboard</a>");
	}

}
