package jab.lejos.liverobots.model;

public abstract class RobotFactory {

	public abstract Object getRobot(RobotType type) throws RobotFactoryException;
	public abstract Object getRobot(String type) throws RobotFactoryException;
}
