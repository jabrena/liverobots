package jab.lejos.liverobots.fsm.bumpercar.states;

import jab.lejos.liverobots.fsm.bumpercar.BumperCarFSM;
import jab.lejos.liverobots.fsm.bumpercar.Transitions;

import org.apache.log4j.Logger;

public class DriveForward {

	Logger logger = Logger.getLogger(DriveForward.class);

	int distance = 0;
	int distanceThreshold = 100;

	int voltage = 0;
	int voltageThreshold = 200;
	
	private BumperCarFSM fsm;
	
	public DriveForward(BumperCarFSM fsm){
		this.fsm = fsm;
	}

	public void action() {

		voltage = fsm.getRobot().getBatteryVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			fsm.setStatus(Transitions.lowBattery);
		}else{
			logger.info("Go forward");
			fsm.getRobot().forward(1);
			distance = fsm.getRobot().getDistance();
			logger.info("Distance: " + distance);

			if(distance < 100){
				fsm.setStatus(Transitions.detectingWall);
			}else{
				fsm.setStatus(Transitions.continueDriving);
			}
		}
	}
}
