package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.fsm.BrityFSM3;
import jab.lejos.liverobots.brity.fsm.BrityFSMStates;
import jab.lejos.liverobots.brity.fsm.BrityFSMTransitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.scxml.model.Transition;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest3 {

	private BrityFSM3 brityFSM;

	final Logger logger = Logger.getLogger(BrityFSMTest1.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new BrityFSMTest3();
	}
	
	java.util.Date date;
	
	public BrityFSMTest3() throws MalformedURLException {
		brityFSM = new BrityFSM3();
		//Using a bad transition
		brityFSM.fireEvent(BrityFSMTransitions.lowBattery.toString());
		brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
		brityFSM.fireEvent(BrityFSMTransitions.detectingWall.toString());
		//Using a bad transition
		brityFSM.fireEvent(BrityFSMTransitions.lowBattery.toString());
		brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
		brityFSM.fireEvent(BrityFSMTransitions.lowBattery.toString());
		/*
		date= new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0;i<10; i++){
			
			if(!brityFSM.getCurrentState().isFinal()){
				

				List<Transition> transitionList = brityFSM.getCurrentState().getTransitionsList();
				if(transitionList.size() > 0){
					list.clear();
					for (Transition transition : transitionList) {
						list.add(transition.getEvent());
						logger.info("EVENT: " + transition.getEvent());
					}
				}


				//Iddle
				if(brityFSM.getCurrentStateId().equals(BrityFSMStates.Iddle.toString())){
					//logger.info("STATE: " + brityFSM.getCurrentStateId());
					//brityFSM.fireEvent(list.get(0).toString());
					brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
				}
				
				//DriveForward
				if(brityFSM.getCurrentStateId().equals(BrityFSMStates.DriveForward.toString())){
					//logger.info("STATE: " + brityFSM.getCurrentStateId());
					//brityFSM.fireEvent(list.get(0).toString());
					brityFSM.fireEvent(BrityFSMTransitions.detectingWall.toString());
				}

				//DetectWall
				if(brityFSM.getCurrentStateId().equals(BrityFSMStates.DetectWall.toString())){
					//logger.info("STATE: " + brityFSM.getCurrentStateId());
					//brityFSM.fireEvent(list.get(0).toString());
					brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
					date= new java.util.Date();
					System.out.println(new Timestamp(date.getTime()));
				}

			}else{
				break;
			}
			logger.info("ITERATION: " + i );

		}

*/
	}

}
