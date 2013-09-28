package jab.lejos.ev3.sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.EV3ColorSensor;
import lejos.nxt.EV3TouchSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UARTPort;
import lejos.robotics.Color;


public class EV3ColorSensorTest {

	public static void main(String[] args) throws InterruptedException {
		EV3ColorSensor color = new EV3ColorSensor((UARTPort) SensorPort.S1);
		color.setFloodlight(true);

		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
	        LCD.drawString("CS: " + color.getLightValue(), 0, 0);
			System.out.println("CS: " + color.getLightValue());
			Thread.sleep(20);
	    }

		color.setFloodlight(false);
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);

	}

}
