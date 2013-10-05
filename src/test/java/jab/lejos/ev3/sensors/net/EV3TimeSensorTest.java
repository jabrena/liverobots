package jab.lejos.ev3.sensors.net;

import java.io.FileInputStream;
import java.util.Properties;

public class EV3TimeSensorTest {

    public static void main(String[] args) throws Exception {
    	
    	//Madrid
    	double madridLat = 40.479732600000000000;
    	double madridLon = -3.589829900000040700;

    	Properties prop = new Properties();
    	prop.load(new FileInputStream(System.getProperty("user.dir") + "/lib/geonames.properties"));

    	EV3TimeSensor tns = new EV3TimeSensor(madridLat, madridLon, prop.getProperty("username"));

    	System.out.println(tns.getTime().toDate().toString());

    }

}
