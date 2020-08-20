package com.CartPlusOne.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CartPlusOne.beans.Student;
import com.CartPlusOne.factory.CartPlusOneServiceFactory;
import com.CartPlusOne.service.CartPlusOneService;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String request_URI=request.getRequestURI();
		RequestDispatcher requestDispatcher=null;
		
		if(request_URI.endsWith("addform.do"))
		{
			requestDispatcher=request.getRequestDispatcher("/addform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("searchform.do"))
		{
			requestDispatcher=request.getRequestDispatcher("/searchform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("updateform.do"))
		{
			requestDispatcher=request.getRequestDispatcher("/updateform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("deleteform.do"))
		{
			requestDispatcher=request.getRequestDispatcher("/deleteform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("loginform.do"))
		{
			requestDispatcher=request.getRequestDispatcher("/loginform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("add.do"))
		{
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			
			Student student=new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);
			
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			String status=studentService.addStudent(student);
			
			if(status.equals("existed"))
			{
				requestDispatcher=request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("success"))
			{
				requestDispatcher=request.getRequestDispatcher("successadd.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure"))
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
		}
		if(request_URI.endsWith("search.do"))
		{
			String sid=request.getParameter("sid");
			
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			Student student=studentService.searchStudent(sid);
			
			if(student==null)
			{
				requestDispatcher=request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br><br><br>");
				out.println("<table align='center' border='1'>");
				out.println("<tr><td>Student Id</td><td>"+student.getSid()+"</td></tr>");
				out.println("<tr><td>Student Name</td><td>"+student.getSname()+"</td></tr>");
				out.println("<tr><td>Student Address</td><td>"+student.getSaddr()+"</td></tr>");
				out.println("</table>");
				out.println("<br><center>");				
				out.println("<input type='button' value='Back' onclick='window.history.back()'/>");
				out.println("</center></body></html>");
			}
		}
		if(request_URI.endsWith("editform.do"))
		{
			String sid=request.getParameter("sid");
			
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			Student student=studentService.searchStudent(sid);
			if(student==null)
			{
				requestDispatcher=request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request,response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br><br><br>");
				out.println("<form method='POST' action='update.do'>");
				out.println("<table align='center'>");
				out.println("<tr><td>Student Id</td><td>"+student.getSid()+"</td></tr>");
				out.println("<input type='hidden'name='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+student.getSname()+"'/></td></tr>");
				out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+student.getSaddr()+"'/></td></tr>");
				out.println("<tr><td><input type='submit' value='Update'/></td></tr>");
				out.println("</table>");
				out.println("</br><center>");				
				out.println("<input type='button' value='Back' onclick='window.history.back()'/>");
				out.println("</center></body></html>");
			}
		}
		if(request_URI.endsWith("update.do"))
		{
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			
			Student student=new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);
		
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			String status=studentService.updateStudent(student);
			
			if(status.equals("success"))
			{
				requestDispatcher=request.getRequestDispatcher("successupdate.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure"))
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
		}
		if(request_URI.endsWith("delete.do"))
		{
			String sid=request.getParameter("sid");
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			String status=studentService.deleteStudent(sid);
			
			if(status.equals("success "))
			{
				requestDispatcher=request.getRequestDispatcher("successdelete.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure"))
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("notexisted"))
			{
				requestDispatcher=request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
		}
		if(request_URI.endsWith("login.do"))
		{
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("pwd");
			
			Student student=new Student();
			student.setUname(uname);
			student.setPwd(pwd);
			
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			String status=studentService.checkLogin(student);
			
			if(status.equals("success"))
			{
				requestDispatcher=request.getRequestDispatcher("content.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
		}
		if(request_URI.endsWith("signup.do"))
		{
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("pwd");
			String mobile=request.getParameter("mobile");
			
			Student student=new Student();
			student.setUname(uname);
			student.setPwd(pwd);
			student.setMobile(mobile);
			
			CartPlusOneService studentService=CartPlusOneServiceFactory.getStudentService();
			String status=studentService.addAccountDetails(student);
			
			if(status.equals("success"))
			{
				requestDispatcher=request.getRequestDispatcher("successadd.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
		}
		if(request_URI.endsWith("about.do"))
		{
			requestDispatcher=request.getRequestDispatcher("aboutUs.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("contact.do"))
		{
			requestDispatcher=request.getRequestDispatcher("contact.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("news.do"))
		{
			requestDispatcher=request.getRequestDispatcher("news.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("search_page.do"))
		{
			requestDispatcher=request.getRequestDispatcher("contact.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("contactUs.do"))
		{
			requestDispatcher=request.getRequestDispatcher("thanks.html");
			requestDispatcher.forward(request, response);
		}
	}
}
