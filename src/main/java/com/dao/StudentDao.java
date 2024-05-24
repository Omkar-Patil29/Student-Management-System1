package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.Addstudent;
import com.bo.Student;

public class StudentDao 
{
		public static Connection getConnection()
		{
			Connection con=null;
			
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","12345");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
		}
		public static int insertStu(Student st)
		{
			int status=0;
			try
			{
			Connection con=StudentDao.getConnection();
			String sql="insert into signup (name,email,username,password) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getUsername());
			ps.setString(4, st.getPassword());
			
			status=ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		}	
	
		
		public static boolean login(String user,String pwd)
		{
			boolean status=false;
			try
			{
				Connection con=StudentDao.getConnection();
				String sql="select * from signup where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);	
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		}   
		public static int addStud(Addstudent st)
		{   
			int status =0;
			try
			{
			Connection con=StudentDao.getConnection();
			String sql="insert into addstudent(sname,email,phone,stream,clgname,DOB,city,state,country,zip)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,st.getSname());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getPhone());
			ps.setString(4, st.getStream());
			ps.setString(5, st.getClgname());
			ps.setString(6, st.getDOB());
			ps.setString(7, st.getCity());
			ps.setString(8, st.getState());
			ps.setString(9, st.getCountry());
			ps.setInt(10, st.getZip());
			
			status=ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		} 
		
		
		public static List getAllStudentData()
		{
			List<Addstudent>list=new ArrayList<Addstudent>();
		
			try
			{
				Connection con=StudentDao.getConnection();
			String sql="select * from addstudent";
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Addstudent sw=new Addstudent();
				sw.setId(rs.getInt(1));
				sw.setSname(rs.getString(2));
				sw.setEmail(rs.getString(3));
				sw.setPhone(rs.getString(4));
				sw.setStream(rs.getString(5));
				sw.setClgname(rs.getString(6));
				sw.setDOB(rs.getString(7));
				sw.setCity(rs.getString(8));
				sw.setState(rs.getString(9));
				sw.setCountry(rs.getString(10));
				sw.setZip(rs.getInt(11));
				list.add(sw);
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return list;	
		}
		public static Addstudent studentdetailbyId(int id)
		{
		Addstudent ad=new Addstudent();
			try
			{
				Connection con=StudentDao.getConnection();
				String sql="select * from addstudent where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					ad.setId(rs.getInt(1));
					ad.setSname(rs.getString(2));
					ad.setEmail(rs.getString(3));
					ad.setPhone(rs.getString(4));
					ad.setStream(rs.getString(5));
					ad.setClgname(rs.getString(6));
					ad.setDOB(rs.getString(7));
					ad.setCity(rs.getString(8));
					ad.setState(rs.getString(9));
					ad.setCountry(rs.getString(10));
					ad.setZip(rs.getInt(11));
				}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
			return  ad;
		}
		public static int updateStudent(Addstudent st)
		{
			int status=0;
			try
			{
				Connection con=StudentDao.getConnection();
				String sql="update addstudent set sname=?,email=?,phone=?,stream=?,clgname=?,DOB=?,city=?,state=?,country=?,zip=? where id=?";
				
				PreparedStatement ad=con.prepareStatement(sql);
	
				ad.setString(1,st.getSname());
				ad.setString(2,st.getEmail());
				ad.setString(3,st.getPhone());
				ad.setString(4,st.getStream());
				ad.setString(5,st.getClgname());
				ad.setString(6,st.getDOB());
				ad.setString(7,st.getCity());
				ad.setString(8,st.getState());
				ad.setString(9,st.getCountry());
				ad.setInt(10, st.getZip());
				ad.setInt(11, st.getId());
				
				status=ad.executeUpdate();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		}
		public static int deleteStudents(int id)
		{
			
			int status=0;
			try
			{
				Connection con=StudentDao.getConnection();
			String sql="Delete from addstudent where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,id);
				
			status=ps.executeUpdate();
				
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
					
					return status;
		}
		
		public static int forgatepassword(String username)
		{
			int  sid=0;
			try
			{
				Connection con=StudentDao.getConnection();
				String sql="select * from signup where email=?  ";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,username );
				ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				sid=rs.getInt("id");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return sid;
		}
		public static int setPassword(Student ob)
		{
//			StudentManagementSystem ob=new StudentManagementSystem();
			int status=0;
			try
			{
				Connection	con=StudentDao.getConnection();
				String sql="update signup set password=? where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, ob.getForgetpwd());
				ps.setInt(2, ob.getId());
				status=ps.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		
		    
            
}
