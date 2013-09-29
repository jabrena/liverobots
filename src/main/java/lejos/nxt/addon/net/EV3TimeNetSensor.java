package lejos.nxt.addon.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.URIParameter;

import javax.microedition.location.Coordinates;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.xml.sax.SAXException;

import com.sun.xml.internal.txw2.Document;

/**
 * http://api.geonames.org/timezoneJSON?lat=40.479732600000000000&lng=-3.589829900000040700&username=jabrena
 * http://api.geonames.org/timezone?lat=40.479732600000000000&lng=-3.589829900000040700&username=jabrena
 * 
 * @author jabrena
 *
 */
public class EV3TimeNetSensor {

	private String username;
	private Coordinates coordinate;
	
	public EV3TimeNetSensor(final Coordinates coordinate, final String username){
		this.coordinate = coordinate;
		this.username = username;
	}
	
	private String getWSURL(){
		
		StringBuffer url = new StringBuffer();
		url.append("http://api.geonames.org/timezone");
		url.append("?");
		url.append("lat=");
		url.append(this.coordinate.getLatitude());
		url.append("&");
		url.append("lng=");
		url.append(this.coordinate.getLongitude());
		url.append("&");
		url.append("username=");
		url.append(this.username);
		
		return url.toString();
		
	}
	
	public DateTime getTime() throws IOException, ParserConfigurationException, SAXException, XMLStreamException{
		DateTime dateTime = new DateTime();
		
		//final String WS = "http://api.geonames.org/timezone?lat=40.479732600000000000&lng=-3.589829900000040700&username=jabrena";
    	
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
	
    public static void main(String[] args) throws Exception {
    	
    	Coordinates coordinate = new Coordinates(40.479732600000000000,-3.589829900000040700);
    	
    	EV3TimeNetSensor tns = new EV3TimeNetSensor(coordinate, "jabrena");

    	System.out.println(tns.getTime().toDate().toString());

    }

}
