package jab.lejos.ev3.sensors.net;

import java.io.FileInputStream;
import java.util.Properties;

import javax.microedition.location.Coordinates;

public class EV3TimeSensorTest {

    public static void main(String[] args) throws Exception {
    	
    	//Madrid
    	Coordinates coordinate = new Coordinates(40.479732600000000000,-3.589829900000040700);

    	Properties prop = new Properties();
    	prop.load(new FileInputStream(System.getProperty("user.dir") + "/lib/geonames.properties"));

    	EV3TimeSensor tns = new EV3TimeSensor(coordinate, prop.getProperty("username"));

    	System.out.println(tns.getTime().toDate().toString());

    }

}
