package jab.lejos.liverobots.websocket;

import jab.lejos.liverobots.fsm.model.bumpercar.BumpercarRobot;
import jab.lejos.liverobots.fsm.model.bumpercar.BumperCarRobotFactory;
import jab.lejos.liverobots.fsm.model.RobotFactoryException;
import jab.lejos.liverobots.fsm.model.RobotType;
import jab.lejos.liverobots.websocket.BrityWebSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.java_websocket.WebSocketImpl;


public class RemoteControlTest {
	
	public static void main( String[] args ) throws InterruptedException , IOException, RobotFactoryException {
		BumpercarRobot robot = BumperCarRobotFactory.getRobot(RobotType.EV3);
		
		WebSocketImpl.DEBUG = true;
		int port = 20000;
		BrityWebSocket s = new BrityWebSocket(port, robot);
		s.start();
		System.out.println( "Websocket started on port: " + s.getPort() );

		//TODO I am not sure how to manage this kind of commands.
		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) {
			String in = sysin.readLine();
			
			s.sendToAll( in );
			if( in.equals( "exit" ) ) {
				s.stop();
				break;
			} else if( in.equals( "restart" ) ) {
				s.stop();
				s.start();
				break;
			}
		}
	}
}
