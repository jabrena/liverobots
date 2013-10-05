package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.fsm.BrityFSM4;
import jab.lejos.liverobots.brity.model.Robot;

import org.apache.log4j.Logger;

public class DriveForward extends GenericState{

	Logger logger = Logger.getLogger(DriveForward.class);

	int voltage = 0;
	int voltageThreshold = 200;
	int distance = 0;
	int distanceThreshold = 100;

	public DriveForward(BrityFSM4 brityFSM, Robot robot){
		super(brityFSM, robot);
		
		logger.info("STATE: DriveForward");

		voltage = robot.getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			logger.info("STATE: Disconnect");
			brityFSM.fireEvent("lowBattery");
		}		
		
		distance = robot.getDistance();
		logger.info("Distance: " + distance);

		if(distance < 100){
			brityFSM.fireEvent("detectingWall");
		}else{
			brityFSM.fireEvent("continueDriving");
		}

	}
}
