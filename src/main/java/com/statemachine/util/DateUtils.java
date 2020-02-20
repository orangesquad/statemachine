package com.statemachine.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private DateUtils() {
		
	}
	public static String getCurrentDate() {
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    return formatter.format(date);  	    
	}	
}
