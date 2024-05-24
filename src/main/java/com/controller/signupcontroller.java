package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.bo.Student;
import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupcontroller
 */
@WebServlet("/signupcontroller")
public class signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public signupcontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
//		pw.print("Hey this is Signup Controller");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
				String user=request.getParameter("user");
				String pwd=request.getParameter("pwd");
//				pw.print(name+" "+email+" "+user+" "+pwd);
				
				
			Student st=new Student(name,email,user,pwd);
				int status=StudentDao.insertStu(st);
				
				if(status>0)
		     	{
				pw.print("Data is inserted Successfully");
				}
			else
				{
					pw.print("Something went wrong data is not inserted");
				}
	}

}
