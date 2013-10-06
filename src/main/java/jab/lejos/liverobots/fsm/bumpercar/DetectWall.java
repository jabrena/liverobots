package jab.lejos.liverobots.fsm.bumpercar;

import org.apache.log4j.Logger;

public class DetectWall extends GenericState{

	Logger logger = Logger.getLogger(DriveForward.class);
	
	public DetectWall(BumperCar fsm){
		super(fsm);
	}

	public void action() {

		voltage = fsm.getRobot().getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			fsm.setStatus(3);
		}else{
			logger.info("Go backward");
			fsm.getRobot().backward(1);
			logger.info("Turn left");
			fsm.getRobot().turnLeft(1);
			
			fsm.setStatus(1);			
		}
	}
}
