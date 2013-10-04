package jab.lejos.liverobots.brity.fsm;

import java.net.URL;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.model.State;

public class FSM extends AbstractStateMachine{

<<<<<<< HEAD
	
	public FSM(final URL SCXML){
		super(SCXML);
	}
	
=======
	public FSM(final URL SCXML){
		super(SCXML);
	}
>>>>>>> refs/remotes/origin/master
	
	public void callState(String name){
		this.invoke(name);
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
	
}
