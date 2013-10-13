package jab.lejos.liverobots.model;

public interface IRobotFactory {

	public Object getRobot(RobotType type) throws RobotFactoryException;
	public Object getRobot(String type) throws RobotFactoryException;
}
