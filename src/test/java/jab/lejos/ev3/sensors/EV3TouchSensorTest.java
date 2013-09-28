package jab.lejos.ev3.sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.EV3TouchSensor;

public class EV3TouchSensorTest {


	public static void main(String[] args) throws InterruptedException {
		EV3TouchSensor touch = new EV3TouchSensor((ADSensorPort) SensorPort.S1);

		LCD.clear();
		
		while (!Button.ESCAPE.isDown()) {
	        LCD.drawString("TS: " + touch.isPressed(), 0, 0);
			System.out.println("TS: " + touch.isPressed());
			Thread.sleep(20);
	    }

		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);

	}

}
