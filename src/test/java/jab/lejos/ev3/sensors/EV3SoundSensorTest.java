package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTSoundSensor;

public class EV3SoundSensorTest {

	public static void main(String[] args) throws InterruptedException {
		NXTSoundSensor sound = new NXTSoundSensor(SensorPort.S1);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        //LCD.drawString("SS: " + sound.readValue(), 0, 0);
			//System.out.println("SS: " + sound.readValue());
			Thread.sleep(20);
	    }
		
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
	}
}

