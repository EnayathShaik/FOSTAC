package com.ir.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionPasswordANDVerification {

	public static String encryptPass(String pass) throws NoSuchAlgorithmException{
	String password = "null";
	
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(pass.getBytes());
    
    byte byteData[] = md.digest();

    //convert the byte to hex format method 1
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
     sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
 password=sb.toString();
    /*System.out.println("Hex format : " + sb.toString());
    
    //convert the byte to hex format method 2
    StringBuffer hexString = new StringBuffer();
	for (int i=0;i<byteData.length;i++) {
		String hex=Integer.toHexString(0xff & byteData[i]);
	     	if(hex.length()==1) hexString.append('0');
	     	hexString.append(hex);
	}
	System.out.println("Hex format : " + hexString.toString());*/
	return password;
}
		
	}
	

