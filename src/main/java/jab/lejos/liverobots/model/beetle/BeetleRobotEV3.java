package jab.lejos.liverobots.model.beetle;

import jab.lejos.liverobots.model.RobotType;
import java.util.Random;

import lejos.nxt.EV3IRSensor;
import lejos.nxt.I2CPort;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UARTPort;
import lejos.nxt.addon.CompassHTSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class BeetleRobotEV3 extends BeetleRobot {

	//Sensors
	private EV3IRSensor leftUltrasonic;
	private EV3IRSensor frontUltrasonic;
	private EV3IRSensor rightUltrasonic;
	private CompassHTSensor compass;
	
	//Actuators
	private RegulatedMotor leftMotor;
	private RegulatedMotor rightMotor;
	private final int speedMotor = 720;
	
	private DifferentialPilot differentialPilot;
	private final float wheelDiameter = 4.5F;
	private final float trackWidth = 14.7F;
	private final boolean reverse = true;
	private PoseProvider posep;
	private Navigator navigator;
	
	private final int TRAVEL_DISTANCE = 20;
	
	private BeetleRobotEV3(){
		super(RobotType.EV3);

		leftUltrasonic = new EV3IRSensor((UARTPort) SensorPort.S1);
		frontUltrasonic = new EV3IRSensor((UARTPort) SensorPort.S2);
		rightUltrasonic = new EV3IRSensor((UARTPort) SensorPort.S3);
		compass = new CompassHTSensor((I2CPort) SensorPort.S4);

		leftMotor = Motor.A;
		rightMotor = Motor.C;
		leftMotor.setSpeed(speedMotor);
		rightMotor.setSpeed(speedMotor);
		
		//TODO Add a local navigation system
		differentialPilot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
		posep = new OdometryPoseProvider(differentialPilot);
		navigator = new Navigator(differentialPilot,posep);
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
	
	public int getFrontDistance(){
		return (int) frontUltrasonic.getRange();
	}

	public int getLeftDistance(){
		return (int) leftUltrasonic.getRange();
	}

	public int getRightDistance(){
		return (int) rightUltrasonic.getRange();
	}

	public int getHeading(){
		return (int) Math.floor(compass.getDegreesCartesian());
	}
	
	
	public void goAhead(int parameter){
		differentialPilot.travel(-TRAVEL_DISTANCE,true);
	}
	
	public void goBack(int parameter){
		differentialPilot.travel(+TRAVEL_DISTANCE,true);
	}
	
	public void goRight(int parameter){
		differentialPilot.rotate(45,true);
	}

	public void goLeft(int parameter){
		differentialPilot.rotate(-45,true);
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
