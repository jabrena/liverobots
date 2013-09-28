package jab.lejos.ev3.sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;


public class EV3LightSensorTest {

	public static void main(String[] args) throws InterruptedException {
	    LightSensor light = new LightSensor((ADSensorPort) SensorPort.S1);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        LCD.drawString("LS: " + light.getLightValue(), 0, 0);
			System.out.println("LS: " + light.getLightValue());
			Thread.sleep(20);
		}

		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
		
	}

}
