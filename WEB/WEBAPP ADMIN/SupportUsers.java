
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminDAO;


@SuppressWarnings("serial")
public class SupportUsers extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int routeId=0;
		String name="",pass="",age="",role="",phone="",mail="",sex="";
		int companycell11=0;
		int landline=0;
		int cmpnycode=0;
		int userid=0;
		
		try
		{
			
			String submit=request.getParameter("action");
			
			System.out.println("submit value>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+submit);
			
			rs=AdminDAO.getsupportUserdetails();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/supportusers.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add")).equals("YES"))
				{
					
					System.out.println("adddddddddd");
					name = request.getParameter("name");
					System.out.println("name>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
					
					pass = request.getParameter("pass");
					System.out.println("pass>>>>>>>>>>>>>>>>>>>>>>>>>>"+pass);
					
					age = request.getParameter("age");
					//cmpnycode =	Integer.parseInt("companycode");
					System.out.println("age>>>>>>>>>>>>>>>>>>>>>>>>>>"+age);
					
					sex = request.getParameter("sex");
					//companycell11 =	Integer.parseInt("companycell");
					System.out.println("sex>>>>>>>>>>>>>>>>>>>>>>>>>>"+sex);
				
					role = request.getParameter("role");
					//landline =	Integer.parseInt("companylandline");
					System.out.println("role>>>>>>>>>>>>>>>>>>>>>>>>>>"+role);
					
					phone = request.getParameter("phone");
					//userid =	Integer.parseInt("companyuserid");
					System.out.println("phone>>>>>>>>>>>>>>>>>>>>>>>>>>"+phone);
					
					mail = request.getParameter("mail");
					System.out.println("mail>>>>>>>>>>>>>>>>>>>>>>>>>>"+mail);
					
					
					
					
				
				 flag = AdminDAO.checksupportuserExistance(name);
					
					if(!flag)
					{
						flag = AdminDAO.addsupportuserDetails(name, pass, age, sex, role, phone, mail);
						
						
						if(flag)
						{
							rs=AdminDAO.getsupportUserdetails();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/jsp/add_supportuser.jsp?no=2");
							rd.forward(request, response);
						}
							 
					}
					else
					{
						rd=request.getRequestDispatcher("/jsp/add_supportuser.jsp?no=3");
						rd.forward(request, response);
					}
					
				}
				else
				{
					rd=request.getRequestDispatcher("/jsp/add_supportuser.jsp");
					rd.forward(request, response);
				}
			}
			
			
	if(submit.equals("Edit"))
			{
			
			System.out.println("submit in edit>>>>>>>>>>>>>>>"+submit );
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit")).equals("YES"))
				{
					System.out.println("its came inside if block");
					String idd =request.getParameter("id");
					String namee =request.getParameter("name");
				  String	phonee = request.getParameter("phone");
				  String	ag = request.getParameter("age");
				   String se  = request.getParameter("sex");
					String emaill = request.getParameter("email");
					String rolee = request.getParameter("role");
					
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(idd);
					list.add(namee);
					list.add(phonee);
					list.add(ag);
					list.add(se);
					list.add(emaill);
					list.add(rolee);
				
					flag = AdminDAO.updatesupportusersDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getsupportUserdetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getsupportUserdetails(chk[0]);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/edit_supportusers.jsp?no=2");
						rd.forward(request,response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getsupportUserdetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getsupportUserdetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getsupportUserdetails(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/edit_supportusers.jsp");
					rd.forward(request,response);
				}
			}

			
		
		if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				System.out.println("its came inside delete>>>>>>>>>>>>>>>>");
			
					//Without Delete Confirmation
					if(chk==null)
					{
						rs=AdminDAO.getsupportUserdetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=2");
						rd.forward(request,response);
					}
					else
					{
						
					
				
				
				//With Delete Confirmation
				
				for(int i=0;i<chk.length;i++)
				{
					String id = chk[i];
					AdminDAO.deletesupportDetails(id);
					
				}
				rs=AdminDAO.getsupportUserdetails();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/supportusers.jsp?no=3");
				rd.forward(request,response);
			}
		
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
	
}}
