package jab.lejos.liverobots.model.beetle;

import jab.lejos.liverobots.model.IRobotFactory;
import jab.lejos.liverobots.model.RobotFactoryException;
import jab.lejos.liverobots.model.RobotType;

import org.apache.log4j.Logger;

public class BeetleRobotFactory {

	final static Logger logger = Logger.getLogger(BeetleRobotFactory.class);
	
	public static BeetleRobot getRobot(RobotType type) throws RobotFactoryException{
		BeetleRobot robot = null;
		if(type==RobotType.EV3){
			logger.info("Returning a EV3 robot");
			robot = BeetleRobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}

	public static BeetleRobot getRobot(String type) throws RobotFactoryException {
		BeetleRobot robot = null;
		if(type.equals(RobotType.EV3.toString())){
			logger.info("Returning a EV3 robot");
			robot = BeetleRobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}
}
