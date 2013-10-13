package jab.lejos.liverobots.fsm.model.bumpercar;

import jab.lejos.liverobots.fsm.model.RobotFactoryException;
import jab.lejos.liverobots.fsm.model.RobotType;

import org.apache.log4j.Logger;

public class BumperCarRobotFactory {

	final static Logger logger = Logger.getLogger(BumperCarRobotFactory.class);
	
	public static BumpercarRobot getRobot(RobotType type) throws RobotFactoryException{
		BumpercarRobot robot = null;
		if(type==RobotType.SIMULATED){
			logger.info("Returning a Simulated robot");
			robot = BumperCarRobotSimulated.getInstance();
		}else if(type==RobotType.EV3){
			logger.info("Returning a EV3 robot");
			robot = BumperCarRobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}

	public static BumpercarRobot getRobot(String type) throws RobotFactoryException {
		BumpercarRobot robot = null;
		if(type.equals(RobotType.SIMULATED.toString())){
			logger.info("Returning a Simulated robot");
			robot = BumperCarRobotSimulated.getInstance();
		}else if(type.equals(RobotType.EV3.toString())){
			logger.info("Returning a EV3 robot");
			robot = BumperCarRobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}
}
