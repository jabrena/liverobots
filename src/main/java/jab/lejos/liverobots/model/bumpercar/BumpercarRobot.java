package jab.lejos.liverobots.model.bumpercar;

import jab.lejos.liverobots.model.Robot;
import jab.lejos.liverobots.model.RobotType;

public abstract class BumpercarRobot extends Robot{

	public BumpercarRobot(RobotType type){
		super(type);
	}
	
	public abstract int getDistance();

	public abstract void forward(int i);

	public abstract void backward(int i);

	public abstract void turnLeft(int i);

	public abstract void turnRight(int i);

}
