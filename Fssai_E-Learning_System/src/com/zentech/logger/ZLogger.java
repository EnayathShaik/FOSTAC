package com.zentech.logger;

import org.apache.log4j.Logger;

import com.ir.controller.RegistrationController;

public class ZLogger {
	String type;
	String message;
	String className;
	public ZLogger() {
		// TODO Auto-generated constructor stub
	}
	public ZLogger(String type, String message, String className) {
		super();
		this.type = type;
		this.message = message;
		this.className = className;
		
	}
	
	public void showDebugLog(){
		Logger log = Logger.getLogger(ZLogger.class.getName());
		log.debug("ClassName : "+className+ " Type : "+type+ " Message : "+message);
	}
	public void showInfoLog(){
		Logger log = Logger.getLogger(ZLogger.class.getName());
		System.out.println("ClassName : "+className+ " Type : "+type+ " Message : "+message);
		log.info("ClassName : "+className+ " Type : "+type+ " Message : "+message);
	}
	public void showErrorLog(){
		Logger log = Logger.getLogger(ZLogger.class.getName());
		log.error("ClassName : "+className+ " Type : "+type+ " Message : "+message);
	}
	
	

}
