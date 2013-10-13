package jab.lejos.liverobots.model.beetle;

import jab.lejos.liverobots.model.Robot;
import jab.lejos.liverobots.model.RobotType;

public abstract class BeetleRobot extends Robot{

	public BeetleRobot(RobotType type){
		super(type);
	}

	public abstract int getFrontDistance();
	public abstract int getLeftDistance();
	public abstract int getRightDistance();
	public abstract int getHeading();

	public abstract void goAhead(int i);
	public abstract void goBack(int i);
	public abstract void goLeft(int i);
	public abstract void goRight(int i);

}
