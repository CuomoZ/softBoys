package com.csci360.healthmonitor;

import java.util.Random;

public class Accelerometer extends Thread{
	private static boolean ismoving;
	private static int timeout;
	
	public static boolean ismoving(){
		return ismoving;
		
	}
	
	public static void setTimeout(int newTime){
		timeout=newTime;
	}
	
	public static void move(){
		SensorController.addStepToCounter();
		
	}
	
	public void run(){
		timeout = 500;
		
		while(true){
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random rand = new Random();
			
			int move = rand.nextInt(10);
			ismoving = ((move%2)==0)?true:false;
			if(ismoving) move();
			
		}
	}
	
	
		
}
