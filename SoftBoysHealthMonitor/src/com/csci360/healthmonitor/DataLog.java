package com.csci360.healthmonitor;

import java.util.ArrayList;

public class DataLog {
	
	private static ArrayList<Integer> stepCounts = new ArrayList<Integer>();
	private static ArrayList<Integer> awoken = new ArrayList<Integer>();
	private static ArrayList<Integer> heartRates = new ArrayList<Integer>();
	
	public static void addHeartRate(int bpm){
		heartRates.add(bpm);
	}
	public static void addStepCount(int steps){
		stepCounts.add(steps);
	}
	public static void addAwoken(int awoken){
		stepCounts.add(awoken);
	}
	
	public static int averageHeartRate(){
		int average=0;
		
		for(int i = 0; i < heartRates.size();++i){
			average+=heartRates.get(i);
		}
		
		average/=heartRates.size();
		
		return average;
		
	}
	public static int averageAwoken(){
		int average=0;
		
		for(int i = 0; i < awoken.size();++i){
			average+=awoken.get(i);
		}
		
		average/=awoken.size();
		
		return average;
		
	}
	public static int averageStepCount(){
		int average=0;
		
		for(int i = 0; i < stepCounts.size();++i){
			average+=stepCounts.get(i);
		}
		
		average/=stepCounts.size();
		
		return average;
	}
		
		private static int stepCount;
		private static int timesAwoken;
		
		
		
		public static int getStepCount(){
			return stepCount;
		}
		
		public static void addStep(){
			stepCount++;
		}
		
		public static void setStepCount(int newCount){
			stepCount = newCount;
		}
		
		public static void reset(){
			stepCount=0;
			timesAwoken=0;
		}
		public static int getTimesAwoken(){
			return timesAwoken;
		}
		
		public static void addAwoken(){
			timesAwoken++;
		}
		
		public static void setTimesAwoken(int newCount){
			timesAwoken = newCount;
		}
		
		public static void resetWokeUp(){
			stepCount=0;
			
		}
		
	}


