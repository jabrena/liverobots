package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;



public class EV3ColorSensorTest {

	public static void main(String[] args) throws InterruptedException {
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S1);
		color.setFloodlight(true);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        //LCD.drawString("CS: " + color.get getLightValue(), 0, 0);
			//System.out.println("CS: " + color.getLightValue());
			Thread.sleep(20);
	    }

		color.setFloodlight(false);
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);

	}

}
