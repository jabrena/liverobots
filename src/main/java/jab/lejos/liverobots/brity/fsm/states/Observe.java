package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.Robot;
import lejos.nxt.Sound;

public class Observe {

	private static Robot brityBody;
	
	public static void main(String[] args){

		brityBody = Robot.getInstance();
		Sound.setVolume(30);
		Sound.beepSequenceUp();

		int iterationCounter = 0;
		
		//while ((!Button.ESCAPE.isDown()) || (!(iterationCounter >= 10))) {
		while (!(iterationCounter >= 20)) {
		//for(int i=0; i<=10; i++){	
		
			debugBrity();
			
			iterationCounter++;
			
			try { Thread.sleep(1000); } catch (InterruptedException e) {};

		}
			Sound.beepSequence();
			System.out.println("EXIT");		
			System.exit(0);
	}	
	
	private static void debugBrity(){
		System.out.println("LS: " + brityBody.getLeftSound());
		System.out.println("RS: " + brityBody.getRightSound());
		System.out.println("DS: " + brityBody.getDiffSound());
		System.out.println("D:  " + brityBody.getDistance());
		System.out.println("LS: " + brityBody.getLightLeve());
		System.out.println("=======");
	}
	
}
