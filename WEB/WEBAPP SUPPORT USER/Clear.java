package com.supportuser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminDAO;

public class Clear extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("its came into adminlogin servlet");
		boolean flag=false;
		PrintWriter out = resp.getWriter();
		HttpSession session=req.getSession(true);
	String tno=(String) session.getAttribute("tno");
	System.out.println(">tno>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tno);
	
	
	
	

	
flag=AdminDAO.clear(tno); 
	
	if(flag)
	{
		
		System.out.println("its came inisde if block");
		 RequestDispatcher rd=req.getRequestDispatcher("/jsp/viewordereditems.jsp?no=1");
	      rd.forward(req, resp);
		
		
		
	}
	else
	{
		
		 RequestDispatcher rd=req.getRequestDispatcher("/jsp/vieworder.jsp?no=1");
	      rd.forward(req, resp);
		
	}
	
	
	
	
	}

}
