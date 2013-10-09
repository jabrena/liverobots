package jab.lejos.liverobots.fsm.bumpercar.states;

import jab.lejos.liverobots.fsm.bumpercar.BumperCar;
import jab.lejos.liverobots.fsm.bumpercar.Transitions;

import org.apache.log4j.Logger;

public class DetectWall {

	Logger logger = Logger.getLogger(DetectWall.class);
	
	int voltage = 0;
	int voltageThreshold = 200;
	
	private BumperCar fsm;
	
	public DetectWall(BumperCar fsm){
		this.fsm = fsm;
	}

	public void action() {

		voltage = fsm.getRobot().getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			fsm.setStatus(Transitions.lowBattery);
		}else{
			logger.info("Go backward");
			fsm.getRobot().backward(1);
			logger.info("Turn left");
			fsm.getRobot().turnLeft(1);
			
			fsm.setStatus(Transitions.continueDriving);			
		}
	}
}
