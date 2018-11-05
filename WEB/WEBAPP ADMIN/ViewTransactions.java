package com.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminDAO;

public class ViewTransactions extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		try
		{
		
			   Calendar cal = Calendar.getInstance();
			     cal.add(Calendar.DATE, 0);
			     SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			     String formatted = format1.format(cal.getTime());
			     System.out.println("DAte is shnu >>>>>>>>>>"+formatted);
			     
		
		
			String submit=request.getParameter("ok");
		if(submit.equals("Ok"))
		{
			HttpSession session=request.getSession();
			
			String dte=request.getParameter("dte");
			ResultSet rs=null; 
			RequestDispatcher rd=null;
			System.out.println("dte value>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+dte);
			
			System.out.println("its came inise");
			int totalamount=AdminDAO.gettotalamountss(dte);
			session.setAttribute("totalamount", String.valueOf(totalamount));
			System.out.println("total amount is >>>>>>>>"+totalamount);
			rs=AdminDAO.gettransactiondetails(dte);
			if(rs!=null)
			{
				System.out.println("rs is not numm null");
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/viewtransactions.jsp");
				rd.forward(request, response);
				
				
				
				
			}
			else
			{
				

				rd=request.getRequestDispatcher("/jsp/enterdate.jsp?no=1");
				rd.forward(request, response);	
				
				
				
			}
			
			
			
			
			
			
		}
	
		}
		
		
		catch (Exception e) {
			
		}
	}
	

}
