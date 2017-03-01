package com.zentech.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ZLogger {
	String type;
	String message;
	String className;
	
	public ZLogger(String type, String message, String className) {
		super();
		this.type = type;
		this.message = message;
		this.className = className;
		showDebugLog();
	}
	
	public void showDebugLog(){
		Logger logger = LoggerFactory.getLogger(ZLogger.class);
        logger.info("ClassName : "+className+ " Type : "+type+ " Message : "+message);
        logger.debug("ClassName : "+className+ " Type : "+type+ " Message : "+message);
        logger.error("ClassName : "+className+ " Type : "+type+ " Message : "+message);
	}
	
	

}
