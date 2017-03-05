package com.ir.general;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.ir.bean.common.PropertyUtils;
import com.ir.constantes.Constantes;
import com.ir.constantes.DBUtil;

public class ReadProperties {

	public void readProperties(){
		InputStream inputStream;
		try{
			Properties properties = new Properties();
			String propertiesFileName = "environment.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			if(inputStream != null){
				properties.load(inputStream);
			}else{
				System.out.println("File not found..");
				throw new FileNotFoundException("Environment properties file not found");
			}
//			String dbProtocol = properties.getProperty(Constantes.DBSERVER_PROTOCOL_PROPERTY);
			String dbHostname = properties.getProperty(Constantes.DBSERVER_HOST_PROPERTY);
//			String dbPort = properties.getProperty(Constantes.DBSERVER_PORT_PROPERTY);
			String dbDatabase = properties.getProperty(Constantes.DBSERVER_DATABASE_PROPERTY);
			String dbUsername = properties.getProperty(Constantes.DBSERVER_USERNAME_PROPERTY);
			String dbPassword = properties.getProperty(Constantes.DBSERVER_PASSWORD_ID_PROPERTY);
			String dbDriver = properties.getProperty(Constantes.DBSERVER_DRIVER_PROPERTY);
			
			//
			PropertyUtils.basicLevel = properties.getProperty(Constantes.BASIC_LEVEL);
			PropertyUtils.advanceLevel = properties.getProperty(Constantes.ADVANCE_LEVEL);
			PropertyUtils.specialLevel= properties.getProperty(Constantes.SPECIAL_LEVEL);
			
			String databaseDriverUrl = DBUtil.databaseUrl  =dbDriver+"://"+dbHostname+"/"+dbDatabase;
			DBUtil.driverUrl = databaseDriverUrl;
			DBUtil.dbUsername = dbUsername;
			DBUtil.dbPassword = dbPassword;
			System.out.println("Db Url:"+DBUtil.driverUrl+ "\t username:"+ DBUtil.dbUsername);
			
		}catch(Exception e){
			
		}
	}
}
