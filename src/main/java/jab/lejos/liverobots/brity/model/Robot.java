package jab.lejos.liverobots.brity.model;

public abstract class Robot {

	private RobotType type = null;
	
	public Robot(RobotType type){
		this.type = type;
	}
	
	public abstract int getDistance();
	public abstract int getVoltage();
	
}
