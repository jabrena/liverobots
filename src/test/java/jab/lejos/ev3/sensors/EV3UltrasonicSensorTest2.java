package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTUltrasonicSensor;

public class EV3UltrasonicSensorTest2 {

	public static void main(String[] args) throws InterruptedException {
		NXTUltrasonicSensor ultrasonic = new NXTUltrasonicSensor(SensorPort.S1);
		float ranges[];

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {

			ranges = null;//ultrasonic.getRanges();
			if(ranges.length > 0){
				System.out.println("US Ranges: " + ranges.length);
				if(ranges.length == 1){
					System.out.println("US: " + ranges[0]);
				}else if(ranges.length == 2){
					System.out.println("US: " + ranges[0]);
					System.out.println("US: " + ranges[1]);
				}else if(ranges.length == 3){
					System.out.println("US: " + ranges[0]);
					System.out.println("US: " + ranges[1]);
					System.out.println("US: " + ranges[2]);
				}
			}
			Thread.sleep(50);
	    }

		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);

	}

}
