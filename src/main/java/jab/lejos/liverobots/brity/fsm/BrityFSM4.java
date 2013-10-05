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
	
	public RobotSimulated getRobot(){
		return this.robot;
	}
	
	//FSM Methods
	public void Iddle() {
		Logger logger = Logger.getLogger(BrityFSM4.class);
		logger.info("STATE: Iddle");
	}
	
	int voltage = 0;
	int voltageThreshold = 200;
	int distance = 0;
	int distanceThreshold = 100;
	
	public void DriveForward() {
		logger.info("STATE: DriveForward");
		
		voltage = robot.getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			robot.setStatus(3);
		}else{
			distance = robot.getDistance();
			logger.info("Distance: " + distance);

			if(distance < 100){
				robot.setStatus(2);
			}else{
				robot.setStatus(1);
			}
		}
		

		
	}
	
	public void DetectWall() {
		logger.info("STATE: DetectWall");
		
		voltage = robot.getVoltage();
		logger.info("Voltage: " + voltage);
		if(voltage < voltageThreshold){
			robot.setStatus(3);
		}else{
			logger.info("Go backward");
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			logger.info("Turn left");
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			
			robot.setStatus(1);			
		}
		

	}
	
	public void Disconnect() {
		//TODO Improve log4j usage
		logger.info("STATE: Disconnected");
	}
	
}
