package jab.lejos.liverobots.brity.fsm;

<<<<<<< HEAD
import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

public class BrityFSM extends FSM{

	private static final String SCXML_CONFIG = "./lib/BrityModel.xml";
	
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
=======
public class BrityFSM extends FSM{

	private static final String SCXML_CONFIG = "./BrityModel.xml";
	
	public BrityFSM() {
    	super(BrityFSM.class.getClassLoader().getResource(SCXML_CONFIG));
	}
	
	//FSM Methods
	public void state1() {
		System.out.println("STATE: state1");
	}

	public void state2() {
		System.out.println("STATE: state2");
>>>>>>> refs/remotes/origin/master
	}

}
