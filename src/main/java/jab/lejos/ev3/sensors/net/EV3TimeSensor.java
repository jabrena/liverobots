package jab.lejos.ev3.sensors.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.xml.sax.SAXException;

/**
 * http://api.geonames.org/timezone?lat=40.479732600000000000&lng=-3.589829900000040700&username=username
 * 
 * @author jabrena
 *
 */
public class EV3TimeSensor {

	private double lat;
	private double lon;
	private String username;
	
	public EV3TimeSensor(final double lat, final double lon, final String username){
		this.lat = lat;
		this.lon = lon;
		this.username = username;
	}
	
	private String getWSURL(){
		
		StringBuffer url = new StringBuffer();
		url.append("http://api.geonames.org/timezone");
		url.append("?");
		url.append("lat=");
		url.append(this.lat);
		url.append("&");
		url.append("lng=");
		url.append(this.lon);
		url.append("&");
		url.append("username=");
		url.append(this.username);
		
		return url.toString();
		
	}
	
	public DateTime getTime() throws IOException, ParserConfigurationException, SAXException, XMLStreamException{
		DateTime dateTime = new DateTime();

        URL url = new URL(this.getWSURL());
        URLConnection conn = url.openConnection();

		InputStream in =  conn.getInputStream();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader parser = factory.createXMLStreamReader(in);

		while (true) {
		    int event = parser.next();
		    if (event == XMLStreamConstants.END_DOCUMENT) {;
		       parser.close();
		       break;
		    } else if (event == XMLStreamConstants.START_ELEMENT) {
		    	
		    	if(parser.getLocalName() == "time"){
		    		
		        	DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		        	dateTime = format.parseDateTime(parser.getElementText());

		    		parser.close();
		    		break;
		    	}
		    }
		}
		
        return dateTime;
	}

}
