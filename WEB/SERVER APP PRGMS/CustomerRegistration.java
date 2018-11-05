package com.server;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




@Path("/custdetails")
public class CustomerRegistration
{
	
	@GET
	@Path("/empupdate")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("name") String cname,@QueryParam("phone") String cphone,@QueryParam("mail") String cmail,@QueryParam("add") String cadd) throws SQLException, Exception
	{
		String response="";
		if(Utitlity.isNotNull(cname) && Utitlity.isNotNull(cphone) && Utitlity.isNotNull(cadd) && Utitlity.isNotNull(cmail))
		{
			 
		
			
			System.out.println(cname+cphone+cmail+cadd);
			
			
			boolean fl = DBConnection.checkcustDetails(cname);
			
			if(!fl)
			{
				
					
					String alphaNumerics = "123456789";
					String t = "";
					
				
					for (int i = 0; i <6; i++) 
					{
					    t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
					}
					
					
				
				
				
				
				
				
				
				
				boolean flg = DBConnection.insertEmployeeDetails(cname, cphone, cmail, cadd,t);
				
				
				
				if(flg)
				{//{"tag":"empdetails","status":true}

				response = Utitlity.constructJSON1("shanu",true,"success");
					System.out.println("Response*** :"+response);
				}
				else
				{
				response = Utitlity.constructJSON("empdetails", false, "Something Went Wrong!!!");
				}
		
		
	}
			else
			{
				
				response = Utitlity.constructJSON2("exists",false);
				System.out.println("Response*** :"+response);	
				
				
			}
	
}
		return response;
}
}