package com.server;
import java.io.File;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;
import javax.mail.internet.*;

public class CL_SendMail {
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		

	
	public static boolean sendPersonalizedMail(String recipient, String subject,String message,String qrcode,String filename)  
	{
		boolean debug = true;
		String from="prochamps2@gmail.com";
		try
		{
			
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			

			Session session = Session.getInstance(props,	new javax.mail.Authenticator() 
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("prochamps2@gmail.com", "adianimahikar");
				}
			});

			session.setDebug(debug);

			Message msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(from);
			msg.setFrom(addressFrom);
		
			InternetAddress addressTo = new InternetAddress();

		
				addressTo = new InternetAddress(recipient);


			msg.setRecipient(Message.RecipientType.TO, addressTo);

			// Setting the Subject and Content Type
			
			msg.setSubject(subject);
			msg.setContent(message, "text/plain");
		
			   BodyPart messageBodyPart = new MimeBodyPart();
			   messageBodyPart.setText(message);
			   Multipart multipart = new MimeMultipart();
			   multipart.addBodyPart(messageBodyPart);
			   if(filename.equals("no"))
			   {
				   
			   }
			   else
			   {
					  messageBodyPart = new MimeBodyPart();
					  DataSource source = new FileDataSource(filename);
					  messageBodyPart.setDataHandler(new DataHandler(source));
					 File file = new File(filename);
					 messageBodyPart.setFileName(file.getName());
					  multipart.addBodyPart(messageBodyPart);
			   }
			   msg.setContent(multipart);
			       Transport.send(msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
			 debug = false;
		}		
		return debug;
	}
	
	
	
	
	
	
	
	
	 
	 public static final boolean sendPersonalizedMail1(String emailid,final String fromemailid,final String password,String subject,String message, String attachfilepath,String hostname,String portnumber)  
		{
		 
		 			
			System.out.println("Subject "+subject.trim());
			System.out.println("Message "+message.trim());
			System.out.println("From "+fromemailid.trim());
			
		
			boolean debug = true;
			boolean flag=true;
			
					
			Properties props = new Properties();
			
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", portnumber);
			props.put("mail.smtp.socketFactory.port", portnumber);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			
			Session session = Session.getInstance(props,new javax.mail.Authenticator() 
			{
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
				{
					return new javax.mail.PasswordAuthentication(fromemailid, password);
				}
			});

			session.setDebug(debug);
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom=null;
				
			
		 		
		 		try 
				{
					addressFrom = new InternetAddress(fromemailid);
					
					msg.setFrom(addressFrom);
					
					InternetAddress addressTo=new InternetAddress();
					
					addressTo.setAddress(emailid);
					
					msg.setRecipient(Message.RecipientType.BCC, addressTo);
								
					msg.setSubject(subject);
					
										
					msg.setText(message);
							
					msg.setContent(message, "text/html");
					
					
					if(attachfilepath!="")
					{
						
						System.out.println("Filename is "+attachfilepath);
						
						File file = new File(attachfilepath);
						String name = file.getName();
						
						BodyPart messageBodyPart = new MimeBodyPart();
						//messageBodyPart.setText(message);
						messageBodyPart.setContent(message, "text/html");
					    Multipart multipart = new MimeMultipart();
					    multipart.addBodyPart(messageBodyPart);
					    messageBodyPart = new MimeBodyPart();
					    
					    DataSource source = new FileDataSource(attachfilepath);
					    messageBodyPart.setDataHandler(new DataHandler(source));
					    
					    messageBodyPart.setFileName(name);
					    multipart.addBodyPart(messageBodyPart);
					    msg.setContent(multipart);
					    
					}	
				
				Transport.send(msg);
				
				}
				catch (AddressException e1) 
				{
							
					flag=false;
				}
			
				catch(SendFailedException sendingfailed)
				{
					flag=false;
					//Address[] invalidaddress=sendingfailed.getInvalidAddresses();
					
					//System.out.println("Total Number of Invalid Address "+invalidaddress);
					
				}
				catch (MessagingException e1) 
				{
					
						flag=false;
						//e2.printStackTrace();
						//TestLog.writeException(e2);
					
				}
				
		 	
			return flag;
			
			
		}
	public static void main(String args[]) throws MessagingException, Exception
	{
		
	}

}
