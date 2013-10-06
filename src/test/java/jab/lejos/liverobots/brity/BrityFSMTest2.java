package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.fsm.BrityFSM2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest2 {

	final Logger logger = Logger.getLogger(BrityFSMTest.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new BrityFSMTest2();
	}

	public BrityFSMTest2() throws MalformedURLException {
		
		BrityFSM2 fsm = new BrityFSM2();
		fsm.fireEvent(BrityFSM2.Transitions.continueDriving.toString());
		
		for(int i=0;i<=10;i++){

			if(fsm.getStatus() == 1){
				fsm.fireEvent(BrityFSM2.Transitions.continueDriving.toString());
			}else if(fsm.getStatus() == 2){
				fsm.fireEvent(BrityFSM2.Transitions.detectingWall.toString());
			}else if(fsm.getStatus() == 3){
				fsm.fireEvent(BrityFSM2.Transitions.lowBattery.toString());
			}			
		}


	}

}
