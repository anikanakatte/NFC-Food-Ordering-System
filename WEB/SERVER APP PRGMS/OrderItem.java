package com.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




@Path("/order")
public class OrderItem
{
	
	@GET
	@Path("/item")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("itemname") String itemname,@QueryParam("quality") String qua,@QueryParam("price") String price,@QueryParam("tableno") String tno) throws SQLException, Exception
	{ArrayList<String> ll=new ArrayList<String> ();
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
		if(Utitlity.isNotNull(itemname) && Utitlity.isNotNull(qua) && Utitlity.isNotNull(price) && Utitlity.isNotNull(tno))
		{
			 
		
			
			System.out.println(itemname+" "+qua+" "+price+" "+tno);
			
		String item=	itemname.replace("[", "");
		
		String itemn=	item.replace("]", "");
			i = DBConnection.selectordernum(tno);
			
			System.out.println("i is>>>>>>>>>>>>>>"+i);
			

		     Calendar cal = Calendar.getInstance();
		     cal.add(Calendar.DATE, 0);
		     SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		     String formatted = format1.format(cal.getTime());
		     System.out.println("DAte is >>>>>>>>>>"+formatted);
		     
			
		flag=	DBConnection.insertorderdetails(i,itemn.trim(),qua,price,formatted);	
		
		if(flag)
		{
			
			rs=	DBConnection.selectitems(i);	
			while(rs.next())
			{
				
			qual=	rs.getInt(4);
			pp=	rs.getString(5);	
			
			
		data=	pp.split(" ");
		
		
		totalprice=	Integer.parseInt(data[0].trim())*qual;
		
		System.out.println("totalprice is >>>>>>>>>>>>>>>>>>>>>>"+totalprice);
		
	existingamount	=DBConnection.takeamount(tno,i,"process");
		flagvalue=	DBConnection.updateamount(existingamount+totalprice,tno,i,"process",itemname,qua,price);
				
			}
			
		if	(flagvalue)
		{
			
			
	i = DBConnection.selectordernum(tno);
			
			System.out.println("i is>>>>>>>>>>>>>>"+i);
			ll	=DBConnection.getordereddetails(i);
		
		System.out.println("list content is >>>>>>>>>>>>>>>>>>>"+ll);
			
			
		  response = Utitlity.constructJSON4(ll.toString(),String.valueOf(i),true);
		
		System.out.println("response"+response);
		return response;
	
			
		}
		
		else
		{
			
			
			
			
			
		}
			
			
			
			
		}
		
		else
		{
			
			
			
			
			
		}
		
		
		
		
		
			
			
			
			
	
}
		return response;
}
}