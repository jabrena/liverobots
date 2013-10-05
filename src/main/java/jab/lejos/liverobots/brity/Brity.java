package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.model.RobotEV3;
import jab.lejos.liverobots.brity.model.RobotFactory;
import jab.lejos.liverobots.brity.model.RobotType;

public class Brity {	

	private static RobotEV3 brityBody;
	
	public Brity(){
		brityBody = (RobotEV3) RobotFactory.getRobot(RobotType.EV3);
	}

	public void debugBrity(){
		System.out.println("LS: " + brityBody.getLeftSound());
		System.out.println("RS: " + brityBody.getRightSound());
		System.out.println("DS: " + brityBody.getDiffSound());
		System.out.println("D:  " + brityBody.getDistance());
		System.out.println("LS: " + brityBody.getLightLeve());
		System.out.println("=======");
	}
	
	public RobotEV3 getRobot(){
		return this.brityBody;
	}
	
}
