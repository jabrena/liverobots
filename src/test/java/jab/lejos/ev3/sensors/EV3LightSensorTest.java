package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTLightSensor;



public class EV3LightSensorTest {

	public static void main(String[] args) throws InterruptedException {
	    NXTLightSensor light = new NXTLightSensor(SensorPort.S1);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        //LCD.drawString("LS: " + light.getLightValue(), 0, 0);
			//System.out.println("LS: " + light.getLightValue());
			Thread.sleep(20);
		}

		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
		
	}

}
