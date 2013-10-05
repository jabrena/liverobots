package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.fsm.BrityFSM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest {

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
		brityFSM = new BrityFSM();
		brityFSM.fireEvent(BrityFSM.Transitions.continueDriving.toString());
		
		for(int i=0;i<=10;i++){

			if(brityFSM.getStatus() == 1){
				brityFSM.fireEvent(BrityFSM.Transitions.continueDriving.toString());
			}else if(brityFSM.getStatus() == 2){
				brityFSM.fireEvent(BrityFSM.Transitions.detectingWall.toString());
			}else if(brityFSM.getStatus() == 3){
				brityFSM.fireEvent(BrityFSM.Transitions.lowBattery.toString());
			}			
		}


	}

}
