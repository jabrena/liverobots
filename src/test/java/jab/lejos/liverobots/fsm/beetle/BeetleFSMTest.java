package jab.lejos.liverobots.fsm.beetle;

import jab.lejos.liverobots.model.RobotFactoryException;
import jab.lejos.liverobots.model.RobotType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BeetleFSMTest {

	final Logger logger = Logger.getLogger(BeetleFSMTest.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException, RobotFactoryException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new BeetleFSMTest();
	}

	public BeetleFSMTest() throws MalformedURLException, RobotFactoryException {
		
		BeetleFSM fsm = new BeetleFSM(RobotType.EV3);
		fsm.fireEvent(Transitions.goExploring.toString());
		
		for(int i=0;i<=100;i++){

			fsm.autoFireEvent();
		
		}

	}

}
