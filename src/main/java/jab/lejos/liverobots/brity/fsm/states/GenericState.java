package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.fsm.BrityFSM4;
import jab.lejos.liverobots.brity.model.Robot;

import org.apache.log4j.Logger;

public class GenericState {

	Logger logger = Logger.getLogger(GenericState.class);
	
	int voltage = 0;
	int voltageThreshold = 200;
	
	public GenericState(BrityFSM4 brityFSM, Robot robot){
		
		voltage = robot.getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			brityFSM.fireEvent("lowBattery");
		}
	}
}
