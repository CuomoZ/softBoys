package com.csci360.healthmonitor;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test1(){
		DataLog.addHeartRate(50);
		DataLog.addHeartRate(100);
		assertEquals(DataLog.averageHeartRate(), 75, 1); 
	}
	@Test
	public void test2(){
		DataLog.setTimesAwoken(24);
		DataLog.addAwoken();
		assertEquals(DataLog.getTimesAwoken(), 25, 0); 
	}
	@Test
	public void test3(){
		DataLog.addAwoken();
		DataLog.reset();
		assertEquals(DataLog.getTimesAwoken(), 0, 0); 
	}
	@Test
	public void test4(){
		boolean s=SensorController.sleepMode();
		SensorController.toggleSleep();
		assertEquals(SensorController.sleepMode(), !(s));
		SensorController.toggleSleep();
	}
	@Test
	public void test5(){
		DataLog.reset();
		Accelerometer.move();
		assertEquals(DataLog.getStepCount(), 1, 0); 
	}
	
	
}
