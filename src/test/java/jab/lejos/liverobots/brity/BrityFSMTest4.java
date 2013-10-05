package jab.lejos.liverobots.brity;

import jab.lejos.liverobots.brity.fsm.BrityFSM4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrityFSMTest4 {

	private BrityFSM4 brityFSM;

	final Logger logger = Logger.getLogger(BrityFSMTest1.class);
	
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

	}

}
