package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.fsm.BrityFSM;

import org.apache.log4j.Logger;

public class DetectWall extends GenericState{

	Logger logger = Logger.getLogger(DriveForward.class);
	
	public DetectWall(BrityFSM brityFSM){
		super(brityFSM);
		
		logger.info("STATE: DetectWall");
		
	}

	public void action() {
		voltage = brityFSM.getRobot().getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			brityFSM.setStatus(3);
		}else{
			logger.info("Go backward");
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			logger.info("Turn left");
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			
			brityFSM.setStatus(1);			
		}
	}
}
