package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminDAO;

public class Adminlogin extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("its came into adminlogin servlet");
		boolean flag=false;
		PrintWriter out = resp.getWriter();
	
	String username=	req.getParameter("adminid");
	System.out.println(">>>>>>username>>>>>>>>>>>>>>>>>>>>>"+username);
	String pass=	req.getParameter("pass");
	HttpSession session=req.getSession(true);
	
	
	
	
	System.out.println(">pass>>>>>>>>>>>>>>>>>>>>>>>>>>>"+pass);
	
flag=AdminDAO.checkadmin(username,pass); 
	
	if(flag)
	{
		session.setAttribute("username", username);
		System.out.println("its came inisde if block");
		 RequestDispatcher rd=req.getRequestDispatcher("/jsp/adminhome.jsp?no=1");
	      rd.forward(req, resp);
		
		
		
	}
	else
	{
		
		 RequestDispatcher rd=req.getRequestDispatcher("index.jsp?no=2");
	      rd.forward(req, resp);
		
	}
	
	
	
	
	}

}
