package jab.lejos.liverobots.model.beetle;

import jab.lejos.liverobots.model.RobotType;
import jab.lejos.utils.stats.Statistics;

import java.util.Random;

import lejos.nxt.I2CPort;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.addon.CompassHTSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class BeetleRobotEV3 extends BeetleRobot {

	//Sensors
	private final int PING_DISTANCES = 8;	
	private UltrasonicSensor frontUltrasonic;
	private UltrasonicSensor leftUltrasonic;
	private UltrasonicSensor rightUltrasonic;
	private CompassHTSensor compass;
	
	//Actuators
	private RegulatedMotor leftMotor;
	private RegulatedMotor rightMotor;
	private final int speedMotor = 720;
	
	private DifferentialPilot dPilot;
	private final float wheelDiameter = 4.5F;
	private final float trackWidth = 14.7F;
	private final boolean reverse = false;
	private PoseProvider posep;
	private Navigator nav;
	
	private BeetleRobotEV3(){
		super(RobotType.EV3);

		leftUltrasonic = new UltrasonicSensor((I2CPort) SensorPort.S1);
		frontUltrasonic = new UltrasonicSensor((I2CPort) SensorPort.S2);
		rightUltrasonic = new UltrasonicSensor((I2CPort) SensorPort.S3);
		compass = new CompassHTSensor((I2CPort) SensorPort.S4);

		leftMotor = Motor.A;
		rightMotor = Motor.C;
		leftMotor.setSpeed(speedMotor);
		rightMotor.setSpeed(speedMotor);
		
		//TODO Add a local navigation system
		dPilot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
		posep = new OdometryPoseProvider(dPilot);
		nav = new Navigator(dPilot,posep);
		Pose start = new Pose(0,0,0);
		
	}
	
	//Singleton pattern
	private static BeetleRobotEV3 INSTANCE = null;
	
	public static BeetleRobotEV3 getInstance() {
        if (INSTANCE == null) {
            synchronized(BeetleRobotEV3.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new BeetleRobotEV3();
                }
            }
        }
        
        return INSTANCE;
    }

	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	/**
	 * 	IDEA: http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/USPingTest.java
	 */
	public int getFrontDistance(){
		
		int distance = -1;

		int[] distances = new int[PING_DISTANCES];
		frontUltrasonic.getDistances(distances);
	    double[] tempArray = new double[distances.length];
        System.arraycopy(distances, 0, tempArray, 0, tempArray.length);
        Statistics stat = new Statistics(tempArray);
        System.out.println(stat.getMedian());
        System.out.println(Math.floor(stat.getMedian()));
        
        distance = (int) Math.floor(stat.getMedian());

		/*
		float ranges[];
		ranges = frontUltrasonic.getRanges();
		if(ranges.length > 0){
			if(ranges.length == 1){
				distance = Math.round(ranges[0]);
			}else if(ranges.length == 2){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/2);
			}else if(ranges.length == 3){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/3);
			}
		}
		*/
		return distance;
	}

	public int getLeftDistance(){
		
		int distance = -1;
		
		float ranges[];
		ranges = leftUltrasonic.getRanges();
		if(ranges.length > 0){
			if(ranges.length == 1){
				distance = Math.round(ranges[0]);
			}else if(ranges.length == 2){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/2);
			}else if(ranges.length == 3){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/3);
			}
		}
		
		return distance;
	}

	public int getRightDistance(){
		
		int distance = -1;
		
		float ranges[];
		ranges = rightUltrasonic.getRanges();
		if(ranges.length > 0){
			if(ranges.length == 1){
				distance = Math.round(ranges[0]);
			}else if(ranges.length == 2){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/2);
			}else if(ranges.length == 3){
				distance = Math.round((
						Math.round(ranges[0]) + 
						Math.round(ranges[1])
						)/3);
			}
		}
		
		return distance;
	}
	
	/**
	 * 
	 */
	public int getHeading(){
		return (int) Math.floor(compass.getDegreesCartesian());
	}
	
	
	public void goAhead(int seconds){
		leftMotor.forward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void goBack(int seconds){
		leftMotor.backward();
		rightMotor.backward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void goRight(int seconds){
		leftMotor.forward();
		rightMotor.backward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}

	public void goLeft(int seconds){
		leftMotor.backward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}

	public int getBatteryVoltage() {
		int voltage  = 0;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(500);
		if(randomInt < 200){
			voltage = randomInt;
		}else{
			voltage = 500;
		}
		voltage = 500;
		return voltage;
	}
	
}
