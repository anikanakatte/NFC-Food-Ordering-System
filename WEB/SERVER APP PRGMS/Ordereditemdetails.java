package com.server;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




@Path("/getorder")
public class Ordereditemdetails
{
	
	@GET
	@Path("/items")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("tableno") String tno) throws SQLException, Exception
	{
		ArrayList<String> ll=new ArrayList<String> ();
		ResultSet rs=null;
		int existingamount=0;
		boolean flag=false;
		boolean flagvalue=false;
		int i=0;
		int totalprice=0;
		int qual=0;
		String[] data;
		String response="";
		String pp="";
		
		
			
			
			i = DBConnection.selectordernum(tno);
			
			System.out.println("i is>>>>>>>>>>>>>>"+i);
			ll	=DBConnection.getordereddetails(i);
		
		System.out.println("list content is >>>>>>>>>>>>>>>>>>>"+ll);
			
			
		  response = Utitlity.constructJSON44(ll.toString(),true);
		
		System.out.println("response"+response);
		return response;

		
}
}