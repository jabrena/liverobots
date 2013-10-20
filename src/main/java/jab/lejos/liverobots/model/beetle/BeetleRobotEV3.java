package jab.lejos.liverobots.model.beetle;

import jab.lejos.liverobots.model.RobotType;

import java.util.ArrayList;
import java.util.List;
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
	private final boolean reverse = false;
	private PoseProvider posep;
	private Navigator navigator;
	private Pose currentPose;
	private List<Pose> poseList;
	
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
		currentPose = new Pose(0,0,this.getHeading());
		poseList = new ArrayList<Pose>();
		poseList.add(currentPose);
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
	
	public float getFrontDistance(){
		return frontUltrasonic.getRange();
	}

	public float getLeftDistance(){
		return leftUltrasonic.getRange();
	}

	public float getRightDistance(){
		return rightUltrasonic.getRange();
	}

	public float getHeading(){
		return compass.getDegreesCartesian();
	}

	private void updatePose(){
		currentPose = posep.getPose();
		currentPose.setHeading(this.getHeading());
		poseList.add(currentPose);
	}
	
	public void goAhead(int parameter){
		differentialPilot.travel(-TRAVEL_DISTANCE,true);
		updatePose();
	}
	
	public void goBack(int parameter){
		differentialPilot.travel(+TRAVEL_DISTANCE,true);
		updatePose();
	}
	
	public void goRight(int parameter){
		differentialPilot.rotate(45,true);
		updatePose();
	}

	public void goLeft(int parameter){
		differentialPilot.rotate(-45,true);
		updatePose();
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
	
	public void travel(int distance){
		differentialPilot.travel(distance);
		differentialPilot.stop();
		updatePose();
	}

	public void rotate(int degrees){
		differentialPilot.travel(degrees,true);
		updatePose();
	}
	
	//Mapping
	
	public Pose getPose(){
		return currentPose;
	}
	
	public void setPose(final Pose pose){
		currentPose = pose;
	}
	
	public List<Pose> getPoseList(){
		return poseList;
	}
	
}
