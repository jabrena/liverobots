package jab.lejos.ev3.actuators;

import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.RegulatedMotor;

public class MotorTest {	

	private static RegulatedMotor leftMotor;
	private static RegulatedMotor rightMotor;
	private final static int speedMotor = 720;
	private final static int accelerationMotor = 800;
	
	public static void main(String[] args){

		leftMotor = Motor.A;
		rightMotor = Motor.C;
		leftMotor.setSpeed(speedMotor);
		rightMotor.setSpeed(speedMotor); 
		leftMotor.setAcceleration(accelerationMotor);
		rightMotor.setAcceleration(accelerationMotor);
		leftMotor.resetTachoCount();
		rightMotor.resetTachoCount();
		leftMotor.rotateTo(0);
		rightMotor.rotateTo(0);

		int iterationCounter = 0;
		
		while (!(iterationCounter >= 5)) {	

			leftMotor.forward();
			rightMotor.forward();
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
			leftMotor.stop(true);
			rightMotor.stop(true);

			iterationCounter++;
			
			try { Thread.sleep(1000); } catch (InterruptedException e) {};
	    }
		
		Sound.beepSequence();

		
		System.out.println("EXIT");		
		System.exit(0);
	}
	
}
