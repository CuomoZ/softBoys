Soft Boys 360 Final Project

FitBit simulator for Java

Creators: Joe Ayers, Joe Spencer, and Zack Cuomo

Important Information:

This simulation is created by sensing input data from pseudo-random sources.
The screen size is 480x360pixels. A fitbit device in real life has a screen size of 240x180 
pixels. These were doubled for this simulation for legibility.

The accelerometer creates a number between 1 and 10 every 500 milliseconds, and registers as a
"movement" or a "step" if that number is even. The Heart Rate sensor generates a random number 
between 50 and 100 for sample data. Due to the modularity of this program, these could later be 
substituted for more functional hardware. Presently, there is a timeout for the accelerometer. 
When checking for stepCount (i.e. not in SleepMode) it is 500ms, but in sleepMode it is 10000ms, 
so it is a 10s timeout. 

For concurrency, most of the individual components extend from Thread and are run as threads.
This allows for the Clock, Accelerometer, and Heart Rate Sensor to run infinitely, yet also 
independently.
 
For display purposes, the StepCount is set to 5000 upon initialization. At midnight, or when 
sleepMode is engaged, this resets to 0 and increases upon input from the Accelerometer.
The Heart Rate Sensor reads every 30 seconds and adds the newly read data to the log, 
generating a new average.


#Run Instructions!

Simply run the public main method from the UI class to instantiate a new fitbit.