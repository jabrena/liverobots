package jab.lejos.liverobots.fsm.bumpercar;

import org.apache.log4j.Logger;

public abstract class GenericState {

	Logger logger = Logger.getLogger(GenericState.class);
	
	int voltage = 0;
	int voltageThreshold = 200;
	
	protected BumperCar fsm;
	
	public GenericState(BumperCar fsm){
		this.fsm = fsm;
	}
	
	public abstract void action();
}
