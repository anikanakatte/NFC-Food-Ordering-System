package com.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




@Path("/total")
public class Totalamount
{
	
	@GET
	@Path("/amount")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("tableno") String tno,@QueryParam("orderno") String ono,@QueryParam("uid") String uid) throws SQLException, Exception
	{
		
		ArrayList<String> data=new ArrayList<String>();
		String response="";
		
			System.out.println("uid ids>>>>>>>>>>>>>>>>>>>>>>>>>>"+uid);
			System.out.println(tno+ono);
			
		String mail = DBConnection.getusermailid(uid);
			
			
			
			
			int price = DBConnection.selecttotalamount(tno,ono);
			
			System.out.println("Amount is >>>>>>>>>"+price);
			
			
		 data = DBConnection.selectitems(ono);
			
		
			String filepath="G:\\Workspace\\Hotel_Management_ServerApp\\Billamount\\Bill.txt";
		System.out.println("data is >>>>>>>>>>>>>>>>>>>>>>>>"+data);	
			
		 File file = new File("G:\\Workspace\\Hotel_Management_ServerApp\\Billamount\\Bill.txt");
		 file.delete();
	      if (file.createNewFile()){
	        System.out.println("File is created!");
	        
	        try {
	            FileWriter writer = new FileWriter("G:\\Workspace\\Hotel_Management_ServerApp\\Billamount\\Bill.txt", true);
	            writer.write("Dear"+"  "+uid+" "+" Bill Number is "+" "+ono);
	            writer.write("\r\n");  
	            writer.write("-------------------------------------"); 
	            writer.write("\r\n");  
	            writer.write("ITEM NAME"+"         "+"QUANTITY"+"   "+"PRICE");
	            writer.write("\r\n");  
	            writer.write("-------------------------------------");
	            writer.write("\r\n");  
             for(int i=0;i<data.size();i++) 
                           {
	            	            System.out.println(data.get(i));
	            	            writer.write(data.get(i)); 
	            	            writer.write("\r\n");  
	            	        }

             
	            writer.write("-------------------------------------"); 
	            writer.write("\r\n"); 
	            writer.write("Total Bill Amount is "+price+" "+"Rs"); 
	        	
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
				
				
	      }
			
	        

String userlogindetail = "Your Bill Details:"; 
		
MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap(); 
mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html"); 
mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml"); 
mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain"); 
mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed"); 
mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822"); 

boolean sendMailflag = CL_SendMail.sendPersonalizedMail1(mail.trim(),
		"prochamps2@gmail.com", "adianimahikar",
		"QR code Details", userlogindetail, filepath,
		"smtp.gmail.com", "465");
System.out.println("sendMailflag flag is >>>>>>>>>>>>>>>>>>>>>>>>>"+sendMailflag);
	        
	        
	        
	        
	        
	        
	        
		
				
				response = Utitlity.constructJSON2(String.valueOf(price),false);
				System.out.println("Response*** :"+response);	
				
				
		
	

		
}
	      return response;
}
	
}