package jab.lejos.liverobots.model;


public abstract class Robot {

	private RobotType type = null;
	
	public Robot(RobotType type){
		this.type = type;
	}

	public abstract int getBatteryVoltage();

}
