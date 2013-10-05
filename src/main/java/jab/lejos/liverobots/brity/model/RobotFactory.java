package jab.lejos.liverobots.brity.model;

public class RobotFactory {

	public static Robot getRobot(RobotType type){
		Robot robot = null;
		if(type==RobotType.SIMULATED){
			robot = RobotSimulated.getInstance();
		}
		return robot;
	}
}
