package jab.lejos.ev3.sensors;

import lejos.hardware.Button;
import lejos.hardware.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class EV3IRSensorTest2 {

	private final static int SWITCH_DELAY = 250;
	private final static int IR_PROX = 0;
	
	public static void main(String[] args) throws InterruptedException {
		EV3IRSensor ir = new EV3IRSensor(SensorPort.S1);
		//ir.switchMode(IR_PROX,SWITCH_DELAY);
		float ranges[];
		
		LCD.clear();

		while (!Button.ESCAPE.isDown()) {
			
			ranges = ir.getRanges();
			if(ranges.length > 0){
				System.out.println("IR Ranges: " + ranges.length);
				if(ranges.length == 1){
					System.out.println("IR: " + ranges[0]);
				}else if(ranges.length == 2){
					System.out.println("IR: " + ranges[0]);
					System.out.println("IR: " + ranges[1]);
				}else if(ranges.length == 3){
					System.out.println("IR: " + ranges[0]);
					System.out.println("IR: " + ranges[1]);
					System.out.println("IR: " + ranges[2]);
				}
			}
			Thread.sleep(SWITCH_DELAY);
	    }
		
		LCD.clear();
		System.out.println("EXIT");		
		System.exit(0);
		
	}

}
