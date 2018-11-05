package com.server;

import java.io.File;
import java.sql.SQLException;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.google.zxing.WriterException;




@Path("/cid")
public class QR
{
	
	@GET
	@Path("/check")

	@Produces(MediaType.APPLICATION_JSON)
	public String employeeUpdate(@QueryParam("name") String cname) throws SQLException, Exception
	{
		String response="";
		if(Utitlity.isNotNull(cname) )
		{
			 
		boolean sendMailflag=false;
			
			System.out.println(cname);
			
	
	String pin = DBConnection.getpinuser(cname);
	
	String mail = DBConnection.getmailuser(cname);
	
System.out.println(""+pin+mail);	
	
	

	
	File f = new File("G:\\Workspace\\Hotel_Management_ServerApp\\qrcode");
	if(!f.exists())
	{   System.out.println("QRCodes Dir Created Successfully.");
		 f.mkdir();
	}
	 
String 	fileName = cname+"_QRCode.png";
	String filePath = "G:\\Workspace\\Hotel_Management_ServerApp\\qrcode\\"+fileName;
	int size = 125;//Version 27 //Size Of QR Code=(((V-1)*4)+21), where V is the QR code version 
    String fileType = "png";
    File qrFile = new File(filePath);
    try {
		QRCodeGenerator.generateQRCodeImage(qrFile,pin,size,fileType);
	} catch (WriterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("QRCode Generated Successfully.....");
	
    

String userlogindetail = " PLease scan your qrcode to get Your Password"; 
		
MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap(); 
mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html"); 
mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml"); 
mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain"); 
mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed"); 
mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822"); 

sendMailflag = CL_SendMail.sendPersonalizedMail1(mail.trim(),
		"prochamps2@gmail.com", "adianimahikar",
		"QR code Details", userlogindetail, filePath,
		"smtp.gmail.com", "465");
 
   
  if(sendMailflag) 
  {
	  
	  response = Utitlity.constructJSON2("success",true);
		System.out.println("Response*** :"+response);	
		
	  
  }
  
  else
	  
  {
	  
	  response = Utitlity.constructJSON2("unsuccess",false);
		System.out.println("Response*** :"+response);	
		
	  
  }
	
	}
	
		return response;
}
}