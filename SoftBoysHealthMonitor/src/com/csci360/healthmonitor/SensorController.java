package com.csci360.healthmonitor;

public class SensorController extends Thread{
	
	static boolean sleepMode;
	
	public static void toggleSleep(){
		sleepMode = (sleepMode)?false : true;
		if (sleepMode){
			Accelerometer.setTimeout(10000);
		}
		else Accelerometer.setTimeout(500);
		   
	}
	
	public static int readHeartRate(){
		DataLog.addHeartRate(HeartRateSensor.getHeartRate());
		return HeartRateSensor.getHeartRate();
		
	}
	
	public static int returnStepCount(){
		if(sleepMode==false)
		return DataLog.getStepCount();
		else return DataLog.getTimesAwoken();
	}
	
	public static void setStepCount(int newCount){
		DataLog.setStepCount(newCount);
	}
	
	public static void addStepToCounter(){
		if(sleepMode==false)
		DataLog.addStep();
		else
		DataLog.addAwoken();
		
		UI.setSteps(SensorController.returnStepCount());
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int heartRateNow = HeartRateSensor.getHeartRate();
			UI.setHeart(heartRateNow);
			DataLog.addHeartRate(heartRateNow);
			UI.setAverageHeart(DataLog.averageHeartRate());
			
			
		}
		
	}
	
	public static void reset(){
		DataLog.reset();
	}
	
	public static boolean sleepMode(){
		return sleepMode;
	}
	
	
	

}
