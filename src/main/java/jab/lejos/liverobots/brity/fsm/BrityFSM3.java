package jab.lejos.liverobots.brity.fsm;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.model.State;
import org.apache.log4j.Logger;

/**
 * 
 * Based on this example:
 * http://commons.apache.org/proper/commons-scxml/xref-test/org/apache/commons/scxml/env/StopWatch.html
 *  
 * @author jabrena
 *
 */
public class BrityFSM3 extends AbstractStateMachine{

	Logger logger = Logger.getLogger(BrityFSM3.class);
	
	private static final String SCXML_CONFIG = "./lib/BrityModel.scxml";
	
	public BrityFSM3() throws MalformedURLException{
		super(new File(SCXML_CONFIG).toURI().toURL());
	}
	
	//User methods
	public String getCurrentStateId() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		State state = (State) states.iterator().next();
		return state.getId();
	}
	
	public State getCurrentState() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		return ( (State) states.iterator().next());
	}
	
	public Collection<?> getCurrentStateEvents() {
		return getEngine().getCurrentStatus().getEvents();
	}
	 
	//FSM Methods
	public void Iddle() {
		Logger logger = Logger.getLogger(BrityFSM3.class);
		logger.info("STATE: Iddle");
	}
	
	public void DriveForward() {
		logger.info("STATE: DriveForward");
	}
	
	public void DetectWall() {
		logger.info("STATE: DetectWall");
	}
	
	public void Disconnect() {
		//TODO Improve log4j usage
		logger.info("STATE: disconnected");
	}
	
}
