package jab.lejos.liverobots.brity.fsm;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.scxml.model.Transition;

public class BrityFSMTest {

	private BrityFSM brityFSM;
	
	public static void main(String[] args) throws MalformedURLException {
		new BrityFSMTest();
	}
	
	public BrityFSMTest() throws MalformedURLException {
		brityFSM = new BrityFSM();

		for(int i=0;i<10; i++){
			
			//List Transitions
			List<Transition> transitionList = brityFSM.getCurrentState().getTransitionsList();
			List<String> list = new ArrayList();
			for (Transition transition : transitionList) {
				list.add(transition.getEvent());
				System.out.println("EVENT: " + transition.getEvent() );
			}
			//Fire first event
			brityFSM.fireEvent(list.get(0).toString());

			System.out.println("ITERATION: " + i );
			
		}
	}

}
