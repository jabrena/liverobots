package jab.lejos.liverobots.fsm;

import java.net.MalformedURLException;
import java.net.URL;
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
public class FSM extends AbstractStateMachine{

	Logger logger = Logger.getLogger(FSM.class);
	
	/**
	 * Constructor
	 * 
	 * @param scxml
	 * @throws MalformedURLException
	 */
	public FSM(URL scxml) throws MalformedURLException{
		super(scxml);
	}
	
	/**
	 * Method used to receive current state as a String
	 * 
	 * @return
	 */
	public String getCurrentStateId() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		State state = (State) states.iterator().next();
		return state.getId();
	}
	
	/**
	 * Method used to receive current state as a State
	 * 
	 * @return
	 */
	public State getCurrentState() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		return ( (State) states.iterator().next());
	}
	
	/**
	 * Method used to receive a Collection of events related with current State
	 * 
	 * @return
	 */
	public Collection<?> getCurrentStateEvents() {
		return getEngine().getCurrentStatus().getEvents();
	}
	
}
