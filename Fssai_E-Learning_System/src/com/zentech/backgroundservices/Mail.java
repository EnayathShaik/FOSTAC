package com.zentech.backgroundservices;

import com.ir.util.JavaMail;
import com.zentech.logger.ZLogger;

public class Mail implements Runnable {

	private String emailMsgTxt; 
	private String mail;
	private String id;
	private String pass;
	private String username; 
	
	
	public Mail(String emailMsgTxt, String mail, String id, String pass,
			String username) {
		super();
		this.emailMsgTxt = emailMsgTxt;
		this.mail = mail;
		this.id = id;
		this.pass = pass;
		this.username = username;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			JavaMail javaMail = new JavaMail();
			javaMail.mailProperty(emailMsgTxt,mail,id , pass,username);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("run", e.getMessage(), "Mail.java");
		}
	}
	
	public static void main(String[] args) {
		new Mail("werw", "wrewer", "were", "werew", "were");
	}
}
