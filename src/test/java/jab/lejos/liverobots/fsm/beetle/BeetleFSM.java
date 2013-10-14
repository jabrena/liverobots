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
	
	int transitionParameter = 0;
	
	public int getTransitionParameter(){
		return transitionParameter;
	}
	
	public void setTransitionParameter(int parameter){
		this.transitionParameter = parameter;
	}
	
	//FSM Logic
	public void Calibrate(){
		Logger logger = Logger.getLogger(BeetleFSM.class);
		logger.info("STATE: Calibrate");
		this.setStatus(Transitions.goExploring);
	}
	public void Explore(){
		logger.info("STATE: Explore");
		this.setStatus(Transitions.goScan);
	}
	
	private final int THRESHOLD_LONG_DISTANCE = 80;
	private final int THRESHOLD_MIDDLE_DISTANCE = 60;
	private final int THRESHOLD_LOW_DISTANCE = 40;
	private final int THRESHOLD_CRITIC_DISTANCE = 20;

	private int leftDistance;
	private int frontDistance;
	private int rightDistance;
	
	public void Scan(){
		logger.info("STATE: Scan");
		
		leftDistance = robot.getLeftDistance();
		frontDistance = robot.getFrontDistance();
		rightDistance = robot.getRightDistance();
		
		logger.info("Left:  " + leftDistance);
		logger.info("Front: " + frontDistance);
		logger.info("Right: " + rightDistance);

		if(frontDistance >= this.THRESHOLD_LONG_DISTANCE){
			this.setTransitionParameter(3);
			this.setStatus(Transitions.goAhead);
		}else if(frontDistance >= this.THRESHOLD_MIDDLE_DISTANCE){
			this.setTransitionParameter(2);
			this.setStatus(Transitions.goAhead);
		}else if(frontDistance >= this.THRESHOLD_LOW_DISTANCE){
			if(leftDistance > rightDistance){
				this.setStatus(Transitions.goLeft);
			}else{
				this.setStatus(Transitions.goRight);
			}
		}else if(frontDistance >= this.THRESHOLD_CRITIC_DISTANCE){
			this.setStatus(Transitions.goBack);
		}
		
	}

	public void GoAhead(){
		logger.info("STATE: GoAhead");
		
		leftDistance = robot.getLeftDistance();
		frontDistance = robot.getFrontDistance();
		rightDistance = robot.getRightDistance();
		
		logger.info("Left:  " + leftDistance);
		logger.info("Front: " + frontDistance);
		logger.info("Right: " + rightDistance);

		if(leftDistance <= this.THRESHOLD_CRITIC_DISTANCE){
			robot.goRight(20);
			robot.goAhead(1);
		}else if(rightDistance <= this.THRESHOLD_CRITIC_DISTANCE){
			robot.goLeft(20);
			robot.goAhead(1);
		}else{
			robot.goAhead(1);
		}
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
