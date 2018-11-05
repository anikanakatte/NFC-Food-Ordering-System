package com.supportuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewOrderedItems extends HttpServlet {
	
	String tno1="";
	String tno2="";
	
	String tno3="";
	String data[];
	int tnum=0;
	String tno4="";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession(true);
		RequestDispatcher rd=null;
		tno1=req.getParameter("t1");
	data=	tno1.split("_");
		
		tnum=	Integer.parseInt(data[1]);
	
	System.out.println("tnum is >>>>>>>>>>>>>>>>>>>>>"+tnum);
	
		if(Integer.parseInt(data[1])==1)
		{
			
			session.setAttribute("tno", data[1]);
			
			System.out.println("tno>>>>>>>>>>>"+Integer.parseInt(data[1]));
			
			rd=req.getRequestDispatcher("/jsp/vieworder.jsp");
					rd.forward(req, resp);
			
			
		}
		
		else if(Integer.parseInt(data[1])==2)
		{
			
			
session.setAttribute("tno", data[1]);
			
			System.out.println("tno>>>>>>>>>>>"+Integer.parseInt(data[1]));
			
			rd=req.getRequestDispatcher("/jsp/vieworder.jsp");
					rd.forward(req, resp);
			
			
		}
		
		
		else if(Integer.parseInt(data[1])==3)
		{
			
			
session.setAttribute("tno", data[1]);
			
			System.out.println("tno>>>>>>>>>>>"+Integer.parseInt(data[1]));
			
			rd=req.getRequestDispatcher("/jsp/vieworder.jsp");
					rd.forward(req, resp);
			
			
		}
		
		else
		{
			
			
session.setAttribute("tno", data[1]);
			
			System.out.println("tno>>>>>>>>>>>"+Integer.parseInt(data[1]));
			
			rd=req.getRequestDispatcher("/jsp/vieworder.jsp");
					rd.forward(req, resp);
			
			
			
		}
		
		
	}

}
