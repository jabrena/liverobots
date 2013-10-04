package jab.lejos.liverobots.brity.fsm;

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

	private BrityFSM brityFSM;

	final Logger logger = Logger.getLogger(BrityFSMTest.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;		  
		System.out.println(path);
		
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
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
				logger.info("EVENT: " + transition.getEvent() );
			}
			//Fire first event
			brityFSM.fireEvent(list.get(0).toString());

			logger.info("ITERATION: " + i );
		}
	}

}
