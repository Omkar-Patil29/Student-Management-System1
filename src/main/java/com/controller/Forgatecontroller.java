package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Student;
import com.dao.StudentDao;

/**
 * Servlet implementation class Forgatecontroller
 */
@WebServlet("/Forgatecontroller")
public class Forgatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgatecontroller() {
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
		
		String username=request.getParameter("email");

		int userid=StudentDao.forgatepassword(username);
		
		 if (userid > 0) 
		 {
			 pw.print("<script>alert('Email is same now you can forgot password')</script>");
			pw.print("<link rel='stylesheet' type='text/css' href='./styles1.css'>");
			
			pw.print("<div class='mainpages'>");
			pw.print("<div class='maincont'>");
			pw.print("<form action='SetPasswordcontroller' method='post'>");
			pw.print("<h1 style='color:navy'>Set New Password</h1>");
			pw.print("<input type='hidden' name='userid' value='"+userid+"'>");
			pw.print("<input type='text' name='user' value='"+username+"'>");
		
			pw.print("<input type=\"password\" name=\"password\" placeholder=\"Enter your password\">");
			pw.print(" <button type=\"submit\" id='btn'>Submit</button>");
			pw.print("</form>");
			pw.print("</div>");
			pw.print("</div>");
		 }
		 else
		 {
			 pw.print("<script>alert('Username does not exists')</script>");
		 }
	}

}
