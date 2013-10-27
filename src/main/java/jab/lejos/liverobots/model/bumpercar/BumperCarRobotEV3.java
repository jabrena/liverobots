package jab.lejos.liverobots.model.bumpercar;

import jab.lejos.liverobots.model.RobotType;

import java.util.Random;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTLightSensor;
import lejos.hardware.sensor.NXTSoundSensor;
import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class BumperCarRobotEV3 extends BumpercarRobot {

	//Sensors
	private NXTSoundSensor leftSound;
	private NXTSoundSensor rightSound;
	private NXTUltrasonicSensor ultrasonic;
	private NXTLightSensor lightSensor;
	
	//Actuators
	private RegulatedMotor leftMotor;
	private RegulatedMotor rightMotor;
	private final int speedMotor = 720;
	
	private DifferentialPilot dPilot;
	private final float wheelDiameter = 4.0F;
	private final float trackWidth = 14.6F;
	private final boolean reverse = false;
	private PoseProvider posep;
	private Navigator nav;
	
	private BumperCarRobotEV3(){
		super(RobotType.EV3);
		leftSound = new NXTSoundSensor(SensorPort.S1);
		rightSound = new NXTSoundSensor(SensorPort.S2);
		leftSound.getDBAMode();
		rightSound.getDBAMode();
		ultrasonic = new NXTUltrasonicSensor(SensorPort.S3);

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
	private static BumperCarRobotEV3 INSTANCE = null;
	
	public static BumperCarRobotEV3 getInstance() {
        if (INSTANCE == null) {
            synchronized(BumperCarRobotEV3.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new BumperCarRobotEV3();
                }
            }
        }
        
        return INSTANCE;
    }

	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	public int getDistance(){
		
		int distance = -1;
		
		float ranges[] = null;
		//ranges[0] = 1;//ultrasonic.G //getRanges();
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
	
	public void forward(int seconds){
		leftMotor.forward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void backward(int seconds){
		leftMotor.backward();
		rightMotor.backward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public void turnRight(int seconds){
		leftMotor.forward();
		rightMotor.backward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}

	public void turnLeft(int seconds){
		leftMotor.backward();
		rightMotor.forward();
		try { Thread.sleep(seconds*1000); } catch (InterruptedException e) {}
		leftMotor.stop(true);
		rightMotor.stop(true);
	}
	
	public int getLeftSound(){
		return 1;
		//return leftSound.readValue();
	}

	public int getRightSound(){
		return 1;
		//return rightSound.readValue();
	}

	public int getDiffSound(){
		return 1;
		//return Math.abs(leftSound.readValue() - rightSound.readValue());
	}
	
	public int getLightLeve(){
		return 1;
		//System.out.println(lightSensor.getLightValue());
		//System.out.println(lightSensor.getNormalizedLightValue());
		//return lightSensor.getNormalizedLightValue();
	}
	
	public void shortSound(int tones, int freqValue){
		Random rnd = new Random();
	    for(int i=0; i<=tones; i++){
	        int frequency = rnd.nextInt(freqValue);
	        int duration = rnd.nextInt(1000);
	        Sound.setVolume(rnd.nextInt(20));
	        Sound.playTone(i*frequency, duration);
	        try { Thread.sleep(100); } catch (InterruptedException e) {}
	    }		
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
