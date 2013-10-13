package jab.lejos.liverobots.hfsm;

import jab.lejos.liverobots.fsm.FSM;
import jab.lejos.liverobots.hfsm.Transitions;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

/**
 * 
 * @author jabrena
 *
 */
public class HFSM extends FSM{

	Logger logger = Logger.getLogger(HFSM.class);
	
	private static final String SCXML_CONFIG = "./lib/hfsm.scxml";

	public HFSM() throws MalformedURLException{
		super(new File(SCXML_CONFIG).toURI().toURL());
	}
	

	
	private Transitions status = null;
	
	public Transitions getStatus(){
		return status;
	}

	public void setStatus(Transitions status){
		this.status = status;
	}

	public void autoFireEvent() {
		this.fireEvent(this.getStatus().toString());
	}
	
	//HFSM Methods
	public void fsm1() {
		Logger logger = Logger.getLogger(HFSM.class);
		logger.info("STATE: fsm1");
	}

	public void fsm2() {
		logger.info("STATE: fsm2");
	}
	
	public void fsm3() {
		logger.info("STATE: fsm3");
	}
	
	public void State1() {
		Logger logger = Logger.getLogger(HFSM.class);
		logger.info("STATE: State1");
		this.setStatus(Transitions.goState2);
	}

	public void State2() {
		logger.info("STATE: State2");
		this.setStatus(Transitions.goFSM2);
	}
	
	public void State3() {
		logger.info("STATE: State3");
		this.setStatus(Transitions.goState4);
	}
	
	public void State4() {
		logger.info("STATE: State4");
		this.setStatus(Transitions.goFSM3);
	}

	public void State5() {
		logger.info("STATE: State5");
		this.setStatus(Transitions.goState6);
	}
	
	public void State6() {
		logger.info("STATE: State6");
		this.setStatus(Transitions.goFSM1);
	}

	
}
