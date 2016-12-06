package com.ir.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static boolean isNotNull(String value){
		if(value != null && !("".equalsIgnoreCase(value)))
		return true;
		else 
		return false;
	}
	public static String currentDate(String pattern){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
		String date = simpleDateFormat.format(new Date());
		return date;
	}
}
