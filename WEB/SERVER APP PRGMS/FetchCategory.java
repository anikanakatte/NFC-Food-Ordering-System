package com.server;


import java.sql.SQLException;
import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.database.AdminDAO;





@Path("/fetch")
public class FetchCategory
{
	
	@GET
	@Path("/category")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("name") String cname,@QueryParam("tableno") String tno,@QueryParam("dt") String dtt) throws SQLException, Exception
	{
		System.out.println("its came indise fetch catogory");
		StringBuffer sbone=new StringBuffer();
		StringBuffer sb=new StringBuffer();
		ArrayList<String> dd=new ArrayList<String>();
		ArrayList<String> cid=new ArrayList<String>();
		
		ArrayList<String> itemlist=new ArrayList<String>();
		
		
		boolean flag=	AdminDAO.insertordernumber(tno,dtt);
	System.out.println("flag is >>>>>>>>>>>>>>>>>"+flag);
		cid=	AdminDAO.fetchcid();
			for(int i=0;i<cid.size();i++)
			{
				
				itemlist=	AdminDAO.paticularitemlist(cid.get(i));
				
				sbone.append(itemlist);
				sbone.append(",");
				
			}
		
		System.out.println("string buffer is >>>>>>>>>>>>>>>>>>>>>>>>>"+sbone.toString());
	dd=	AdminDAO.fetchcategory();
		sb.append(dd);
		
	System.out.println("string buffer is >>>>>>>>>>>>>>>>>>>>>"+sb.toString());	
	  
	String  response = Utitlity.constructJSON3(sb.toString(),sbone.toString(),true);
	
	System.out.println("response"+response);
	return response;
		
	  
  }
	
	
	
		
}