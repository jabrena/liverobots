package jab.lejos.ev3.sensors;
import lejos.nxt.Button;
import lejos.nxt.EV3IRSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UARTPort;


public class EV3IRSensorTest3 {

	private final static int SWITCH_DELAY = 250;
	private final static int IR_SEEK = 1;
	
	public static void main(String[] args) throws InterruptedException {
		EV3IRSensor ir = new EV3IRSensor((UARTPort) SensorPort.S1);
		//ir.switchMode(IR_SEEK,SWITCH_DELAY);
		
		byte bearings[] = null;
		int offset = 0;
		int len = 0;
		
		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
			
			ir.getBearings(bearings, offset, len);

			Thread.sleep(50);
	    }
		
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
		
	}

}
