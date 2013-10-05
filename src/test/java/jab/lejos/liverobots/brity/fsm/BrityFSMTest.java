package jab.lejos.liverobots.brity.fsm;

import jab.lejos.liverobots.brity.model.Robot;
import jab.lejos.liverobots.brity.model.RobotFactory;
import jab.lejos.liverobots.brity.model.RobotType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.scxml.model.Transition;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest {

	//Robot
	Robot robot;
	
	private BrityFSM brityFSM;

	final Logger logger = Logger.getLogger(BrityFSMTest.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new BrityFSMTest();
	}
	
	public BrityFSMTest() throws MalformedURLException {
		robot = RobotFactory.getRobot(RobotType.SIMULATED);
		brityFSM = new BrityFSM(robot);

		//brityFSM.fireEvent(brityFSM.getCurrentState().getTransitionsList().get(0).toString());
		

		if(!brityFSM.getCurrentState().isFinal()){
			//List Transitions
			List<Transition> transitionList = brityFSM.getCurrentState().getTransitionsList();
			if(transitionList.size() > 0){
				List<String> list = new ArrayList<String>();
				for (Transition transition : transitionList) {
					list.add(transition.getEvent());
					logger.info("EVENT: " + transition.getEvent() );
				}
				//Fire first event
				brityFSM.fireEvent(list.get(0).toString());
			}
		}

		
		/*
		for(int i=0;i<10; i++){
			
			if(!brityFSM.getCurrentState().isFinal()){
				//List Transitions
				List<Transition> transitionList = brityFSM.getCurrentState().getTransitionsList();
				if(transitionList.size() > 0){
					List<String> list = new ArrayList<String>();
					for (Transition transition : transitionList) {
						list.add(transition.getEvent());
						logger.info("EVENT: " + transition.getEvent() );
					}
					//Fire first event
					brityFSM.fireEvent(list.get(0).toString());
				}
			}else{
				break;
			}
			logger.info("ITERATION: " + i );

		}
		*/

	}

}
