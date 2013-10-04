package jab.lejos.liverobots.brity.fsm;

import java.io.File;
import java.net.MalformedURLException;

public class BrityFSM extends FSM{

	private static final String SCXML_CONFIG = "./lib/BrityModel.xml";
	
	public BrityFSM() throws MalformedURLException {
		super(new File(SCXML_CONFIG).toURI().toURL());
	}
	
	//FSM Methods
	public void state1() {
		System.out.println("STATE: state1");
	}

	public void state2() {
		System.out.println("STATE: state2");
	}

}
