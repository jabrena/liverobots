package jab.lejos.liverobots.brity.fsm.states;

import jab.lejos.liverobots.brity.fsm.BrityFSM;

import org.apache.log4j.Logger;

public abstract class GenericState {

	Logger logger = Logger.getLogger(GenericState.class);
	
	int voltage = 0;
	int voltageThreshold = 200;
	
	protected BrityFSM brityFSM;
	
	public GenericState(BrityFSM brityFSM){
		this.brityFSM = brityFSM;
	}
	
	public abstract void action();
}
