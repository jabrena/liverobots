package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class EV3IRSensorTest {

	private final static int SWITCH_DELAY = 250;
	private final static int IR_PROX = 0;
	
	public static void main(String[] args) throws InterruptedException {
		EV3IRSensor ir = new EV3IRSensor( SensorPort.S1);
		//ir.switchMode(IR_PROX,SWITCH_DELAY);
		
		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
			LCD.drawString("IR: " + ir.getRange(), 0, 0);
			System.out.println("IR Range: " + ir.getRange());
			
			Thread.sleep(SWITCH_DELAY);
	    }
		
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
		
	}

}
