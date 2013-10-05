package jab.lejos.liverobots.brity.fsm;

import jab.lejos.liverobots.brity.model.RobotSimulated;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.scxml.SCXMLExecutor;
import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;
import org.apache.log4j.Logger;

/**
 * 
 * Based on this example:
 * http://commons.apache.org/proper/commons-scxml/xref-test/org/apache/commons/scxml/env/StopWatch.html
 *  
 * @author jabrena
 *
 */
public class BrityFSM4 extends AbstractStateMachine{

	Logger logger = Logger.getLogger(BrityFSM4.class);
	
	private static final String SCXML_CONFIG = "./lib/BrityModel.scxml";
	
	private RobotSimulated robot;
	
	public BrityFSM4() throws MalformedURLException{
		super(new File(SCXML_CONFIG).toURI().toURL());
		robot = RobotSimulated.getInstance();
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
	 
	public void setCurrentState(SCXMLExecutor exec, final String id) throws IllegalArgumentException{
	    try {
	        exec.reset();
	    } catch (ModelException me) {
	        throw new IllegalArgumentException("Provided SCXMLExecutor "
	                + "instance cannot be reset.");
	    }
	    TransitionTarget active = (TransitionTarget) exec.getStateMachine().
	            getTargets().get(id);
	    if (active == null) {
	        throw new IllegalArgumentException("No target with id '" + id
	                + "' present in state machine.");
	    }
	    Set current = exec.getCurrentStatus().getStates();
	    current.clear();
	    current.add(active);
	}
	
	//FSM Methods
	public void Iddle() {
		Logger logger = Logger.getLogger(BrityFSM4.class);
		logger.info("STATE: Iddle");
		//this.setCurrentState(getEngine(), BrityFSMTransitions.continueDriving.toString());
	    TransitionTarget active = (TransitionTarget) this.getEngine().getStateMachine().
	            getTargets().get(BrityFSMTransitions.continueDriving.toString());
	    if (active == null) {
	        throw new IllegalArgumentException("No target with id '" + BrityFSMTransitions.continueDriving.toString()
	                + "' present in state machine.");
	    }
	    Set current = this.getEngine().getCurrentStatus().getStates();
	    current.clear();
	    current.add(active);
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
