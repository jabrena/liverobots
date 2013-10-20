package jab.lejos.liverobots.model.beetle;

import java.util.List;

import jab.lejos.liverobots.model.Robot;
import jab.lejos.liverobots.model.RobotType;
import lejos.robotics.navigation.Pose;

public abstract class BeetleRobot extends Robot{

	public BeetleRobot(RobotType type){
		super(type);
	}

	public abstract float getFrontDistance();
	public abstract float getLeftDistance();
	public abstract float getRightDistance();
	public abstract float getHeading();
	public abstract Pose getPose();
	public abstract List<Pose> getPoseList();

	public abstract void goAhead(int parameter);
	public abstract void goBack(int parameter);
	public abstract void goLeft(int parameter);
	public abstract void goRight(int parameter);
}
