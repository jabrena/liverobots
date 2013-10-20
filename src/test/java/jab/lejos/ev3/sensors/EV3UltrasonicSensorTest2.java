package jab.lejos.ev3.sensors;
import lejos.nxt.Button;
import lejos.nxt.I2CPort;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class EV3UltrasonicSensorTest2 {

	public static void main(String[] args) throws InterruptedException {
		UltrasonicSensor ultrasonic = new UltrasonicSensor((I2CPort) SensorPort.S1);
		float ranges[];

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {

			ranges = ultrasonic.getRanges();
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
