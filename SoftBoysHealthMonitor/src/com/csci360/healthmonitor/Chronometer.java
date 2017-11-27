package com.csci360.healthmonitor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chronometer extends Thread{
	
	static Date date = new Date();
	static DateFormat df = new SimpleDateFormat("h:mm:ss a");
	
	
	public static String getDate(){
			date = new Date();
			return df.format(date);		
	}
	
	public void run(){
		while(true){
			String dateSetter = getDate();
			if (dateSetter=="12:00:00 AM"){
				UI.itsMidnight();
			}
			UI.setDate(dateSetter);

		}
		
	}

}
