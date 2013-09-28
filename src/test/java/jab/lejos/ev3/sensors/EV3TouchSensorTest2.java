package jab.lejos.ev3.sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class EV3TouchSensorTest2 {

	public static void main(String[] args) throws InterruptedException {
		TouchSensor touch2 = new TouchSensor((ADSensorPort) SensorPort.S2);

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
