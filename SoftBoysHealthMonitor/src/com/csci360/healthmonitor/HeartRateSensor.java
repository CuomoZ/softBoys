package com.csci360.healthmonitor;

import java.util.Random;

public class HeartRateSensor{
	
	
	public static int getHeartRate(){
		
		Random rand = new Random();
		
		return rand.nextInt(50) + 50;
		
	}
	
	

}
