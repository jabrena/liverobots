package jab.lejos.liverobots.brity.model;

import org.apache.log4j.Logger;

public class RobotFactory {

	final static Logger logger = Logger.getLogger(RobotFactory.class);
	
	public static Robot getRobot(RobotType type) throws RobotFactoryException{
		Robot robot = null;
		if(type==RobotType.SIMULATED){
			logger.info("Returning a Simulated robot");
			robot = RobotSimulated.getInstance();
		}else if(type==RobotType.EV3){
			logger.info("Returning a EV3 robot");
			robot = RobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}

	public static Robot getRobot(String type) throws RobotFactoryException {
		Robot robot = null;
		if(type.equals(RobotType.SIMULATED.toString())){
			logger.info("Returning a Simulated robot");
			robot = RobotSimulated.getInstance();
		}else if(type.equals(RobotType.EV3.toString())){
			logger.info("Returning a EV3 robot");
			robot = RobotEV3.getInstance();			
		}else{
			throw new RobotFactoryException("This type is not supported");
		}
		return robot;
	}
}
