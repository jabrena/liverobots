package jab.lejos.liverobots.hfsm;

import jab.lejos.liverobots.hfsm.HFSM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HFSMTest {

	final Logger logger = Logger.getLogger(HFSMTest.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String configPath = "/lib/log4j.properties";
		String path = System.getProperty("user.dir") + configPath;
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		PropertyConfigurator.configure(props);
		  
		new HFSMTest();
	}

	public HFSMTest() throws MalformedURLException {
		
		HFSM hfsm = new HFSM();
		hfsm.fireEvent(Transitions.goState2.toString());

		/*
		hfsm.fireEvent(Transitions.goFSM2.toString());
		hfsm.fireEvent(Transitions.goState4.toString());
		hfsm.fireEvent(Transitions.goFSM3.toString());
		hfsm.fireEvent(Transitions.goState6.toString());
		hfsm.fireEvent(Transitions.goFSM1.toString());
		*/

		for(int i=0;i<=10;i++){

			hfsm.autoFireEvent();
		
		}

	}

}
