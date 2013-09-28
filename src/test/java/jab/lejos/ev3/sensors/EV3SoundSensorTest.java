package jab.lejos.ev3.sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

public class EV3SoundSensorTest {

	public static void main(String[] args) throws InterruptedException {
		SoundSensor sound = new SoundSensor((ADSensorPort) SensorPort.S1);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        LCD.drawString("SS: " + sound.readValue(), 0, 0);
			System.out.println("SS: " + sound.readValue());
			Thread.sleep(20);
	    }
		
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
	}
}

