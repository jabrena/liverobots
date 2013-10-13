package jab.lejos.liverobots.fsm.model.bumpercar;

import jab.lejos.liverobots.fsm.model.RobotType;

public abstract class BumpercarRobot {

	private RobotType type = null;
	
	public BumpercarRobot(RobotType type){
		this.type = type;
	}
	
	public abstract int getDistance();
	public abstract int getVoltage();

	public abstract void forward(int i);

	public abstract void backward(int i);

	public abstract void turnLeft(int i);

	public abstract void turnRight(int i);

}
