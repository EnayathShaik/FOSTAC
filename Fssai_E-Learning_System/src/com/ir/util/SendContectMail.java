package com.ir.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendContectMail {

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

	public boolean mailProperty(String msg, String email, String id) {

		boolean flag = false;
		this.body = msg;
		String toEmail = "fics@fssai.gov.in";

		this.to = toEmail;
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
			message.setText("Hello my  Id is  :- " + id
					+ ",  My EmailId is :- " + email
					+ ", My message to You:-  " + body);
			Transport.send(message);
			System.out.println("after sent mail");

			flag = true;
		} catch (Exception e) {
			flag = false;

			e.printStackTrace();
		}
		// return ret;
		return flag;
	}

}
