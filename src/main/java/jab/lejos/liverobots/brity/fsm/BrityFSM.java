package jab.lejos.liverobots.brity.fsm;

import jab.lejos.liverobots.brity.model.RobotSimulated;
import jab.lejos.liverobots.brity.fsm.states.DriveForward;
import jab.lejos.liverobots.brity.fsm.states.DetectWall;

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
public class BrityFSM extends AbstractStateMachine{

	Logger logger = Logger.getLogger(BrityFSM.class);
	
	private static final String SCXML_CONFIG = "./lib/BrityModel.scxml";
	
	private RobotSimulated robot;
	
	public enum States {
		Iddle, DriveForward, DetectWall, Disconnect
	}
	
	public enum Transitions {
		continueDriving, detectingWall, lowBattery
	}
	
	public BrityFSM() throws MalformedURLException{
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
	
	public RobotSimulated getRobot(){
		return this.robot;
	}
	
	int status = 0;
	
	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status = status;
	}
	
	//FSM Methods
	public void Iddle() {
		Logger logger = Logger.getLogger(BrityFSM.class);
		logger.info("STATE: Iddle");
	}
	
	int voltage = 0;
	int voltageThreshold = 200;
	int distance = 0;
	int distanceThreshold = 100;
	
	public void DriveForward() {
		logger.info("STATE: DriveForward");

		DriveForward df = new DriveForward(this);
		df.action();
	
	}
	
	public void DetectWall() {
		logger.info("STATE: DetectWall");

		DetectWall dw = new DetectWall(this);
		dw.action();
	}
	
	public void Disconnect() {
		//TODO Improve log4j usage
		logger.info("STATE: Disconnected");
	}
	
}
