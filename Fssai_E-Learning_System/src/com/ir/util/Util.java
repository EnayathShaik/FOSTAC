package com.ir.util;

public class Util {

	public static boolean isNotNull(String value){
		if(value != null && !("".equalsIgnoreCase(value)))
		return true;
		else 
		return false;
	}
}
