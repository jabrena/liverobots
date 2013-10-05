package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.fsm.BrityFSM4;
import jab.lejos.liverobots.brity.fsm.BrityFSMTransitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest4 {

	private BrityFSM4 brityFSM;

	final Logger logger = Logger.getLogger(BrityFSMTest4.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new BrityFSMTest4();
	}

	public BrityFSMTest4() throws MalformedURLException {
		brityFSM = new BrityFSM4();
		brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
		
		for(int i=0;i<=10;i++){

			if(brityFSM.getRobot().getStatus() == 1){
				brityFSM.fireEvent(BrityFSMTransitions.continueDriving.toString());
			}else if(brityFSM.getRobot().getStatus() == 2){
				brityFSM.fireEvent(BrityFSMTransitions.detectingWall.toString());
			}else if(brityFSM.getRobot().getStatus() == 3){
				brityFSM.fireEvent(BrityFSMTransitions.lowBattery.toString());
			}			
		}


	}

}
