package com.ir.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	
	 private String from ="rahulkrdevchodhry@gmail.com";
	 String password ="9934397821";
	   private String to;
	   private String subject="login password";
	   private String body;
	
	   static Properties properties = new Properties();
	   static
	   {
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }
	   
	
	public boolean mailProperty( String pass,String email,String name){
		
		boolean flag=false;
		this.body=pass;
		
		  
		this.to=email;
		      try
		      {
		         Session session = Session.getDefaultInstance(properties, 
		            new javax.mail.Authenticator() {
		            protected PasswordAuthentication
		            getPasswordAuthentication() {
		            return new
		            PasswordAuthentication(from, password);
		            }});
		         Message message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(from));
		         message.setRecipients(Message.RecipientType.TO,
		            InternetAddress.parse(email));
		         message.setSubject(subject);
		         message.setText("Hello "+name+" your Password is :"+body);
		         //Transport.send(message);
		         
		         flag=true;
		      }
		      catch(Exception e)
		      {
		    	  flag=false;
		         
		         e.printStackTrace();
		      }
		     // return ret;
			return flag;
		   }
		
		
	}


