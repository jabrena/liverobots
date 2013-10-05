package jab.lejos.liverobots.brity.fsm;

import jab.lejos.liverobots.brity.fsm.states.DriveForward;
import jab.lejos.liverobots.brity.fsm.states.DetectWall;
import jab.lejos.liverobots.brity.model.Robot;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class BrityFSM extends FSM{

	private Robot robot;
	private static final String SCXML_CONFIG = "./lib/BrityModel.scxml";
	
	public BrityFSM(Robot robot) throws MalformedURLException {
		//TODO Improve parsing using this URL:
		//http://commons.apache.org/proper/commons-scxml/guide/core-parser.html
		super(new File(SCXML_CONFIG).toURI().toURL());
		this.robot = robot;
	}
	
	//FSM Methods
	public void Iddle() {
		Logger logger = Logger.getLogger(DriveForward.class);
		logger.info("STATE: Idle");
	}
	
	public void DriveForward() {
		DriveForward df = new DriveForward(this,robot);
	}

	public void DetectWall() {
		DetectWall dw = new DetectWall(this,robot);
	}
	
	public void Disconnect() {
		//TODO Improve log4j usage
		Logger logger = Logger.getLogger(BrityFSM.class);
		logger.info("STATE: disconnected");
	}
}
