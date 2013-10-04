package jab.lejos.liverobots.brity.fsm;

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
	}

}
