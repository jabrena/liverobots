package jab.lejos.liverobots.fsm.beetle;

import jab.lejos.liverobots.fsm.FSM;
import jab.lejos.liverobots.model.RobotFactoryException;
import jab.lejos.liverobots.model.RobotType;
import jab.lejos.liverobots.model.beetle.BeetleRobot;
import jab.lejos.liverobots.model.beetle.BeetleRobotFactory;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class BeetleFSM extends FSM{

	Logger logger = Logger.getLogger(BeetleFSM.class);
	
	private static final String SCXML_CONFIG = "./lib/Beetle1.scxml";

	private BeetleRobot robot;
	
	public BeetleFSM(RobotType rt) throws MalformedURLException, RobotFactoryException{
		super(new File(SCXML_CONFIG).toURI().toURL());
		robot = BeetleRobotFactory.getRobot(rt);
	}
	
	public void autoFireEvent() {
		this.fireEvent(this.getStatus().toString());
	}
	
	public BeetleRobot getRobot(){
		return this.robot;
	}
	
	private Transitions status = null;
	
	public Transitions getStatus(){
		return status;
	}

	public void setStatus(Transitions status){
		this.status = status;
	}
	
	//FSM Logic
	private final int longDistance = 200;
	private final int middleDistance = 100;
	private final int lowDistance = 50;
	private final int criticDistance = 20;
	
	public void Calibrate(){
		Logger logger = Logger.getLogger(BeetleFSM.class);
		logger.info("STATE: Calibrate");
		this.setStatus(Transitions.goExploring);
	}
	public void Explore(){
		logger.info("STATE: Explore");
		this.setStatus(Transitions.goScan);
	}
	
	public void Scan(){
		logger.info("STATE: Scan");
		
		int leftDistance = robot.getLeftDistance();
		int frontDistance = robot.getFrontDistance();
		int rightDistance = robot.getRightDistance();
		
		logger.info("Left:  " + leftDistance);
		logger.info("Front: " + frontDistance);
		logger.info("Right: " + rightDistance);
		
		/*
		if(frontDistance >= this.longDistance){
			this.setStatus(Transitions.goAhead);
		}else if(frontDistance >= this.middleDistance){
			this.setStatus(Transitions.goAhead);
		}else if(frontDistance >= this.lowDistance){
			
		}else if(frontDistance >= this.lowDistance){
			
		}
		*/
		
	}

	public void GoAhead(){
		logger.info("STATE: GoAhead");
		
		robot.goAhead(1);
		
		this.setStatus(Transitions.goScan);
	}

	public void GoLeft(){
		logger.info("STATE: GoLeft");
		
		robot.goLeft(1);
		
		this.setStatus(Transitions.goScan);
	}

	public void GoRight(){
		logger.info("STATE: GoRight");
		
		robot.goRight(1);
		
		this.setStatus(Transitions.goScan);
	}

	public void GoBack(){
		logger.info("STATE: GoBack");
		
		robot.goBack(1);
		
		this.setStatus(Transitions.goScan);
	}

	public void Sleep(){
		
	}
}
