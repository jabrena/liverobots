package jab.lejos.liverobots.brity.model;

public class RobotFactory {

	public static Robot getRobot(RobotType type){
		Robot robot = null;
		if(type==RobotType.SIMULATED){
			robot = RobotSimulated.getInstance();
		}else if(type==RobotType.EV3){
			robot = RobotEV3.getInstance();			
		}
		return robot;
	}
}
