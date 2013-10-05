package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.fsm.BrityFSM;

import org.apache.log4j.Logger;

public class DriveForward extends GenericState{

	Logger logger = Logger.getLogger(DriveForward.class);

	int distance = 0;
	int distanceThreshold = 100;

	public DriveForward(BrityFSM brityFSM){
		super(brityFSM);
		
		logger.info("STATE: DriveForward");



	}

	public void action() {
		voltage = brityFSM.getRobot().getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			brityFSM.setStatus(3);
		}else{
			distance = brityFSM.getRobot().getDistance();
			logger.info("Distance: " + distance);

			if(distance < 100){
				brityFSM.setStatus(2);
			}else{
				brityFSM.setStatus(1);
			}
		}
	}
}
