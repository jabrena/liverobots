package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.TouchSensor;

public class EV3TouchSensorTest2 {

	public static void main(String[] args) throws InterruptedException {
		TouchSensor touch2 = new TouchSensor(SensorPort.S2);

		LCD.clear();
		
		while (!Button.ESCAPE.isDown()) {
	        LCD.drawString("TS: " + touch2.isPressed(), 0, 0);
			System.out.println("TS: " + touch2.isPressed());
			Thread.sleep(20);
	    }

		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);

	}

}
