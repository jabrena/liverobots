package jab.lejos.liverobots.fsm.bumpercar;

import org.apache.log4j.Logger;

public class DriveForward {

	Logger logger = Logger.getLogger(DriveForward.class);

	int distance = 0;
	int distanceThreshold = 100;

	int voltage = 0;
	int voltageThreshold = 200;
	
	private BumperCar fsm;
	
	public DriveForward(BumperCar fsm){
		this.fsm = fsm;
	}

	public void action() {

		voltage = fsm.getRobot().getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			fsm.setStatus(3);
		}else{
			logger.info("Go forward");
			fsm.getRobot().forward(1);
			distance = fsm.getRobot().getDistance();
			logger.info("Distance: " + distance);

			if(distance < 100){
				fsm.setStatus(2);
			}else{
				fsm.setStatus(1);
			}
		}
	}
}
