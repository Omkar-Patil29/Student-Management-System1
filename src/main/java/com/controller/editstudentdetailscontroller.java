package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Addstudent;
import com.dao.StudentDao;

/**
 * Servlet implementation class editstudentdetailscontroller
 */
@WebServlet("/editstudentdetailscontroller")
public class editstudentdetailscontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editstudentdetailscontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	response.getWriter().append("Served at: ").append(request.getContextPath());*/
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Addstudent eb=StudentDao.studentdetailbyId(id);
		pw.print("<form action='updatecontroller' method ='post'>");
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Sname: </td> <td><input type='text' name='sname' value='"+eb.getSname()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Stream : </td> <td><input type='text' name='stream' value='"+eb.getStream()+"'/></td></tr>");
	   	pw.print("<tr><td>College Name: </td> <td><input type='text' name='clgname' value='"+eb.getClgname()+"'/></td></tr>");
	   	pw.print("<tr><td>DOB : </td> <td><input type='text' name='DOB' value='"+eb.getDOB()+"'/></td></tr>");
		pw.print("<tr><td>City:</td> <td><input type='text' name='city' value='"+eb.getCity()+"'/></td></tr>");
	   	pw.print("<tr><td>State : </td> <td><input type='text' name='state' value='"+eb.getState()+"'/></td></tr>");
	   	pw.print("<tr><td>Country: </td> <td><input type='text' name='country' value='"+eb.getCountry()+"'/></td></tr>");
	   	pw.print("<tr><td>Zip: </td> <td><input type='text' name='zip' value='"+eb.getZip()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
		
	}

}
