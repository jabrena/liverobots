package jab.lejos.liverobots.brity.fsm;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class BrityFSM extends FSM{

	private static final String SCXML_CONFIG = "./lib/BrityModel.scxml";
	
	public BrityFSM() throws MalformedURLException {
		super(new File(SCXML_CONFIG).toURI().toURL());
	}
	
	//FSM Methods
	public void state1() {
		//TODO Improve log4j usage
		Logger logger = Logger.getLogger(BrityFSM.class);
		logger.info("STATE: state1");
	}

	public void state2() {
		//TODO Improve log4j usage
		Logger logger = Logger.getLogger(BrityFSM.class);
		logger.info("STATE: state2");
	}
}
