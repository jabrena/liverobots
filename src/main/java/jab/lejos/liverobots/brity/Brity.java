package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.fsm.model.bumpercar.BumperCarRobotEV3;

public class Brity {	

	private static BumperCarRobotEV3 brityBody;
	
	public Brity(){
		brityBody = BumperCarRobotEV3.getInstance();
	}

	public void debugBrity(){
		System.out.println("LS: " + brityBody.getLeftSound());
		System.out.println("RS: " + brityBody.getRightSound());
		System.out.println("DS: " + brityBody.getDiffSound());
		System.out.println("D:  " + brityBody.getDistance());
		System.out.println("LS: " + brityBody.getLightLeve());
		System.out.println("=======");
	}
	
	public BumperCarRobotEV3 getRobot(){
		return this.brityBody;
	}
	
}
