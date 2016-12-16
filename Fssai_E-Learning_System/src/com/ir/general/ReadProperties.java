package com.ir.general;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

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
			String dbProtocol = properties.getProperty(DBUtil.DBSERVER_PROTOCOL_PROPERTY);
			String dbHostname = properties.getProperty(DBUtil.DBSERVER_HOST_PROPERTY);
			String dbPort = properties.getProperty(DBUtil.DBSERVER_PORT_PROPERTY);
			String dbDatabase = properties.getProperty(DBUtil.DBSERVER_DATABASE_PROPERTY);
			String dbUsername = properties.getProperty(DBUtil.DBSERVER_USERNAME_PROPERTY);
			String dbPassword = properties.getProperty(DBUtil.DBSERVER_PASSWORD_ID_PROPERTY);
			String dbDriver = properties.getProperty(DBUtil.DBSERVER_DRIVER_PROPERTY);
			String databaseDriverUrl = DBUtil.databaseUrl  =dbDriver+"://"+dbHostname+"/"+dbDatabase;
			DBUtil.driverUrl = databaseDriverUrl;
			DBUtil.dbUsername = dbUsername;
			DBUtil.dbPassword = dbPassword;
			System.out.println("Db Url:"+DBUtil.driverUrl+ "\t username:"+ DBUtil.dbUsername);
			
		}catch(Exception e){
			
		}
	}
}
