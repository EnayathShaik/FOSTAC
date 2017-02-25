package com.ir.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail {

	private String from = "fics@fssai.gov.in";
	String password = "F$$@i2014";
	private String to;
	private String subject = "FSSAI Support";
	private String body;

	static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "mail.gov.in");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}

	
	String SMTP_HOST_NAME = "mail.gov.in";
	String SMTP_PORT = "465";		
	String SMTP_AUTH_USER = "fics@fssai.gov.in";
	String SMTP_AUTH_PWD  = "F$$@i2014";
	
	
	String emailMsgTxt      = "";
	String emailSubjectTxt  = "";
	String emailCC = "fssai.labs@gmail.com";
	String emailFromAddress = "fics@fssai.gov.in";
	String fileName = "";
    String strCCMail = "";
     
	public void mailProperty(String emailMsgTxt , String mail,String id, String pass , String username )
	{	   
				 
	                String hostname= SMTP_HOST_NAME;
	                String port= SMTP_PORT ;
	                
	                String username1 =SMTP_AUTH_USER;
	                String password1 = SMTP_AUTH_PWD;  
	                String from= emailFromAddress;
	                //String from= mail;
	                String ccMail=emailCC;
	                SMTP_HOST_NAME = hostname.trim();
	                SMTP_PORT = port.trim();
	                SMTP_AUTH_USER = username1.trim();  
	                SMTP_AUTH_PWD=password1.trim() ;      
	                emailFromAddress=from.trim();
	                strCCMail=ccMail.trim();
	                emailSubjectTxt = "FSSAI Support";
	                
	                StringBuffer emailMessage = new StringBuffer("Dear "+username);
	                emailMessage.append("<br/>");
	                emailMessage.append("<br/>");
	                emailMessage.append("Your User ID "+id+" has been created successfully with password : "+pass);
	                emailMessage.append("<br/>");
	                emailMessage.append("<br/>");
	                emailMessage.append("<br/>");
	                emailMessage.append(" Regards");
	                emailMsgTxt = "Dear  "+username +", "+" \r\n "+"\n"+System.getProperty("line.separator")+
	                		" Your User ID "+id+" has been created successfully with password : "+pass+"\r\n "+"\n"+System.getProperty("line.separator")+
	                		" Regards";
	                try{
	                	postMail( mail, emailSubjectTxt, emailMessage.toString(), emailFromAddress,strCCMail);	
	                }catch(Exception e){
	                	e.printStackTrace();
	                }
	                
		
	}
	
	public void postMail( String recipients, String subject,
			 String message , String from, String strccMail) throws MessagingException
{
	try
	{
	boolean debug = true;
	SMTP_HOST_NAME = SMTP_HOST_NAME ;   
	
	//Set the host smtp address
	Properties props = new Properties();
	props.put("mail.smtp.host", SMTP_HOST_NAME);
	props.put("mail.smtp.port",SMTP_PORT);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.debug", "true");
	props.put("mail.smtp.socketFactory.port", SMTP_PORT);
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.fallback", "true");
	props.put("mail.smtp.timeout", 1000);
	SMTPAuthenticator auth = new SMTPAuthenticator();
	Session session= Session.getInstance(props,auth);
	session.setDebug(debug);
	
	// create a message
	Message msg = new MimeMessage(session);
	
	// set the from and to address
	msg.setFrom(new InternetAddress(from));
	msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipients));
	msg.setRecipient(Message.RecipientType.CC, new InternetAddress(strCCMail));
	msg.setSubject(subject);
	msg.setContent(message, "text/html;charset=utf-8");
	Transport.send(msg);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println(e);
	}
}

	
/*	public boolean mailProperty1(String msg, String email, String id) {

		boolean flag = false;
		this.body = msg;
		String ret = "success";
		try {
			Session session = Session.getDefaultInstance(properties,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(from, password);
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(subject);
			System.out.println("in send mail class");
			message.setText("Dear " + id
					+ ",  Your EmailId is :- " + email
					+ ", Your ID Created Successfully.:-  " + body);
			Transport.send(message);
			System.out.println("after sent mail");

			flag = true;
		} catch (Exception e) {
			flag = false;

			e.printStackTrace();
		}
		// return ret;
		return flag;
	}*/
	

	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

	String username="";
	String password="";

		public PasswordAuthentication getPasswordAuthentication()
		{
			String username1 =  SMTP_AUTH_USER;
			String password1 = SMTP_AUTH_PWD;
			username= username1.trim();
			
			password=password1.trim();
			
			return new PasswordAuthentication(username, password);
		}
	}
	

	/*************************************change by prabha for sending file attachment***********************************************************/

	public void postMailFileAttach( String recipients, String subject,
							 String message , String from,String fileName,String strccMail) throws MessagingException
	{
	 try
	 {
		 boolean debug = true;
		 	SMTP_HOST_NAME=SMTP_HOST_NAME ;
	      
		 	//Set the host smtp address
		 	SMTP_HOST_NAME=SMTP_HOST_NAME ;   
	  	
		 	//Set the host smtp address
		 	Properties props = new Properties();
		 	props.put("mail.smtp.host", SMTP_HOST_NAME);
		 	props.put("mail.smtp.port",SMTP_PORT);
		 	props.put("mail.smtp.auth", "true");
		 	props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "true");
		 	
		 	Authenticator auth = new SMTPAuthenticator();
		 	Session session= Session.getInstance(props,auth);
		 	session.setDebug(debug);

		 	MimeMessage msg = new MimeMessage(session); 
		 	MimeBodyPart mbp1 = new MimeBodyPart();
		 	mbp1.setContent(message, "text/html");
		 	msg.setContent(message, "text/html;charset=utf-8");
		 	MimeBodyPart attachmentPart = new MimeBodyPart();    

		 	DataSource source = new FileDataSource(fileName);   
		 	attachmentPart.setDataHandler(new DataHandler(source)); 
		 	int indx = fileName.lastIndexOf("/");
		 	fileName = fileName.substring(indx+1);   
	   
		 	attachmentPart.setFileName(source.getName()); 
	                   	
		 	Multipart multipart = new MimeMultipart(); 
		 	multipart.addBodyPart(mbp1);         
		 	multipart.addBodyPart(attachmentPart); 
	        String ccMail=emailCC;
	        strCCMail=ccMail;

	        msg.setFrom(new InternetAddress(from));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
	        msg.setRecipient(Message.RecipientType.CC, new InternetAddress(strCCMail));
	        msg.setSubject(subject);
	        msg.setContent(multipart); 
	    
	        Transport.send(msg);
	 
	 	}catch(Exception e)
	 	{
	 		System.out.println("Exception:"+e);
	 	}
	}



}
