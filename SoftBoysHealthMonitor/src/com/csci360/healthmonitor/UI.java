package com.csci360.healthmonitor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class UI extends JFrame{
	static Color blurple = new Color(25,25,50);
	static Color lightBlue = new Color(160, 200, 214);
	static JFrame frame = new JFrame("fitbit");
	static JPanel panel = new JPanel();
	static JButton getHeart = new JButton("Get HeartRate");
	static JButton sleepTime = new JButton("Sleep Mode");
	static JLabel heartRate = new JLabel("");
	static JLabel timeLabel = new JLabel("12:00 pm");
	static JLabel averageHeart = new JLabel("BPM avg");	
	static JLabel stepLabel = new JLabel("");
	static boolean sleepMode=false;
	
	
	
	public static void main(String[] args){
		
		SensorController.setStepCount(5000);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		        // not worth my time
		    }
		}
		frame.setSize(480, 360);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dayTime();
		panel.setVisible(true);
		panel.setLayout(new GridLayout(0,2));
		frame.add(panel);
		//panel.add(timeLabel);
		timeLabel.setVisible(true);
		
		Font timeFont = new Font("Monaco", Font.PLAIN, 30);
		Font heartFont = new Font("Monaco", Font.PLAIN, 35);
		Font heartButtonFont = new Font("Monaco", Font.PLAIN, 20);
		timeLabel.setFont(timeFont);
		
		String heartRateText = Integer.toString(SensorController.readHeartRate());
		
		heartRate.setText(heartRateText +" BPM");
		heartRate.setForeground(Color.red);
		heartRate.setVisible(true);
		heartRate.setFont(heartFont);		
		//panel.add(heartRate);
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int heartRateNow = SensorController.readHeartRate();
				setHeart(heartRateNow);
				DataLog.addHeartRate(heartRateNow);
				setAverageHeart(DataLog.averageHeartRate());
				

			}
		};
		ActionListener sleepListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SensorController.toggleSleep();
				if(sleepMode==true){
					sleepMode=false;
					dayTime();
				}
				else{
					sleepMode=true;
					nightTime();
				}
				

			}
		};
		
		averageHeart.setVisible(true);
		averageHeart.setFont(heartButtonFont);
		averageHeart.setForeground(Color.red);
		
		//panel.add(averageHeart);
		
		getHeart.setVisible(true);
		getHeart.setFont(heartButtonFont);
		Color maroon = new Color(120, 0, 0);
		getHeart.setForeground(maroon);
		getHeart.setBackground(Color.LIGHT_GRAY);
		getHeart.addActionListener(al);
		getHeart.setFocusable(false);
		//panel.add(getHeart);
		
		
		
		
		String stepLabelCount = Integer.toString(SensorController.returnStepCount());
		stepLabel.setText(stepLabelCount+" Steps");
		
		
		Chronometer clock = new Chronometer();
		clock.start();
		
		SensorController sc = new SensorController();
		sc.start();
		
		Accelerometer accel = new Accelerometer();
		accel.start();
		
		
			
		
		stepLabel.setFont(heartFont);
		stepLabel.setVisible(true);
		
		//panel.add(stepLabel);
		
		frame.setVisible(true);
		
		panel.setFocusable(true);
		
		panel.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
            //setSteps(SensorController.returnStepCount());
            	Accelerometer.move();
            }
            	
            @Override
            public void keyPressed(KeyEvent e) {
            	
                
            }
        });
		
		sleepTime.setFont(heartButtonFont);
		sleepTime.setVisible(true);
		sleepTime.setFocusable(false);
		sleepTime.addActionListener(sleepListener);
		//panel.add(sleepTime);
		
		
		
		
		panel.add(timeLabel, 1,0);
		panel.add(stepLabel, 2,1);
		panel.add(heartRate);
		panel.add(averageHeart);
		panel.add(getHeart);
		panel.add(sleepTime);

		
		
		
	}
	
	public static void setAverageHeart(int heart){
		String heartSet = Integer.toString(heart);
		averageHeart.setText(" AVG bpm: "+heartSet );
	}
	
	public static void setDate(String date){
		timeLabel.setText(date);
	}
	
	public static void setSteps(int steps){
		
		String stepUpdate = Integer.toString(steps);
		if (sleepMode==false)
			stepLabel.setText(stepUpdate+" Steps");
		else
			stepLabel.setText(stepUpdate+" TA");
			
	}
	
	public static void setHeart(int heart){
		String heartSet = Integer.toString(heart);
		heartRate.setText(heartSet +" BPM");
	}
	
	public static void resetSteps(){
		SensorController.reset();
	}
	
	public static void itsMidnight(){
		resetSteps();
	}
	
	public static void dayTime(){
		panel.setBackground(lightBlue);
		SensorController.reset();
		timeLabel.setForeground(Color.BLACK);
		stepLabel.setForeground(Color.BLACK);
		sleepTime.setText("Sleep Mode");
		//sleepMode=true;
		stepLabel.setText("Steps");
		
	}
	public static void nightTime(){
		panel.setBackground(blurple);
		SensorController.reset();
		timeLabel.setForeground(Color.WHITE);
		stepLabel.setForeground(Color.WHITE);
		sleepTime.setText("Wake Up");
		//sleepMode=false;
		stepLabel.setText("TA");
		
		
	}




}
